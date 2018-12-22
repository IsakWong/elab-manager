package elab.business.module_tab;

import com.jfoenix.controls.JFXButton;
import elab.application.BaseViewController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseButton;

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
            viewOnLine.setOnMouseClicked(event -> {
                if(event.getButton() == MouseButton.PRIMARY) {
                    contentPage.setContent(viewRoot);
                }
            });

            totalAttendanceTime.setOnMouseClicked(event -> {
                if(event.getButton() == MouseButton.PRIMARY) {
                    contentPage.setContent(totalRoot);
                }
            });

            onDuty.setOnMouseClicked(event -> {
                if(event.getButton() == MouseButton.PRIMARY) {
                    contentPage.setContent(onDutyRoot);
                }
            });

            dutyForm.setOnMouseClicked(event -> {
                if(event.getButton() == MouseButton.PRIMARY) {
                    contentPage.setContent(dutyFormRoot);
                }
            });
*/
        } catch (Exception exp) {
            System.out.println(exp.toString());
        }
    }
}
