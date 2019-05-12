package elab.business.module_function_controllers.sys_ctrl_module_function_controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import elab.application.BaseFunctionContentController;
import elab.application.BaseViewController;
import elab.database.DatabaseOperations;
import elab.database.Session;
import elab.serialization.beans.log.Log;
import elab.util.Utilities;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.VBox;
import javafx.util.StringConverter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ViewLogPageController extends BaseFunctionContentController {

    @FXML
    private DatePicker datePicker;
    @FXML
    private JFXTextField operatingNumberField;
    @FXML
    private JFXTextField operatedNumberField;
    @FXML
    private JFXComboBox<String> informationComboBox;
    @FXML
    private JFXButton returnBtn;
    @FXML
    private JFXButton selectBtn;
    @FXML
    private TableView tableView;
    @FXML
    private TableColumn<Log, String> ID;
    @FXML
    private TableColumn<Log, String> operatingNumber;
    @FXML
    private TableColumn<Log, String> time;
    @FXML
    private TableColumn<Log, String> IP;
    @FXML
    private TableColumn<Log, String> operatedNumber;
    @FXML
    private TableColumn<Log, String> hardScore;
    @FXML
    private TableColumn<Log, String> softScore;
    @FXML
    private TableColumn<Log, String> paperScore;
    @FXML
    private TableColumn<Log, String> information;
    @FXML
    private TableColumn<Log, String> version;
    @FXML
    private VBox container;

    private List logList;
    private Boolean isInit = false;

    /**
     * 由于日期格式与规定格式重复，selectLogs()的index在2后的均加一
     * (详情请看数据表中的"操作时间"列以及Utilities.filter())
     */

    Session<List> selectLogSession = new Session<List>() {
        @Override
        public void onPostFetchResult(SessionResult<List> sessionResult) {
            sessionResult.result = DatabaseOperations.getInstance().selectAllLogs(Utilities.getTerm());
            if(sessionResult.result == null) {
                sessionResult.errorMessage = "无法获取log信息";
            }
        }

        @Override
        public void onSuccess(List param) {
            if(isInit)
                Utilities.popMessage("正在查询信息", container);
            ObservableList<Log> chooseLogs = FXCollections.observableArrayList();
            if(!(datePicker.getValue() == null)) Utilities.filter(param, datePicker.getValue().toString(), 2);
            if(!operatingNumberField.getText().equals("")) Utilities.filter(param, 1, "\t" + operatingNumberField.getText());
            if(!operatedNumberField.getText().equals("")) Utilities.filter(param, 5, "\t" + operatedNumberField.getText());
            if(!informationComboBox.getValue().equals("所有信息")) Utilities.filter(param, informationComboBox.getValue(), 9);
            chooseLogs.addAll(param);
            tableView.setItems(chooseLogs);
            tableView.refresh();
        }

        @Override
        public void onError(String errorMessage) {
            popupMessage(errorMessage, 3000);
        }

        @Override
        public void onBusy() {
            popupMessage("正在获取信息，请稍候", 3000);
        }
    };

    Session<List> queryLogSession = new Session<List>() {
        @Override
        public void onPostFetchResult(SessionResult<List> sessionResult) {
            sessionResult.result = DatabaseOperations.getInstance().selectAllLogs(Utilities.getTerm());
            if(sessionResult.result == null)
                sessionResult.errorMessage="无法获取Log信息";
        }

        @Override
        public void onSuccess(List param) {
            logList = param;
            ObservableList<Log> logs = FXCollections.observableArrayList();
            logs.addAll(param);
            tableView.setItems(logs);
            isInit = true;
            finishLoading();
        }

        @Override
        public void onError(String errorMessage) {
            popupMessage(errorMessage, 3000);
        }

        @Override
        public void onBusy() {
            popupMessage("正在获取Log信息", 3000);
        }
    };

    @Override
    public void initializeController() {

        queryLogSession.send();

        informationComboBox.getItems().addAll(
                "所有信息",
                "管理员登录",
                "查询或修改选课信息",
                "第一次登录",
                "管理员退出",
                "科中成员登录",
                "科中成员退出",
                "密码错误",
                "上课同学退出",
                "修改成绩",
                "修改管理员",
                "主讲人",
                "助教"
        );
        informationComboBox.setValue("所有信息");

        returnBtn.setOnMouseClicked(event -> {
            if(event.getButton() == MouseButton.PRIMARY) {
                ObservableList<Log> logs = FXCollections.observableArrayList();
                logs.addAll(logList);
                datePicker.setValue(LocalDate.now());
                operatingNumberField.setText("");
                operatedNumberField.setText("");
                informationComboBox.setValue("所有信息");
                tableView.setItems(logs);
                tableView.refresh();
            }
        });

        selectBtn.setOnMouseClicked(event -> {
            if(event.getButton() == MouseButton.PRIMARY) {
                selectLogSession.send();
            }
        });

        /**
         * 设置DatePicker选中日期的输出格式
         */

        String pattern = "yyyy/M/d";
        datePicker.setPromptText(pattern.toLowerCase());
        datePicker.setConverter(new StringConverter<LocalDate>() {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);

            @Override
            public String toString(LocalDate date) {
                if(date != null) {
                    return  dateFormatter.format(date);
                } else {
                    return "";
                }
            }

            @Override
            public LocalDate fromString(String string) {
                if(string != null && !string.isEmpty()) {
                    return LocalDate.parse(string, dateFormatter);
                } else {
                    return null;
                }
            }
        });

        ID.setCellValueFactory(new PropertyValueFactory<Log, String>("ID"));
        operatingNumber.setCellValueFactory(new PropertyValueFactory<Log, String>("operatingNumber"));
        time.setCellValueFactory(new PropertyValueFactory<Log, String>("time"));
        IP.setCellValueFactory(new PropertyValueFactory<Log, String>("IP"));
        operatedNumber.setCellValueFactory(new PropertyValueFactory<Log, String>("operatedNumber"));
        hardScore.setCellValueFactory(new PropertyValueFactory<Log, String>("hardScore"));
        softScore.setCellValueFactory(new PropertyValueFactory<Log, String>("softScore"));
        paperScore.setCellValueFactory(new PropertyValueFactory<Log, String>("paperScore"));
        information.setCellValueFactory(new PropertyValueFactory<Log, String>("information"));
        version.setCellValueFactory(new PropertyValueFactory<Log, String>("version"));
        tableView.setPlaceholder(new Label("无Log信息"));
    }
}
