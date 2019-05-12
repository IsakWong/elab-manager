package elab.business.module_function_controllers.settings;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import elab.application.BaseFunctionContentController;
import elab.database.DatabaseOperations;
import elab.database.Session;
import elab.serialization.beans.school_opening_information.SchoolOpeningInformation;
import elab.util.Utilities;
import javafx.fxml.FXML;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class ManagerResetPageController extends BaseFunctionContentController {

    @FXML
    private JFXDatePicker termStartDatePicker;
    @FXML
    private JFXComboBox<String> hardStartBox;
    @FXML
    private JFXComboBox<String> hardEndBox;
    @FXML
    private JFXComboBox<String> softStartBox;
    @FXML
    private JFXComboBox<String> softEndBox;
    @FXML
    private JFXButton saveBtn;
    @FXML
    private VBox container;

    private Paint unfocusedColor;

    private JFXTextField datePickerEditer;

    Session<Boolean> setMessageSession = new Session<Boolean>() {
        @Override
        public void onPostFetchResult(SessionResult<Boolean> sessionResult) {
            SchoolOpeningInformation schoolOpeningInformation = new SchoolOpeningInformation();
            schoolOpeningInformation.setSchoolOpeningDate(termStartDatePicker.getValue() + " 00:00:00");
            schoolOpeningInformation.setHardWeeks(hardStartBox.getValue() + "~" + hardEndBox.getValue());
            schoolOpeningInformation.setHardTheory(Utilities.getWeekFirstDayDate(schoolOpeningInformation.getSchoolOpeningDate(), Integer.parseInt(hardStartBox.getValue()), 1));
            schoolOpeningInformation.setSoftWeeks(softStartBox.getValue() + "~" + softEndBox.getValue());
            schoolOpeningInformation.setSoftTheory(Utilities.getWeekFirstDayDate(schoolOpeningInformation.getSchoolOpeningDate(), Integer.parseInt(softStartBox.getValue()), 1));
            schoolOpeningInformation.setTerm(Utilities.getTerm());
            sessionResult.result = DatabaseOperations.getInstance().setSchoolOpeningDateInformation(schoolOpeningInformation);
            Utilities.setSchoolOpeningInformation(DatabaseOperations.getInstance().selectSchoolOpeningDateInformation());
            if(sessionResult.result == null)
                sessionResult.errorMessage = "信息更新失败";
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

    private void initInformation() {
        try {
            SchoolOpeningInformation schoolOpeningInformation = Utilities.getSchoolOpeningInformation();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date termStartDate = simpleDateFormat.parse(schoolOpeningInformation.getSchoolOpeningDate());
            Instant instant = termStartDate.toInstant();
            ZoneId zoneId = ZoneId.systemDefault();
            LocalDate termStartLocalDate = instant.atZone(zoneId).toLocalDate();
            termStartDatePicker.setValue(termStartLocalDate);

            String[] hardWeeks = schoolOpeningInformation.getHardWeeks().split("~");
            hardStartBox.setValue(hardWeeks[0]);
            hardEndBox.setValue(hardWeeks[1]);
            for(int startWeek = Integer.parseInt(hardWeeks[0]) + 1; startWeek < 17; ++startWeek)
                hardEndBox.getItems().add(Integer.toString(startWeek));
            String[] softWeeks = schoolOpeningInformation.getSoftWeeks().split("~");
            softStartBox.setValue(softWeeks[0]);
            softEndBox.setValue(softWeeks[1]);
            for(int startWeek = Integer.parseInt(softWeeks[0]) + 1; startWeek < 17; ++startWeek)
                softEndBox.getItems().add(Integer.toString(startWeek));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initializeController() {

        datePickerEditer = (JFXTextField)termStartDatePicker.getEditor();

        unfocusedColor = Color.valueOf("000000");

        for(int i = 1; i < 17; ++i) {
            hardStartBox.getItems().add(Integer.toString(i));
            softStartBox.getItems().add(Integer.toString(i));
        }

        initInformation();

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
                    datePickerEditer.setUnFocusColor(Color.RED);
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
                if(isAllMessageFinished) {
                    Utilities.popMessage("正在更新信息", container);
                    setMessageSession.send();
                }
                else
                    popupMessage("请检查所有信息!", 1500);
            }
        });

        JFXTextField editor = (JFXTextField) termStartDatePicker.getEditor();

        termStartDatePicker.setOnMouseClicked(event -> {
            if(event.getButton() == MouseButton.PRIMARY)
                datePickerEditer.setUnFocusColor(unfocusedColor);
        });

        datePickerEditer.setOnMouseClicked(event -> {
            if(event.getButton() == MouseButton.PRIMARY)
                datePickerEditer.setUnFocusColor(unfocusedColor);
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

        finishLoading();
    }
}
