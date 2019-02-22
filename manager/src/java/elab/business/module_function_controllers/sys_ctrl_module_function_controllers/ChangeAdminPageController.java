package elab.business.module_function_controllers.sys_ctrl_module_function_controllers;

import com.jfoenix.controls.JFXTextField;
import elab.application.BaseFunctionContentController;
import elab.database.DatabaseOperations;
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

    @Override
    public void initializeController() {

        ObservableList<Member> members = FXCollections.<Member>observableArrayList();
        members.addAll(DatabaseOperations.getInstance().selectAllMembers());
        for(int i = 0; i < members.size(); ++i) {
            if(members.get(i).getDuty() == null)
                chooseList.add(members.get(i).getName());
            else
                adminList.add(members.get(i).getName());
        }

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
                    if(selectList.size() != 0) selectList.remove(0, selectList.size());
                    for(int i = 0; i < chooseList.size(); ++i) {
                        if(Utilities.getPinyinString(chooseList.get(i)).startsWith(selectField.getText())
                                || Utilities.getFirstLettersLo(chooseList.get(i)).startsWith(selectField.getText())
                                || chooseList.get(i).startsWith(selectField.getText())
                                || Utilities.getFirstLettersUp(chooseList.get(i)).startsWith(selectField.getText()))
                            selectList.add(chooseList.get(i));
                        chooseListView.setItems(selectList);
                        chooseListView.refresh();
                    }
                }
            }
        });
    }
}
