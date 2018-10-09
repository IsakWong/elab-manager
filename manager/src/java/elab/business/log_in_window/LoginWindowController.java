package elab.business.log_in_window;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import elab.application.ElabManagerApplication;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginWindowController implements Initializable {


    @FXML
    private HBox topBar;
    @FXML
    private Button logButton;
    @FXML
    private ImageView closeBtn;
    @FXML
    private JFXPasswordField pwdInputField;
    @FXML
    private JFXTextField userInputField;

    private double x1;
    private double y1;
    private double x_stage;
    private double y_stage;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        closeBtn.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                ElabManagerApplication.primaryStage.close();
            }
        });


        logButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.print(userInputField.getText());
                try {
                    Parent root = FXMLLoader.load(getClass().getResource("/main_window.fxml"));
                    Stage anotherStage = new Stage();
                    anotherStage.initStyle(StageStyle.UNDECORATED);
                    anotherStage.setScene(new Scene(root, 1200, 800));
                    anotherStage.show();
                } catch (Exception exp) {

                }
            }
        });

        //Drag Event
        topBar.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent m) {
                ElabManagerApplication.primaryStage.setX(x_stage + m.getScreenX() - x1);
                ElabManagerApplication.primaryStage.setY(y_stage + m.getScreenY() - y1);
            }
        });
        topBar.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent m) {
                //按下鼠标后，记录当前鼠标的坐标
                x1 = m.getScreenX();
                y1 = m.getScreenY();
                x_stage = ElabManagerApplication.primaryStage.getX();
                y_stage = ElabManagerApplication.primaryStage.getY();
            }
        });

    }
}
