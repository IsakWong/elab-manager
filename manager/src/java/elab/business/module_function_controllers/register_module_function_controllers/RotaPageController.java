package elab.business.module_function_controllers.register_module_function_controllers;

import com.mysql.cj.xdevapi.Table;
import elab.application.BaseViewController;
import elab.database.DatabaseOperations;
import elab.serialization.beans.rota;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class RotaPageController extends BaseViewController {

    @FXML
    private TableView tableView;
    @FXML
    private TableColumn number;
    @FXML
    private TableColumn name;
    @FXML
    private TableColumn group;
    @FXML
    private TableColumn time;
    @FXML
    private TableColumn week;
    @FXML
    private TableColumn day;

    @Override
    public void initializeController() {

        number.setCellValueFactory(new PropertyValueFactory<String, rota>("number"));
        name.setCellValueFactory(new PropertyValueFactory<String, rota>("name"));
        group.setCellValueFactory(new PropertyValueFactory<String, rota>("group"));
        time.setCellValueFactory(new PropertyValueFactory<String, rota>("time"));
        week.setCellValueFactory(new PropertyValueFactory<String, rota>("week"));
        day.setCellValueFactory(new PropertyValueFactory<String, rota>("day"));

        ObservableList<rota> rota = FXCollections.<rota>observableArrayList();
        rota.addAll(DatabaseOperations.getInstance().selectRota());
        tableView.setItems(rota);
    }
}
