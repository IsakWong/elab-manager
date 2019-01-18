package elab.business.member_tab_page_controllers;

import elab.application.BaseViewController;
import elab.database.DatabaseOperations;
import elab.serialization.student.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class StudentInformationPageController extends BaseViewController {

    @FXML
    private TableView tableView;
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

    private ObservableList<Student> students = FXCollections.<Student>observableArrayList();

    @Override
    public void initializeController() {
        students.addAll(DatabaseOperations.getInstance().selectAllStudents());
        System.out.println(students);
        number.setCellValueFactory(new PropertyValueFactory<Student, String>("number"));
        name.setCellValueFactory(new PropertyValueFactory<Student, String>("name"));
        college.setCellValueFactory(new PropertyValueFactory<Student, String>("college"));
        hardTime.setCellValueFactory(new PropertyValueFactory<Student, Integer>("hardTime"));
        softTime.setCellValueFactory(new PropertyValueFactory<Student, Integer>("softTime"));
        hardScore.setCellValueFactory(new PropertyValueFactory<Student, Integer>("hardScore"));
        softScore.setCellValueFactory(new PropertyValueFactory<Student, Integer>("softScore"));
        paperScore.setCellValueFactory(new PropertyValueFactory<Student, Integer>("paperScore"));
        tel.setCellValueFactory(new PropertyValueFactory<Student, String>("tel"));
        tableView.setItems(students);
    }
}
