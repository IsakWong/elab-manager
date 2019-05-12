package elab.business.module_function_controllers.register_module_function_controllers;

import com.jfoenix.controls.JFXDatePicker;
import elab.application.BaseFunctionContentController;
import elab.database.DatabaseOperations;
import elab.database.Session;
import elab.serialization.beans.loader.Loader;
import elab.util.Utilities;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.List;

public class ViewLoaderPageController extends BaseFunctionContentController {

    @FXML
    private JFXDatePicker datePicker;
    @FXML
    private Label arrivalLabel;
    @FXML
    private Label leaveLabel;
    @FXML
    private ListView listView;
    @FXML
    private TableView tableView;
    @FXML
    private TableColumn<String, Loader> number;
    @FXML
    private TableColumn<String, Loader> name;
    @FXML
    private TableColumn<String, Loader> group;
    @FXML
    private TableColumn<String, Loader> date;
    @FXML
    private TableColumn<String, Loader> week;
    @FXML
    private TableColumn<String, Loader> arrivalTime;
    @FXML
    private TableColumn<String, Loader> leaveTime;
    @FXML
    private TableColumn<String, Loader> totalTime;

    private ObservableList<String> nameList = FXCollections.observableArrayList();

    private String sessionDate = Utilities.getSystemDate();

    Session<List> queryLoaderSession = new Session<List>() {

        @Override
        public void onPostFetchResult(SessionResult<List> sessionResult) {
            sessionResult.result = DatabaseOperations.getInstance().selectLoader(sessionDate);
            if(sessionResult.result == null)
                sessionResult.errorMessage = "获取信息失败";
        }

        @Override
        public void onSuccess(List param) {
            ObservableList loaders = FXCollections.observableArrayList();
            loaders.addAll(param);
            tableView.setItems(loaders);
            finishLoading();
        }

        @Override
        public void onError(String errorMessage) {
            popupMessage(errorMessage, 1500);
        }

        @Override
        public void onBusy() {
            popupMessage("正在获取登录信息", 1500);
        }
    };

    Session<List<Loader>> queryNameListSession = new Session<List<Loader>>() {
        @Override
        public void onPostFetchResult(SessionResult<List<Loader>> sessionResult) {
            sessionResult.result = DatabaseOperations.getInstance().selectLoader(Utilities.getSystemDate());
            if(sessionResult.result == null)
                sessionResult.errorMessage = "获取信息失败";
        }

        @Override
        public void onSuccess(List<Loader> param) {
            for(Loader loader : param)
                if(!nameList.contains(loader.getName()) && loader.getLogout() == null)
                    nameList.add(loader.getName());
        }

        @Override
        public void onError(String errorMessage) {
            popupMessage(errorMessage, 1500);
        }

        @Override
        public void onBusy() {
            popupMessage("正在获取登录信息", 1500);
        }
    };

    @Override
    public void initializeController() {

        queryLoaderSession.send();
        queryNameListSession.send();

        number.setCellValueFactory(new PropertyValueFactory<String, Loader>("number"));
        name.setCellValueFactory(new PropertyValueFactory<String, Loader>("name"));
        group.setCellValueFactory(new PropertyValueFactory<String, Loader>("group"));
        date.setCellValueFactory(new PropertyValueFactory<String, Loader>("date"));
        week.setCellValueFactory(new PropertyValueFactory<String, Loader>("week"));
        arrivalTime.setCellValueFactory(new PropertyValueFactory<String, Loader>("login"));
        leaveTime.setCellValueFactory(new PropertyValueFactory<String, Loader>("logout"));
        totalTime.setCellValueFactory(new PropertyValueFactory<String, Loader>("totalTime"));

        listView.setItems(nameList);

        datePicker.setValue(LocalDate.now());
        datePicker.getEditor().textProperty().addListener((observable, oldValue, newValue) -> {
            sessionDate = newValue;
            queryLoaderSession.send();
        });
    }
}
