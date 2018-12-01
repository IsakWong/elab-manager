package elab.business.module_tab;

import com.jfoenix.controls.JFXButton;
import elab.application.BaseViewController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;

public class RegisterTabController extends BaseViewController {

    @FXML
    private JFXButton viewOnLine;
    @FXML
    private JFXButton totalAttendanceTime;
    @FXML
    private JFXButton onDuty;
    @FXML
    private JFXButton dutyForm;
    @FXML
    private ScrollPane contentPage;

    private Parent viewRoot;
    private Parent totalRoot;
    private Parent onDutyRoot;
    private Parent dutyFormRoot;

    @Override
    public void initializeController() {

        try {
/*
            FXMLLoader viewLoader = new FXMLLoader(getClass().getResource(""));
            this.viewRoot = viewLoader.load();

            FXMLLoader totalLoader = new FXMLLoader(getClass().getResource(""));
            this.totalRoot = totalLoader.load();

            FXMLLoader onDutyLoader = new FXMLLoader(getClass().getResource(""));
            this.onDutyRoot = onDutyLoader.load();

            FXMLLoader dutyFormLoader = new FXMLLoader(getClass().getResource(""));
            this.dutyFormRoot = dutyFormLoader.load();
*/ /*
            viewOnLine.setOnMousePressed(event -> {
                contentPage.setContent(viewRoot);
            });

            totalAttendanceTime.setOnMousePressed(event -> {
                contentPage.setContent(totalRoot);
            });

            onDuty.setOnMousePressed(event -> {
                contentPage.setContent(onDutyRoot);
            });

            dutyForm.setOnMousePressed(event -> {
                contentPage.setContent(dutyFormRoot);
            });
*/
        } catch (Exception exp) {
            System.out.println(exp.toString());
        }
    }
}
