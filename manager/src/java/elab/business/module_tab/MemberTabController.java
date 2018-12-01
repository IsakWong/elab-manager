package elab.business.module_tab;

import com.jfoenix.controls.JFXButton;
import elab.application.BaseViewController;
import elab.business.member_tab_function_controllers.AddMemberPageController;
import elab.business.member_tab_function_controllers.FreeTimeCollectPageController;
import elab.business.member_tab_function_controllers.PersonalInformationPageController;
import elab.business.member_tab_function_controllers.UserManagementPageController;
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

    @FXML
    private JFXButton userManagement;
    @FXML
    private JFXButton addMember;
    @FXML
    private JFXButton personalInformation;
    @FXML
    private JFXButton freeTimeCollect;
    @FXML
    private ScrollPane contentPage;

<<<<<<< HEAD
    public final Logger logger = Logger.getLogger(MemberTabController.class);

    public Module TabModule;

    private Parent userManagementRoot;
    private Parent addMemberRoot;
    private Parent personalInformationRoot;
    private Parent freeTimeRoot;
=======
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
>>>>>>> da729542ebc1cbbfe3f0a03368f50cc7af316911

            }
        }
    };
    @Override
    public void initializeController() {
        addUser.setOnMouseClicked(addMemberHandler);
        modifyInformation.setOnMouseClicked(modifyHandler);

        try {

            //加载文件

            FXMLLoader userManagementLoader = new FXMLLoader(getClass().getResource("/user_management_page.fxml"));
            this.userManagementRoot = userManagementLoader.load();
            UserManagementPageController userManagementPageController = userManagementLoader.getController();
            userManagementPageController.initializeController();

            FXMLLoader addMemberLoader = new FXMLLoader(getClass().getResource("/add_member_page.fxml"));
            this.addMemberRoot = addMemberLoader.load();
            AddMemberPageController addMemberPageController = addMemberLoader.getController();
            //addMemberPageController.initializeController();

            FXMLLoader personalInformationLoader = new FXMLLoader(getClass().getResource("/personal_information_page.fxml"));
            this.personalInformationRoot = personalInformationLoader.load();
            PersonalInformationPageController personalInformationPageController = personalInformationLoader.getController();
            //personalInformationPageController.initializeController();

            FXMLLoader freeTimeLoader = new FXMLLoader(getClass().getResource("/free_time_collect_page.fxml"));
            this.freeTimeRoot = freeTimeLoader.load();
            FreeTimeCollectPageController freeTimeCollectPageController = freeTimeLoader.getController();
            //freeTimeCollectPageController.initializeController();

            //按钮事件

            userManagement.setOnMousePressed(event -> {
                contentPage.setContent(userManagementRoot);
            });

            addMember.setOnMousePressed(event -> {
                contentPage.setContent(addMemberRoot);
            });

            personalInformation.setOnMousePressed(event -> {
                contentPage.setContent(personalInformationRoot);
            });

            freeTimeCollect.setOnMousePressed(event -> {
                contentPage.setContent(freeTimeRoot);
            });

        } catch(Exception exp) {
            System.out.println(exp.toString());
        }
    }
}
