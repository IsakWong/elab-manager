package elab.business.module_tab;

import com.jfoenix.controls.JFXButton;
import elab.application.BaseViewController;
import elab.business.member_tab_function_controllers.AddMemberPageController;
import elab.business.member_tab_function_controllers.FreeTimeCollectPageController;
import elab.business.member_tab_function_controllers.PersonalInformationPageController;
import elab.business.member_tab_function_controllers.UserManagementPageController;
import elab.serialization.module.Module;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseButton;
import org.apache.log4j.Logger;

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
    private ScrollPane contentPageA;
    @FXML
    private ScrollPane contentPageB;
    @FXML
    private ScrollPane contentPageC;

    public final Logger logger = Logger.getLogger(MemberTabController.class);

    public Module TabModule;

    private Parent userManagementRoot;
    private Parent addMemberRoot;
    private Parent personalInformationRoot;
    private Parent freeTimeRoot;

    @Override
    public void initializeController() {
        try {

            //加载文件

            FXMLLoader userManagementLoader = new FXMLLoader(getClass().getResource("/user_management_page.fxml"));
            userManagementRoot = userManagementLoader.load();
            UserManagementPageController userManagementPageController = userManagementLoader.getController();
            userManagementPageController.initializeController();

            FXMLLoader addMemberLoader = new FXMLLoader(getClass().getResource("/add_member_page.fxml"));
            addMemberRoot = addMemberLoader.load();
            AddMemberPageController addMemberPageController = addMemberLoader.getController();
            addMemberPageController.initializeController();

            FXMLLoader personalInformationLoader = new FXMLLoader(getClass().getResource("/personal_information_page.fxml"));
            personalInformationRoot = personalInformationLoader.load();
            PersonalInformationPageController personalInformationPageController = personalInformationLoader.getController();
            personalInformationPageController.initializeController();

            FXMLLoader freeTimeLoader = new FXMLLoader(getClass().getResource("/free_time_page/free_time_collect_page.fxml"));
            freeTimeRoot = freeTimeLoader.load();
            FreeTimeCollectPageController freeTimeCollectPageController = freeTimeLoader.getController();
            freeTimeCollectPageController.initializeController();

            //设置初始页面

            contentPageA.setContent(userManagementRoot);
            contentPageC.setContent(freeTimeRoot);
            contentPageB.setVisible(false);
            contentPageC.setVisible(false);

            //按钮事件

            userManagement.setOnMouseClicked(event -> {
                if(event.getButton() == MouseButton.PRIMARY) {
                    if(!contentPageA.isVisible()) {
                        contentPageB.setVisible(false);
                        contentPageC.setVisible(false);
                        contentPageA.setVisible(true);
                    }
                }
            });

            addMember.setOnMouseClicked(event -> {
                if(event.getButton() == MouseButton.PRIMARY) {
                    if(!contentPageB.isVisible()) {
                        contentPageB.setContent(addMemberRoot);
                        contentPageA.setVisible(false);
                        contentPageC.setVisible(false);
                        contentPageB.setVisible(true);
                    }
                }
            });

            personalInformation.setOnMouseClicked(event -> {
                if(event.getButton() == MouseButton.PRIMARY) {
                    if(!contentPageB.isVisible()) {
                        contentPageB.setContent(personalInformationRoot);
                        contentPageA.setVisible(false);
                        contentPageC.setVisible(false);
                        contentPageB.setVisible(true);
                    }
                }
            });

            freeTimeCollect.setOnMouseClicked(event -> {
                if(event.getButton() == MouseButton.PRIMARY) {
                    if(!contentPageC.isVisible()) {
                        contentPageA.setVisible(false);
                        contentPageB.setVisible(false);
                        contentPageC.setVisible(true);
                    }
                }
            });

        } catch(Exception exp) {
            System.out.println(exp.toString());
        }
    }
}
