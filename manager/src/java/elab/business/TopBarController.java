package elab.business;

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
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;
import java.util.ResourceBundle;

public class TopBarController implements Initializable {

    @FXML
    private Button logButton;
    @FXML
    private ImageView closeBtn;
    @FXML
    private JFXPasswordField pwdInputField;
    @FXML
    private JFXTextField userInputField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        closeBtn.setOnMousePressed(event -> ElabManagerApplication.primaryStage.close());


        logButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.print(userInputField.getText());
                try {
                    Parent root = FXMLLoader.load(getClass().getResource("/main_window.fxml"));
                    Stage anotherStage = new Stage();
                    anotherStage.initStyle(StageStyle.DECORATED);
                    anotherStage.setTitle("Another Window Triggered by Clicking");
                    anotherStage.setScene(new Scene(root, 1200, 800));
                    anotherStage.show();
                } catch (Exception exp) {

                }
            }
        });
        // TODO (don't really need to do anything here).

    }
}
