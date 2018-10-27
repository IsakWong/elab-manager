package elab.business.module_tab;

import com.jfoenix.controls.JFXButton;
import elab.application.BaseViewController;
import elab.serialization.module.Module;
import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import org.apache.log4j.Logger;

public class MemberTabController extends BaseViewController {

    public final Logger logger = Logger.getLogger(MemberTabController.class);

    public Module TabModule;

    @FXML
    private JFXButton addUser;
    @FXML
    private JFXButton modifyInformation;
    @FXML
    private JFXButton deleteUser;
    @FXML
    private JFXButton queryInformation;
    @FXML
    private JFXButton userInformation;
    @FXML
    private JFXButton freeTimeCollect;
    @FXML
    private ScrollPane contentPage;


    @Override
    public void initializeController() {

    }
}
