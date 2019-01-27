package elab.business.assist_teaching_page_controllers;

import elab.application.BaseViewController;
import elab.database.DatabaseOperations;
import elab.serialization.student.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class SearchResultPageController extends BaseViewController {
    @FXML
    private TableView tableView;
    @FXML
    private TableColumn<Student, String> number;
    @FXML
    private TableColumn<Student, String> name;
    @FXML
    private TableColumn<Student, String> college;
    @FXML
    private TableColumn<Student, Integer> hardScore;
    @FXML
    private TableColumn<Student, Integer> softScore;
    @FXML
    private TableColumn<Student, Integer> paperScore;
    @FXML
    private TableColumn<Student, String> tel;

    private ObservableList<Student> students = FXCollections.<Student>observableArrayList();

    public void showResult(List student) {
        if(students != null) students.remove(0, students.size());
        students.addAll(student);
        tableView.setItems(students);
    }

    public void showResult() {
        if(students != null) students.remove(0, students.size());
        tableView.setItems(students);
    }

    @Override
    public void initializeController() {

        number.setCellValueFactory(new PropertyValueFactory<Student, String>("number"));
        name.setCellValueFactory(new PropertyValueFactory<Student, String>("name"));
        college.setCellValueFactory(new PropertyValueFactory<Student, String>("college"));
        hardScore.setCellValueFactory(new PropertyValueFactory<Student, Integer>("hardScore"));
        softScore.setCellValueFactory(new PropertyValueFactory<Student, Integer>("softScore"));
        paperScore.setCellValueFactory(new PropertyValueFactory<Student, Integer>("paperScore"));
        tel.setCellValueFactory(new PropertyValueFactory<Student, String>("tel"));
        tableView.setPlaceholder(new Label("未搜索到学生信息"));
    }
}
