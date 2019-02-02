package elab.business;

import elab.application.BaseViewController;
import elab.serialization.student.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

import java.util.List;

public class ModulePageController extends BaseViewController {


    @FXML
    public VBox leftPanel;
    @FXML
    public ScrollPane contentPage;

    @Override
    public void initializeController() {

    }
}
