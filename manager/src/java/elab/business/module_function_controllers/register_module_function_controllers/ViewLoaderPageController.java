package elab.business.module_function_controllers.register_module_function_controllers;

import elab.application.BaseFunctionContentController;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ViewLoaderPageController extends BaseFunctionContentController {

    @FXML
    private DatePicker datePicker;
    @FXML
    private Label arrivalLabel;
    @FXML
    private Label leaveLabel;
    @FXML
    private ListView listView;
    @FXML
    private TableView tableView;
    @FXML
    private TableColumn number;
    @FXML
    private TableColumn name;
    @FXML
    private TableColumn group;
    @FXML
    private TableColumn date;
    @FXML
    private TableColumn week;
    @FXML
    private TableColumn arrivalTime;
    @FXML
    private TableColumn leaveTime;
    @FXML
    private TableColumn totalTime;

    @Override
    public void initializeController() {

    }
}
