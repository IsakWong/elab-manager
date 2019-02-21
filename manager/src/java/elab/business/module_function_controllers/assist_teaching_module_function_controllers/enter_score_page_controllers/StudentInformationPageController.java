package elab.business.module_function_controllers.assist_teaching_module_function_controllers.enter_score_page_controllers;

import elab.application.BaseViewController;
import elab.database.DatabaseOperations;
import elab.serialization.beans.student.Student;
import elab.util.Utilities;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.rxjavafx.schedulers.JavaFxScheduler;
import io.reactivex.schedulers.Schedulers;
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


    }
}
