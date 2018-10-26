package elab.business.module_tab;

import com.jfoenix.controls.JFXButton;
import elab.application.BaseViewController;
import elab.serialization.module.Module;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import org.apache.log4j.Logger;

import java.net.URL;
import java.util.ResourceBundle;

public class ModuleTabController extends BaseViewController {

    public final Logger logger = Logger.getLogger(ModuleTabController.class);

    public Module TabModule;

    @FXML
    private JFXButton addUser;
    @FXML
    private ScrollPane contentPage;


    @Override
    public void initializeController() {

    }
}
