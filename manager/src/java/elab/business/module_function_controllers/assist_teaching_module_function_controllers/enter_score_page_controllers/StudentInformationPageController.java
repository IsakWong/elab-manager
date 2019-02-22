package elab.business.module_function_controllers.assist_teaching_module_function_controllers.enter_score_page_controllers;

import elab.application.BaseFunctionContentController;
import elab.serialization.beans.student.Student;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class StudentInformationPageController extends BaseFunctionContentController {

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

    private Student student;

    private Label numberLabel;
    private Label nameLabel;

    private int studentAmount;

    public String getStudentAmount() {return Integer.toString(studentAmount);}

    public Student getStudent() {
        return student;
    }

    public TableView getTableView() {
        return tableView;
    }

    public void setLabel(Label numberLabel, Label nameLabel) {
        this.numberLabel = numberLabel;
        this.nameLabel = nameLabel;
    }

    @Override
    public void initializeController() {


    }
}
