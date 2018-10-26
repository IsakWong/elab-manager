package elab.business.MessageDialog;

import com.jfoenix.controls.JFXButton;
import elab.application.BaseViewController;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.xml.soap.Text;
import java.awt.*;
import java.io.IOException;

public class MessageDialogController extends BaseViewController {

    @FXML
    private AnchorPane topBar;
    @FXML
    private Text messageField;
    @FXML
    private JFXButton okBtn;
    @FXML
    private ImageView closeBtn;
    @FXML
    private ImageView minBtn;

    private double x1;
    private double y1;
    private double x_stage;
    private double y_stage;
    private String text;

    public void show( Parent dialogRoot) {
        try {
            Stage dialogStage = new Stage();
            dialogStage.setAlwaysOnTop(true);
            dialogStage.initStyle(StageStyle.UNDECORATED);
            dialogStage.setScene(new Scene(dialogRoot, 350, 200));
            dialogStage.show();
        }catch (Exception exp) {

        }
    }

    public void getText(String text) {
        this.text = text;
    }

    public void closeDialog() {
        Stage stage = (Stage)closeBtn.getScene().getWindow();
        stage.close();
    }

    public boolean enterRelease(KeyEvent event){
        return (event.getCode().equals(KeyCode.ENTER));
    }

    public void  initialize() {
        try {
            messageField.setTextContent(text);

            closeBtn.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    closeDialog();
                }
            });

            minBtn.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    Stage stage = (Stage)minBtn.getScene().getWindow();
                    stage.setIconified(true);
                }
            });

            okBtn.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    closeDialog();
                }
            });

            okBtn.setOnKeyReleased(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent event) {
                    if(enterRelease(event))
                        closeDialog();
                }
            });

            topBar.setOnMouseDragged(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    Stage stage = (Stage)topBar.getScene().getWindow();
                    stage.setX(x_stage + event.getScreenX() - x1);
                    stage.setY(y_stage + event.getScreenY() - y1);
                }
            });

            topBar.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    Stage stage = (Stage)topBar.getScene().getWindow();
                    x1 = event.getScreenX();
                    y1 = event.getScreenY();
                    x_stage = stage.getX();
                    y_stage = stage.getY();
                }
            });
        } catch (Exception exp) {

        }
    };
}
