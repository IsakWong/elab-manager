package elab.business.assist_teaching_function_controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTabPane;
import elab.application.BaseViewController;
import elab.business.assist_teaching_page_controllers.SearchResultPageController;
import elab.business.assist_teaching_page_controllers.StudentInformationPageController;
import elab.database.DatabaseOperations;
import elab.serialization.student.Student;
import elab.util.Utilities;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.HBox;

import java.time.LocalDate;

public class EnterScorePageController extends BaseViewController {

    @FXML
    private DatePicker datePicker;
    @FXML
    private Label schoolDate;
    @FXML
    private Label course;
    @FXML
    private Label peopleAmount;
    @FXML
    private Label nameLabel;
    @FXML
    private Label numberLabel;
    @FXML
    private TextField numberInput;
    @FXML
    private TextField nameInput;
    @FXML
    private TextField hardScoreInput;
    @FXML
    private TextField softScoreInput;
    @FXML
    private TextField paperScoreInput;
    @FXML
    private JFXButton selectBtn;
    @FXML
    private JFXButton logBtn;
    @FXML
    private JFXTabPane tabPane;
    @FXML
    private HBox container;

    private Tab searchResult = new Tab("搜索结果");
    private StudentInformationPageController studentInformationPageController;
    private SearchResultPageController searchResultPageController;

    @Override
    public void initializeController() {

        try {

            Tab studentTab = new Tab("上课同学");
            FXMLLoader studentInformationLoader = new FXMLLoader(getClass().getResource("/enter_score_page/student_information_page.fxml"));
            Parent studentInformationRoot = studentInformationLoader.load();
            studentInformationPageController = studentInformationLoader.getController();
            studentInformationPageController.setLabel(numberLabel, nameLabel);
            studentInformationPageController.initializeController();
            studentTab.setContent(studentInformationRoot);
            tabPane.getTabs().add(studentTab);

            FXMLLoader searchResultLoader = new FXMLLoader(getClass().getResource("/enter_score_page/search_result_page.fxml"));
            Parent searchResultRoot = searchResultLoader.load();
            searchResultPageController = searchResultLoader.getController();
            searchResultPageController.initializeController();
            searchResult.setContent(searchResultRoot);
            tabPane.getTabs().add(searchResult);

            selectBtn.setOnMouseClicked(event -> {
                if (event.getButton() == MouseButton.PRIMARY) {
                    //////////////////////////////////////////////////////////////////////////////////////////////
                    tabPane.getSelectionModel().select(searchResult);
                }
            });

            logBtn.setOnMouseClicked(event -> {
                if (event.getButton() == MouseButton.PRIMARY) {
                    if(!numberLabel.getText().equals("")) {
                        Student student = studentInformationPageController.getStudent();
                        student.setHardScore(Integer.parseInt(hardScoreInput.getText()));
                        student.setSoftScore(Integer.parseInt(softScoreInput.getText()));
                        student.setPaperScore(Integer.parseInt(paperScoreInput.getText()));
                        DatabaseOperations.getInstance().updateScore(student);
                        TableView tableView = studentInformationPageController.getTableView();
                        tableView.refresh();
                        hardScoreInput.setText("");
                        softScoreInput.setText("");
                        paperScoreInput.setText("");
                    }
                    else {
                        Utilities.popMessage("请选择学生信息", container);
                    }
                }
            });

            /**
             * DatePicker日期选中事件监听
             */

            datePicker.getEditor().textProperty().addListener(
                    new ChangeListener<String>() {
                        @Override
                        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                            System.out.println(newValue);
                            if (!LocalDate.now().toString().equals(newValue)) logBtn.setDisable(true);
                            else logBtn.setDisable(false);
                        }
                    }
            );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
