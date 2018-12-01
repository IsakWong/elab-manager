package elab.business.module_tab;

import com.jfoenix.controls.JFXButton;
import elab.application.BaseViewController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
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

    private Parent viewRoot;
    private Parent inputRoot;
    private Parent attendanceRecordRoot;
    private Parent dataRoot;
    private Parent attendanceInTheoryClassRoot;
    private Parent autoRoot;

    @Override
    public void initializeController() {

        try {
/*
            FXMLLoader viewLoader = new FXMLLoader(getClass().getResource(""));
            this.viewRoot = viewLoader.load();

            FXMLLoader inputLoader = new FXMLLoader(getClass().getResource(""));
            this.inputRoot = inputLoader.load();

            FXMLLoader attendanceRecordLoader = new FXMLLoader(getClass().getResource(""));
            this.attendanceRecordRoot = attendanceRecordLoader.load();

            FXMLLoader dataLoader = new FXMLLoader(getClass().getResource(""));
            this.dataRoot = dataLoader.load();

            FXMLLoader attendanceInTheoryClassLoader = new FXMLLoader(getClass().getResource(""));
            this.attendanceInTheoryClassRoot = attendanceInTheoryClassLoader.load();

            FXMLLoader autoLoader = new FXMLLoader(getClass().getResource(""));
            this.autoRoot = autoLoader.load();
*/ /*
            viewSelectCoursesInformation.setOnMousePressed(event -> {
                contentPage.setContent(viewRoot);
            });

            inputGrade.setOnMousePressed(event -> {
                contentPage.setContent(inputRoot);
            });

            attendanceRecord.setOnMousePressed(event -> {
                contentPage.setContent(attendanceRecordRoot);
            });

            dataProcessing.setOnMousePressed(event -> {
                contentPage.setContent(dataRoot);
            });

            attendanceInTheoryClass.setOnMousePressed(event -> {
                contentPage.setContent(attendanceInTheoryClassRoot);
            });

            autoFill.setOnMousePressed(event -> {
                contentPage.setContent(autoRoot);
            });
*/
        } catch (Exception exp) {
            System.out.print(exp.toString());
        }
    }
}
