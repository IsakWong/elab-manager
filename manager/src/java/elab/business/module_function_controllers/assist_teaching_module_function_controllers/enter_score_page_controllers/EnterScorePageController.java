package elab.business.module_function_controllers.assist_teaching_module_function_controllers.enter_score_page_controllers;

import com.jfoenix.controls.*;
import elab.application.BaseFunctionContentController;
import elab.application.ElabManagerApplication;
import elab.database.DatabaseOperations;
import elab.database.Session;
import elab.serialization.beans.log.Log;
import elab.serialization.beans.student.Student;
import elab.util.Utilities;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.HBox;

import javax.swing.*;
import java.time.LocalDate;
import java.util.List;

public class EnterScorePageController extends BaseFunctionContentController {

    @FXML
    private JFXDatePicker date;
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
    private TextField hardScoreInput;
    @FXML
    private TextField softScoreInput;
    @FXML
    private TextField paperScoreInput;
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

    private ObservableList<Student> students = FXCollections.observableArrayList();

    Session<Boolean> writeLogSession = new Session<Boolean>() {
        @Override
        public void onPostFetchResult(SessionResult<Boolean> sessionResult) {
            Log log = new Log();
            log.setInformation("修改成绩");
            log.setOperatingNumber(ElabManagerApplication.properties.getProperty("LAST_LOG_IN_USER"));
            log.setTime(Utilities.getSystemDate("yyyy-MM-dd HH:mm:ss"));
            log.setIP(Utilities.getIP());
            log.setVersion(ElabManagerApplication.properties.getProperty("VERSION"));
            log.setTerm(DatabaseOperations.getInstance().selectSchoolOpeningDateInformation().getTerm());
            log.setID(null);
            log.setOperatedNumber(null);
            log.setHardScore(null);
            log.setSoftScore(null);
            log.setPaperScore(null);
            DatabaseOperations.getInstance().writeLog(log);
        }

        @Override
        public void onSuccess(Boolean param) {
        }

        @Override
        public void onError(String errorMessage) {
        }

        @Override
        public void onBusy() {
        }
    };

    Session<List> queryStudentSession = new Session<List>() {
        @Override
        public void onPostFetchResult(SessionResult<List> sessionResult) {
            sessionResult.result = DatabaseOperations.getInstance().selectAllStudents("2018秋" + "_计算机安装与调试技术");
            if(sessionResult.result == null)
                sessionResult.errorMessage = "";
        }

        @Override
        public void onSuccess(List param) {
            students.clear();
            students.addAll(param);
            finishLoading();
            resultTable.setItems(students);
            peopleAmount.setText("共" + students.size() + "人");
        }

        @Override
        public void onError(String errorMessage) {
            finishLoading();
            Object[] options ={"确定"};
            JOptionPane.showOptionDialog(null, "本学期上课学生信息未导入，请联系管理员", "注意", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
        }

        @Override
        public void onBusy() {
            popupMessage("正在获取信息中",1500);
        }
    };

    Session<Boolean> updateScoreSession = new Session<Boolean>() {
        @Override
        public void onPostFetchResult(SessionResult<Boolean> sessionResult) {
            student.setHardScore(Integer.parseInt(hardScoreInput.getText()));
            student.setSoftScore(Integer.parseInt(softScoreInput.getText()));
            student.setPaperScore(Integer.parseInt(paperScoreInput.getText()));
            sessionResult.result = DatabaseOperations.getInstance().updateScore(student);
        }

        @Override
        public void onSuccess(Boolean param) {
            resultTable.refresh();
            hardScoreInput.setText("");
            softScoreInput.setText("");
            paperScoreInput.setText("");
            writeLogSession.send();
        }

        @Override
        public void onError(String errorMessage) {
            popupMessage("成绩更新失败",1500);
        }

        @Override
        public void onBusy() {
            popupMessage("正在更新成绩",1500);
        }
    };

    @Override
    public void initializeController() {
        try {
            queryStudentSession.send();
            number.setCellValueFactory(new PropertyValueFactory<Student, String>("number"));
            name.setCellValueFactory(new PropertyValueFactory<Student, String>("name"));
            college.setCellValueFactory(new PropertyValueFactory<Student, String>("college"));
            hardScore.setCellValueFactory(new PropertyValueFactory<Student, Integer>("hardScore"));
            softScore.setCellValueFactory(new PropertyValueFactory<Student, Integer>("softScore"));
            paperScore.setCellValueFactory(new PropertyValueFactory<Student, Integer>("paperScore"));
            tel.setCellValueFactory(new PropertyValueFactory<Student, String>("tel"));

            resultTable.setPlaceholder(new Label("无上课同学"));

            /**
             * TableView行选中事件监听
             */

            resultTable.getSelectionModel().selectedItemProperty().addListener(
                    (ChangeListener<Student>) (observable, oldValue, newValue) -> {
                        ParentModuleController.beginLoading();
                        student = newValue;
                        numberLabel.setText("学号：" + student.getNumber());
                        nameLabel.setText("姓名：" + student.getName());
                    }
            );


            logBtn.setOnMouseClicked(event -> {
                if (event.getButton() == MouseButton.PRIMARY) {
                    if (!numberLabel.getText().equals("")) {
                        updateScoreSession.send();
                    } else {
                        Utilities.popMessage("请选择学生信息", container);
                    }
                }
            });

            /**
             * DatePicker日期选中事件监听
             */

            date.getEditor().textProperty().addListener(
                    (observable, oldValue, newValue) -> {
                        if (!LocalDate.now().toString().equals(newValue)) logBtn.setDisable(true);
                        else logBtn.setDisable(false);
                    }
            );

            schoolDate.setText("第" + Integer.toString(Utilities.getSchoolCalendarWeek()) + "周 " + Utilities.getSystemWeek());
            course.setText(Utilities.getCourseSort());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
