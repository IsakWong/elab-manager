package elab.business.module_tab;

import com.jfoenix.controls.JFXButton;
import elab.application.BaseViewController;
import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;

public class AssistTeachingTabController extends BaseViewController {

    @FXML
    private JFXButton viewSelectCoursesInformation;
    @FXML
    private JFXButton inputGrade;
    @FXML
    private JFXButton attendanceRecord;
    @FXML
    private JFXButton dataProcessing;
    @FXML
    private JFXButton attendanceInTheoryClass;
    @FXML
    private JFXButton autoFill;
    @FXML
    private ScrollPane contentPage;

    @Override
    public void initializeController() {

    }
}
