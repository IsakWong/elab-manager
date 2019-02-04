package elab.business.module_function_controllers.assist_teaching_module_function_controllers.enter_score_page_controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTabPane;
import elab.application.BaseViewController;
import elab.database.DatabaseOperations;
import elab.serialization.beans.student.Student;
import elab.util.Utilities;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.HBox;

import java.time.LocalDate;
import java.util.List;

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
            FXMLLoader studentInformationLoader = new FXMLLoader(getClass().getResource("/business_pages/module_function_pages/assist_teaching_module_function_pages/enter_score_pages/student_information_page.fxml"));
            Parent studentInformationRoot = studentInformationLoader.load();
            studentInformationPageController = studentInformationLoader.getController();
            studentInformationPageController.setLabel(numberLabel, nameLabel);
            studentInformationPageController.initializeController();
            studentTab.setContent(studentInformationRoot);
            tabPane.getTabs().add(studentTab);

            FXMLLoader searchResultLoader = new FXMLLoader(getClass().getResource("/business_pages/module_function_pages/assist_teaching_module_function_pages/enter_score_pages/search_result_page.fxml"));
            Parent searchResultRoot = searchResultLoader.load();
            searchResultPageController = searchResultLoader.getController();
            searchResultPageController.initializeController();
            searchResult.setContent(searchResultRoot);
            tabPane.getTabs().add(searchResult);

            selectBtn.setOnMouseClicked(event -> {
                if (event.getButton() == MouseButton.PRIMARY) {
                    if(!numberInput.getText().equals("")) {
                        List list = DatabaseOperations.getInstance().selectStudentByNumber(numberInput.getText());
                        if(!nameInput.getText().equals("")) {
                            Utilities.filter(list, nameInput.getText(), 1);
                            searchResultPageController.showResult(list);
                        }
                        else searchResultPageController.showResult(list);
                    }
                    else if(!nameInput.getText().equals("")) searchResultPageController.showResult(DatabaseOperations.getInstance().selectStudentByName(nameInput.getText()));
                    else searchResultPageController.showResult();
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
                            if (!LocalDate.now().toString().equals(newValue)) logBtn.setDisable(true);
                            else logBtn.setDisable(false);
                        }
                    }
            );

            schoolDate.setText("第" + Integer.toString(Utilities.getSchoolCalendarWeek()) + "周 " + Utilities.getSystemWeek());
            course.setText(Utilities.getCourseSort());
            peopleAmount.setText("共" + studentInformationPageController.getStudentAmount() + "人");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
