package elab.business.module_function_controllers.register_module_function_controllers;

import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import elab.application.BaseFunctionContentController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;

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
/*
    @FXML
    private TableColumn<String, > number;
    @FXML
    private TableColumn<String, > name;
    @FXML
    private TableColumn<String, > group;
    @FXML
    private TableColumn<String, > totalTime;

    private ObservableList<> timeList = FXCollections.observableArrayList();
    private ObservableList<> selectList = FXCollections.observableArrayList();
*/
    @Override
    public void initializeController() {

        all.setSelected(true);
        all.setOnAction(event -> {
            hard.setSelected(false);
            soft.setSelected(false);
        });

        hard.setOnAction(event -> {
            all.setSelected(false);
            soft.setSelected(false);
        });

        soft.setOnAction(event -> {
            all.setSelected(false);
            hard.setSelected(false);
        });

        selectField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(all.isSelected()) all.setSelected(false);
                if(hard.isSelected()) hard.setSelected(false);
                if(soft.isSelected()) soft.setSelected(false);
            }
        });
/*
        number.setCellValueFactory(new PropertyValueFactory<String, >("number"));
        name.setCellValueFactory(new PropertyValueFactory<String, >("name"));
        group.setCellValueFactory(new PropertyValueFactory<String, >("group"));
        totalTime.setCellValueFactory(new PropertyValueFactory<String, >("totalTime"));
        timeList.addAll(DatabaseOperations);
        tableView.setItems(timeList);
        */
    }
}
