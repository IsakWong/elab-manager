package elab.business.module_function_controllers.sys_ctrl_module_function_controllers;

import com.jfoenix.controls.JFXTextField;
import elab.application.BaseFunctionContentController;
import elab.application.ElabManagerApplication;
import elab.database.DatabaseOperations;
import elab.database.Session;
import elab.serialization.beans.log.Log;
import elab.serialization.beans.member.Member;
import elab.util.Utilities;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.HBox;

import java.util.List;

public class ChangeAdminPageController extends BaseFunctionContentController {

    @FXML
    private JFXTextField selectField;
    @FXML
    private ListView<String> chooseListView;
    @FXML
    private ListView<String> adminListView;
    @FXML
    private HBox container;

    private ObservableList<String> selectList = FXCollections.<String>observableArrayList();
    private ObservableList<String> chooseList = FXCollections.<String>observableArrayList();
    private ObservableList<String> adminList = FXCollections.<String>observableArrayList();

    Session<List> queryMemberSession = new Session<List>() {
        @Override
        public void onPostFetchResult(SessionResult<List> sessionResult) {
            sessionResult.result = DatabaseOperations.getInstance().selectAllMembers();
            if(sessionResult == null) {
                sessionResult.errorMessage = "无法获取成员信息";
            }
        }

        @Override
        public void onSuccess(List param) {
            ObservableList<Member> members = FXCollections.<Member>observableArrayList();
            members.addAll(param);
            for (int i = 0; i < members.size(); ++i) {
                if (members.get(i).getDuty() == null) {
                    chooseList.add(members.get(i).getName());
                } else {
                    adminList.add(members.get(i).getName());
                }
            }
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

    Session<Boolean> writeLogSession = new Session<Boolean>() {
        @Override
        public void onPostFetchResult(SessionResult<Boolean> sessionResult) {
            Log log = new Log();
            log.setInformation("修改管理员");
            log.setOperatingNumber(ElabManagerApplication.properties.getProperty("LAST_USER"));
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

    @Override
    public void initializeController() {

        queryMemberSession.send();

        chooseListView.setItems(chooseList);
        adminListView.setItems(adminList);

        chooseListView.setOnMouseClicked(event -> {
            if(event.getClickCount() == 2 && event.getButton() == MouseButton.PRIMARY) {
                String selectItem = chooseListView.getSelectionModel().getSelectedItem();
                if(selectItem != null) {
                    chooseList.remove(selectItem);
                    chooseListView.refresh();
                    adminList.add(selectItem);
                    adminListView.refresh();
                    DatabaseOperations.getInstance().setDuty(selectItem);
                    writeLogSession.send();
                    Utilities.popMessage("管理员添加成功", container);
                }
            }
        });

        adminListView.setOnMouseClicked(event -> {
            if(event.getClickCount() == 2 && event.getButton() == MouseButton.PRIMARY) {
                String selectItem = adminListView.getSelectionModel().getSelectedItem();
                if(selectItem != null) {
                    adminList.remove(selectItem);
                    adminListView.refresh();
                    chooseList.add(selectItem);
                    chooseListView.refresh();
                    DatabaseOperations.getInstance().removeDuty(selectItem);
                    writeLogSession.send();
                    Utilities.popMessage("管理员已被移除", container);
                }
            }
        });

        selectField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(selectField.getText().equals("")) {
                    chooseListView.setItems(chooseList);
                    chooseListView.refresh();
                } else {
                    if (selectList.size() != 0) {
                        selectList.remove(0, selectList.size());
                    }
                    for (int i = 0; i < chooseList.size(); ++i) {
                        if (Utilities.getPinyinString(chooseList.get(i)).startsWith(selectField.getText())
                                || Utilities.getFirstLettersLo(chooseList.get(i)).startsWith(selectField.getText())
                                || chooseList.get(i).startsWith(selectField.getText())
                                || Utilities.getFirstLettersUp(chooseList.get(i)).startsWith(selectField.getText())) {
                            selectList.add(chooseList.get(i));
                        }
                        chooseListView.setItems(selectList);
                        chooseListView.refresh();
                    }
                }
            }
        });
    }
}
