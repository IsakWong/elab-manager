package elab.business.module_function_controllers.member_module_function_controllers.user_management_page_controllers;

import elab.application.BaseFunctionContentController;
import elab.database.DatabaseOperations;
import elab.database.Session;
import elab.serialization.beans.student.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class StudentInformationPageController extends BaseFunctionContentController {

    @FXML
    private TableView<Student> tableView;
    @FXML
    private TableColumn<Student, String> number;
    @FXML
    private TableColumn<Student, String> name;
    @FXML
    private TableColumn<Student, String> college;
    @FXML
    private TableColumn<Student, Integer> hardTime;
    @FXML
    private TableColumn<Student, Integer> softTime;
    @FXML
    private TableColumn<Student, Integer> hardScore;
    @FXML
    private TableColumn<Student, Integer> softScore;
    @FXML
    private TableColumn<Student, Integer> paperScore;
    @FXML
    private TableColumn<Student, String> tel;

    private Boolean isInit = false;

    Session<List> queryStudentSession = new Session<List>() {
        @Override
        public void onPostFetchResult(SessionResult<List> sessionResult) {
            sessionResult.result = DatabaseOperations.getInstance().selectAllStudents();
            if(sessionResult.result == null)
                sessionResult.errorMessage="无法获取本学期的学生信息";
        }

        @Override
        public void onSuccess(List param) {
            ObservableList<Student> students = FXCollections.<Student>observableArrayList();
            students.addAll(param);
            tableView.setItems(students);
            isInit = true;
        }

        @Override
        public void onError(String errorMessage) {
            popupMessage(errorMessage,3000);
        }

        @Override
        public void onBusy() {
            popupMessage("正在获取信息中",3000);
        }
    };

    @Override
    public void initializeController() {
        queryStudentSession.send();
        number.setCellValueFactory(new PropertyValueFactory<Student, String>("number"));
        name.setCellValueFactory(new PropertyValueFactory<Student, String>("name"));
        college.setCellValueFactory(new PropertyValueFactory<Student, String>("college"));
        hardTime.setCellValueFactory(new PropertyValueFactory<Student, Integer>("hardTime"));
        softTime.setCellValueFactory(new PropertyValueFactory<Student, Integer>("softTime"));
        hardScore.setCellValueFactory(new PropertyValueFactory<Student, Integer>("hardScore"));
        softScore.setCellValueFactory(new PropertyValueFactory<Student, Integer>("softScore"));
        paperScore.setCellValueFactory(new PropertyValueFactory<Student, Integer>("paperScore"));
        tel.setCellValueFactory(new PropertyValueFactory<Student, String>("tel"));
    }

    public Boolean isInit() {
        return isInit;
    }
}
