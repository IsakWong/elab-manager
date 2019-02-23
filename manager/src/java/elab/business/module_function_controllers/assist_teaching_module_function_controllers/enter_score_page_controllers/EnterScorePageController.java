package elab.business.module_function_controllers.assist_teaching_module_function_controllers.enter_score_page_controllers;

import com.jfoenix.controls.*;
import elab.application.BaseFunctionContentController;
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
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.HBox;

import java.time.LocalDate;

public class EnterScorePageController extends BaseFunctionContentController {

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
    private TableView resultTable;
    @FXML
    private HBox container;
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

    private int studentAmount;


    @Override
    public void initializeController() {
        try {
            number.setCellValueFactory(new PropertyValueFactory<Student, String>("number"));
            name.setCellValueFactory(new PropertyValueFactory<Student, String>("name"));
            college.setCellValueFactory(new PropertyValueFactory<Student, String>("college"));
            hardScore.setCellValueFactory(new PropertyValueFactory<Student, Integer>("hardScore"));
            softScore.setCellValueFactory(new PropertyValueFactory<Student, Integer>("softScore"));
            paperScore.setCellValueFactory(new PropertyValueFactory<Student, Integer>("paperScore"));
            tel.setCellValueFactory(new PropertyValueFactory<Student, String>("tel"));
            ObservableList<Student> students = FXCollections.<Student>observableArrayList();
            ObservableOnSubscribe<Boolean> ob = new ObservableOnSubscribe<Boolean>() {

                @Override
                public void subscribe(ObservableEmitter<Boolean> observableEmitter) throws Exception {
                    students.addAll(DatabaseOperations.getInstance().selectAllStudents());
                    studentAmount = students.size();
                    observableEmitter.onNext(true);
                }
            };
            Observable.create(ob)
                    .subscribeOn(Schedulers.io())
                    .observeOn(JavaFxScheduler.platform())
                    .subscribe(new Observer<Boolean>() {
                                   @Override
                                   public void onSubscribe(Disposable disposable) {
                                   }

                                   @Override
                                   public void onNext(Boolean s) {
                                       IsDataInitialized = true;
                                       ParentModuleController.FinishLoading();
                                       resultTable.setItems(students);
                                   }

                                   @Override
                                   public void onError(Throwable throwable) {
                                   }

                                   @Override
                                   public void onComplete() {
                                   }
                               }
                    );

            resultTable.setPlaceholder(new Label("当天无上课同学"));
            /**
             * TableView行选中事件监听
             */

            resultTable.getSelectionModel().selectedItemProperty().addListener(
                    new ChangeListener<Student>() {
                        @Override
                        public void changed(ObservableValue<? extends Student> observable, Student oldValue, Student newValue) {
                            ParentModuleController.BeginLoading();
                            student = newValue;
                            numberLabel.setText("学号：" + student.getNumber());
                            nameLabel.setText("姓名：" + student.getName());
                        }
                    }
            );


            logBtn.setOnMouseClicked(event -> {
                if (event.getButton() == MouseButton.PRIMARY) {

                    if (!numberLabel.getText().equals("")) {
                        student.setHardScore(Integer.parseInt(hardScoreInput.getText()));
                        student.setSoftScore(Integer.parseInt(softScoreInput.getText()));
                        student.setPaperScore(Integer.parseInt(paperScoreInput.getText()));
                        DatabaseOperations.getInstance().updateScore(student);
                        resultTable.refresh();
                        hardScoreInput.setText("");
                        softScoreInput.setText("");
                        paperScoreInput.setText("");
                    } else {
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
            peopleAmount.setText("共" + studentAmount + "人");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
