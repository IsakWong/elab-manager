package elab.business.module_function_controllers.register_module_function_controllers;

import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import elab.application.BaseFunctionContentController;
import elab.database.DatabaseOperations;
import elab.database.Session;
import elab.serialization.beans.loader.Loader;
import elab.util.Utilities;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class RegisterTimePageController extends BaseFunctionContentController {

    @FXML
    private JFXRadioButton all;
    @FXML
    private JFXRadioButton hard;
    @FXML
    private JFXRadioButton soft;
    @FXML
    private JFXTextField selectField;
    @FXML
    private TableView tableView;
    @FXML
    private TableColumn<String, Loader> number;
    @FXML
    private TableColumn<String, Loader> name;
    @FXML
    private TableColumn<String, Loader> group;
    @FXML
    private TableColumn<String, Loader> totalTime;

    ObservableList<Loader> totalList = FXCollections.observableArrayList();

    Session<List> queryLoaderSession = new Session<List>() {

        @Override
        public void onPostFetchResult(SessionResult<List> sessionResult) {
            sessionResult.result = DatabaseOperations.getInstance().selectLoader(Utilities.getSystemDate() + " 00:00:00");
            if (sessionResult.result == null) {
                sessionResult.errorMessage = "获取信息失败";
            }
        }

        @Override
        public void onSuccess(List param) {
            ObservableList<Loader> loaders = FXCollections.observableArrayList();
            loaders.addAll(param);
            totalList.addAll(param);
            tableView.setItems(getTotalTimeList(getTotalTimeList(loaders)));
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

    private ObservableList<Loader> getTotalTimeList(ObservableList<Loader> loaders) {
        ObservableList<Loader> list = FXCollections.observableArrayList();
        for (Loader loader : loaders) {
            Boolean isGet = false;
            for (Loader loader1 : list) {
                if (loader1.getName().equals(loader.getName())) {
                    loader1.setTotalTime(Integer.toString(Integer.parseInt(loader1.getTotalTime()) + Integer.parseInt(loader.getTotalTime())));
                    isGet = true;
                    break;
                }
            }
            if (!isGet) {
                list.add(loader);
            }
        }
        return list;
    }

    private ObservableList<Loader> getGroupList(ObservableList<Loader> loaders, int operation) {
        ObservableList<Loader> list = FXCollections.observableArrayList();
        switch (operation) {
            case 1:
                for (Loader loader : loaders) {
                    if (loader.getGroup().equals("电子组")) {
                        list.add(loader);
                    }
                }
                break;
            case 2:
                for (Loader loader : loaders) {
                    if (loader.getGroup().equals("软件组")) {
                        list.add(loader);
                    }
                }
                break;
            default:
                break;
        }
        return list;
    }

    @Override
    public void initializeController() {

        all.setSelected(true);
        all.setOnAction(event -> {
            hard.setSelected(false);
            soft.setSelected(false);
            tableView.setItems(totalList);
        });

        hard.setOnAction(event -> {
            all.setSelected(false);
            soft.setSelected(false);
            tableView.setItems(getGroupList(totalList, 1));
        });

        soft.setOnAction(event -> {
            all.setSelected(false);
            hard.setSelected(false);
            tableView.setItems(getGroupList(totalList, 2));
        });

        selectField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (all.isSelected()) {
                    all.setSelected(false);
                }
                if (hard.isSelected()) {
                    hard.setSelected(false);
                }
                if (soft.isSelected()) {
                    soft.setSelected(false);
                }
                if (totalList.size() > 0) {
                    ObservableList<Loader> list = FXCollections.observableArrayList();
                    for (Loader aTotalList : totalList) {
                        if (Utilities.getPinyinString(aTotalList.getName()).startsWith(selectField.getText())
                                || Utilities.getFirstLettersLo(aTotalList.getName()).startsWith(selectField.getText())
                                || aTotalList.getName().startsWith(selectField.getText())
                                || Utilities.getFirstLettersUp(aTotalList.getName()).startsWith(selectField.getText())) {
                            list.add(aTotalList);
                        }
                    }
                    tableView.setItems(list);
                }
            }
        });

        number.setCellValueFactory(new PropertyValueFactory<String,Loader >("number"));
        name.setCellValueFactory(new PropertyValueFactory<String,Loader >("name"));
        group.setCellValueFactory(new PropertyValueFactory<String, Loader>("group"));
        totalTime.setCellValueFactory(new PropertyValueFactory<String,Loader >("totalTime"));

        queryLoaderSession.send();
    }
}
