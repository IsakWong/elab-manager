package elab.business.module_tab;

import com.jfoenix.controls.JFXButton;
import elab.application.BaseViewController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseButton;

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

    private Parent logRoot;
    private Parent timeRoot;
    private Parent reviseRoot;
    private Parent remoteRoot;
    private Parent importRoot;

    @Override
    public void initializeController() {

        try {
/*
            FXMLLoader logLoader = new FXMLLoader(getClass().getResource(""));
            this.logRoot = logLoader.load();

            FXMLLoader timeLoader = new FXMLLoader(getClass().getResource(""));
            this.timeRoot = timeLoader.load();

            FXMLLoader reviseLoader = new FXMLLoader(getClass().getResource(""));
            this.reviseRoot = reviseLoader.load();

            FXMLLoader remoteLoader = new FXMLLoader(getClass().getResource(""));
            this.remoteRoot = remoteLoader.load();

            FXMLLoader importLoader = new FXMLLoader(getClass().getResource(""));
            this.importRoot = importLoader.load();
*/ /*
            logInformation.setOnMouseClicked(event -> {
                if(event.getButton() == MouseButton.PRIMARY) {
                    contentPage.setContent(logRoot);
                }
            });

            timeOfNoCourses.setOnMouseClicked(event -> {
                if (event.getButton() == MouseButton.PRIMARY) {
                    contentPage.setContent(timeRoot);
                }
            });

            reviseAdmin.setOnMouseClicked(event -> {
                if(event.getButton() == MouseButton.PRIMARY) {
                    contentPage.setContent(reviseRoot);
                }
            });

            remoteControlOfTheLAN.setOnMouseClicked(event -> {
                if(event.getButton() == MouseButton.PRIMARY) {
                    contentPage.setContent(remoteRoot);
                }
            });

            importInformation.setOnMouseClicked(event -> {
                if(event.getButton() == MouseButton.PRIMARY) {
                    contentPage.setContent(importRoot);
                }
            });
*/
        } catch (Exception exp) {
            System.out.println(exp.toString());
        }
    }
}
