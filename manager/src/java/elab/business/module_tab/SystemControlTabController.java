package elab.business.module_tab;

import com.jfoenix.controls.JFXButton;
import elab.application.BaseViewController;
import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;

public class SystemControlTabController extends BaseViewController {

    @FXML
    private JFXButton logInformation;
    @FXML
    private JFXButton timeOfNoCourses;
    @FXML
    private JFXButton reviseAdmin;
    @FXML
    private JFXButton remoteControlOfTheLAN;
    @FXML
    private JFXButton importInformation;
    @FXML
    private ScrollPane contentPage;

    @Override
    public void initializeController() {

    }
}
