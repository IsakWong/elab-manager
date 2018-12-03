package elab.business.member_tab_function_controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import elab.application.BaseViewController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import sun.security.provider.Sun;


public class FreeTimeCollectPageController extends BaseViewController {

    @FXML
    VBox container;
    @Override
    public void initializeController() {
        try {
            {

                FXMLLoader loader = new FXMLLoader(getClass().getResource("/free_time_page.fxml"));
                Node root = loader.load();
                Label label = (Label)root.lookup("#weekLabel");
                label.setText("第一周");
                container.getChildren().add(root);
                Separator sep = new Separator();
                sep.setPrefWidth(container.getWidth());
                container.getChildren().add(sep);
            }
            {

                FXMLLoader loader = new FXMLLoader(getClass().getResource("/free_time_page.fxml"));
                Node root = loader.load();
                Label label = (Label)root.lookup("#weekLabel");
                label.setText("第二周");
                container.getChildren().add(root);
                Separator sep = new Separator();
                sep.setPrefWidth(container.getWidth());
                container.getChildren().add(sep);
            }
        }catch (Exception exp)
        {

        }
    }
}
