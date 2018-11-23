package elab.business.module_tab;

import com.jfoenix.controls.JFXButton;
import elab.application.BaseViewController;
import elab.serialization.module.Module;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import org.apache.log4j.Logger;

import java.io.IOException;

public class MemberTabController extends BaseViewController {

    public final Logger logger = Logger.getLogger(MemberTabController.class);

    public Module TabModule;

    @FXML
    private JFXButton addUser;
    @FXML
    private JFXButton modifyInformation;
    @FXML
    private JFXButton deleteUser;
    @FXML
    private JFXButton queryInformation;
    @FXML
    private JFXButton userInformation;
    @FXML
    private JFXButton freeTimeCollect;
    @FXML
    private ScrollPane contentPage;

    Parent addMemberPage;
    Parent modifyMemberPage;

    EventHandler<MouseEvent> addMemberHandler =   new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/add_member_page.fxml"));
                addMemberPage = loader.load();
                contentPage.setContent(addMemberPage);
            }
            catch (IOException exp)
            {

            }

        }
    };


    EventHandler<MouseEvent> modifyHandler = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/modify_member_page.fxml"));
                addMemberPage = loader.load();
                contentPage.setContent(addMemberPage);
            }
            catch (IOException exp)
            {

            }
        }
    };
    @Override
    public void initializeController() {
        addUser.setOnMouseClicked(addMemberHandler);
        modifyInformation.setOnMouseClicked(modifyHandler);

    }
}
