package elab.business.module_function_controllers.assist_teaching_module_function_controllers.enter_score_page_controllers;

import elab.application.BaseViewController;
import elab.database.DatabaseOperations;
import elab.serialization.beans.student.Student;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
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

        number.setCellValueFactory(new PropertyValueFactory<Student, String>("number"));
        name.setCellValueFactory(new PropertyValueFactory<Student, String>("name"));
        college.setCellValueFactory(new PropertyValueFactory<Student, String>("college"));
        hardScore.setCellValueFactory(new PropertyValueFactory<Student, Integer>("hardScore"));
        softScore.setCellValueFactory(new PropertyValueFactory<Student, Integer>("softScore"));
        paperScore.setCellValueFactory(new PropertyValueFactory<Student, Integer>("paperScore"));
        tel.setCellValueFactory(new PropertyValueFactory<Student, String>("tel"));
        ObservableList<Student> students = FXCollections.<Student>observableArrayList();
        students.addAll(DatabaseOperations.getInstance().selectAllStudents());
        studentAmount = students.size();
        tableView.setItems(students);
        tableView.setPlaceholder(new Label("当天无上课同学"));

        /**
         * TableView行选中事件监听
         */

        tableView.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Student>() {
                    @Override
                    public void changed(ObservableValue<? extends Student> observable, Student oldValue, Student newValue) {
                        student = newValue;
                        numberLabel.setText(student.getNumber());
                        nameLabel.setText(student.getName());
                        System.out.println(student);
                    }
                }
        );
    }
}
