package elab.business.module_function_controllers.settings;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import elab.application.BaseFunctionContentController;
import elab.database.DatabaseOperations;
import elab.database.Session;
import javafx.fxml.FXML;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class ManagerResetPageController extends BaseFunctionContentController {

    @FXML
    private JFXDatePicker termStartDatePicker;
    @FXML
    private AnchorPane datePickerPane;
    @FXML
    private JFXComboBox<String> hardStartBox;
    @FXML
    private JFXComboBox<String> hardEndBox;
    @FXML
    private JFXComboBox<String> softStartBox;
    @FXML
    private JFXComboBox<String> softEndBox;
    @FXML
    private JFXTextField termField;
    @FXML
    private JFXButton saveBtn;

    private Paint unfocusedColor;

    Session<Boolean> setMessageSession = new Session<Boolean>() {
        @Override
        public void onPostFetchResult(SessionResult<Boolean> sessionResult) {
            DatabaseOperations.getInstance().setTermStartDate(termStartDatePicker.getValue() + " 00:00:00");
            DatabaseOperations.getInstance().setHardWeeks(hardStartBox.getValue() + "~" + hardEndBox.getValue());
            DatabaseOperations.getInstance().setSoftWeeks(softStartBox.getValue() + "~" + softEndBox.getValue());
            DatabaseOperations.getInstance().setTerm(termField.getText());
            popupMessage("正在更新信息", 1500);
        }

        @Override
        public void onSuccess(Boolean param) {
            popupMessage("信息更新成功", 1500);
        }

        @Override
        public void onError(String errorMessage) {
            popupMessage(errorMessage, 1500);
        }

        @Override
        public void onBusy() {
            popupMessage("正在更新信息", 1500);
        }
    };

    @Override
    public void initializeController() {

        unfocusedColor = termField.getUnFocusColor();
        datePickerPane.setStyle("-fx-border-color: #ffffff");

        for(int i = 1; i < 17; ++i) {
            hardStartBox.getItems().add(Integer.toString(i));
            softStartBox.getItems().add(Integer.toString(i));
        }

        termStartDatePicker.getEditor().textProperty().addListener((observable, oldValue, newValue) -> System.out.println(newValue));

        hardStartBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if(!hardEndBox.getItems().isEmpty())
                hardEndBox.getItems().clear();
            for(int startWeek = Integer.parseInt(newValue) + 1; startWeek < 17; ++startWeek)
                hardEndBox.getItems().add(Integer.toString(startWeek));
        });

        softStartBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if(!softEndBox.getItems().isEmpty())
                softEndBox.getItems().clear();
            for(int startWeek = Integer.parseInt(newValue) + 1; startWeek < 17; ++startWeek)
                softEndBox.getItems().add(Integer.toString(startWeek));
        });

        saveBtn.setOnMouseClicked(event -> {
            if(event.getButton() == MouseButton.PRIMARY) {
                Boolean isAllMessageFinished = true;
                if(termStartDatePicker.getValue() == null) {
                    datePickerPane.setStyle("-fx-border-color: #ff0000");
                    isAllMessageFinished = false;
                }
                if(hardStartBox.getValue() == null) {
                    hardStartBox.setUnFocusColor(Color.RED);
                    isAllMessageFinished = false;
                }
                if(hardEndBox.getValue() == null) {
                    hardEndBox.setUnFocusColor(Color.RED);
                    isAllMessageFinished = false;
                }
                if(softStartBox.getValue() == null) {
                    softStartBox.setUnFocusColor(Color.RED);
                    isAllMessageFinished = false;
                }
                if(softEndBox.getValue() == null) {
                    softEndBox.setUnFocusColor(Color.RED);
                    isAllMessageFinished = false;
                }
                if(termField.getText().equals("")) {
                    termField.setUnFocusColor(Color.RED);
                    isAllMessageFinished = false;
                }
                if(isAllMessageFinished)
                    setMessageSession.send();
                else
                    popupMessage("请检查所有信息!", 1500);
            }
        });

        termStartDatePicker.setOnMouseClicked(event -> {
            if(event.getButton() == MouseButton.PRIMARY)
                datePickerPane.setStyle("-fx-border-color: #ffffff");
        });

        hardStartBox.setOnMouseClicked(event -> {
            if(event.getButton() == MouseButton.PRIMARY)
                hardStartBox.setUnFocusColor(unfocusedColor);
        });

        hardEndBox.setOnMouseClicked(event -> {
            if(event.getButton() == MouseButton.PRIMARY)
                hardEndBox.setUnFocusColor(unfocusedColor);
        });

        softStartBox.setOnMouseClicked(event -> {
            if(event.getButton() == MouseButton.PRIMARY)
                softStartBox.setUnFocusColor(unfocusedColor);
        });

        softEndBox.setOnMouseClicked(event -> {
            if(event.getButton() == MouseButton.PRIMARY)
                softEndBox.setUnFocusColor(unfocusedColor);
        });

        termField.setOnMouseClicked(event -> {
            if(event.getButton() == MouseButton.PRIMARY)
                termField.setUnFocusColor(unfocusedColor);
        });

        finishLoading();
    }
}
