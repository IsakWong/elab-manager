package elab.business.module_tab;

import com.jfoenix.controls.JFXButton;
import elab.application.BaseViewController;
import elab.business.assist_teaching_tab_function_controllers.AttendanceRecordPageController;
import elab.business.assist_teaching_tab_function_controllers.EnterScorePageController;
import elab.business.assist_teaching_tab_function_controllers.ViewSelectCoursesInformationController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseButton;

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
    private ScrollPane commonContentPage;
    @FXML
    private ScrollPane contentPageA;

    private Parent viewRoot;
    private Parent enterScoreRoot;
    private Parent attendanceRecordRoot;
    private Parent dataRoot;
    private Parent attendanceInTheoryClassRoot;
    private Parent autoRoot;

    @Override
    public void initializeController() {

        try {

            FXMLLoader viewLoader = new FXMLLoader(getClass().getResource("/view_select_courses_information_page/view_select_courses_information_page.fxml"));
            viewRoot = viewLoader.load();
            ViewSelectCoursesInformationController viewSelectCoursesInformationController = viewLoader.getController();
            viewSelectCoursesInformationController.initializeController();

            FXMLLoader enterScoreLoader = new FXMLLoader(getClass().getResource("/enter_score_page.fxml"));
            enterScoreRoot = enterScoreLoader.load();
            EnterScorePageController enterScorePageController = enterScoreLoader.getController();
            //enterScorePageController.initializeController();

            FXMLLoader attendanceRecordLoader = new FXMLLoader(getClass().getResource("/attendance_record_page.fxml"));
            attendanceRecordRoot = attendanceRecordLoader.load();
            AttendanceRecordPageController attendanceRecordPageController = attendanceRecordLoader.getController();
            attendanceRecordPageController.initializeController();
/*
            FXMLLoader dataLoader = new FXMLLoader(getClass().getResource(""));
            dataRoot = dataLoader.load();

            FXMLLoader attendanceInTheoryClassLoader = new FXMLLoader(getClass().getResource(""));
            attendanceInTheoryClassRoot = attendanceInTheoryClassLoader.load();

            FXMLLoader autoLoader = new FXMLLoader(getClass().getResource(""));
            autoRoot = autoLoader.load();
*/
            commonContentPage.setContent(viewRoot);
            contentPageA.setContent(enterScoreRoot);

            viewSelectCoursesInformation.setOnMouseClicked(event -> {
                if(event.getButton() == MouseButton.PRIMARY) {
                    if(commonContentPage.isVisible())
                        commonContentPage.setContent(viewRoot);
                    else {
                        commonContentPage.setContent(viewRoot);
                        contentPageA.setVisible(false);
                        commonContentPage.setVisible(true);
                    }
                }
            });

            inputGrade.setOnMouseClicked(event -> {
                if(event.getButton() == MouseButton.PRIMARY) {
                    if(!contentPageA.isVisible()) {
                        commonContentPage.setVisible(false);
                        contentPageA.setVisible(true);
                    }
                }
            });

            attendanceRecord.setOnMouseClicked(event -> {
                if(event.getButton() == MouseButton.PRIMARY) {
                    commonContentPage.setContent(attendanceRecordRoot);
                }
            });
/*
            dataProcessing.setOnMouseClicked(event -> {
                if(event.getButton() == MouseButton.PRIMARY) {
                    contentPage.setContent(dataRoot);
                }
            });

            attendanceInTheoryClass.setOnMouseClicked(event -> {
                if(event.getButton() == MouseButton.PRIMARY) {
                    contentPage.setContent(attendanceInTheoryClassRoot);
                }
            });

            autoFill.setOnMouseClicked(event -> {
                if(event.getButton() == MouseButton.PRIMARY) {
                    contentPage.setContent(autoRoot);
                }
            });
*/
        } catch (Exception exp) {
            System.out.print(exp.toString());
        }
    }
}
