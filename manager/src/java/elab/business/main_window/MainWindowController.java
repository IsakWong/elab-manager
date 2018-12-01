package elab.business.main_window;

import com.jfoenix.controls.JFXTabPane;
import elab.application.BaseViewController;
import elab.business.module_tab.AssistTeachingTabController;
import elab.business.module_tab.MemberTabController;
import elab.business.module_tab.RegisterTabController;
import elab.business.module_tab.SystemControlTabController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Tab;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class MainWindowController extends BaseViewController {

    @FXML
    private HBox topBar;
    @FXML
    private JFXTabPane tabPane;
    @FXML
    private ImageView mainMenuCloseBtn;
    @FXML
    private ImageView mainMenuMinBtn;

    private double x1;
    private double y1;
    private double x_stage;
    private double y_stage;

    EventHandler<MouseEvent> dragHandler = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {
            Stage stage = (Stage) topBar.getScene().getWindow();
            stage.setX(x_stage + event.getScreenX() - x1);
            stage.setY(y_stage + event.getScreenY() - y1);
        }
    };
    EventHandler<MouseEvent> pressHandler = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {
            Stage stage = (Stage) topBar.getScene().getWindow();
            x1 = event.getScreenX();
            y1 = event.getScreenY();
            x_stage = stage.getX();
            y_stage = stage.getY();
        }
    };
    public void initializeController() {
        try {

            mainMenuCloseBtn.setOnMousePressed(event ->{
                    Stage stage = (Stage) mainMenuCloseBtn.getScene().getWindow();
                    stage.close();
            });

            mainMenuMinBtn.setOnMousePressed(event -> {
                    Stage stage = (Stage) mainMenuMinBtn.getScene().getWindow();
                    stage.setIconified(true);
            });

<<<<<<< HEAD
            topBar.setOnMouseDragged(event -> {
                    Stage stage = (Stage) topBar.getScene().getWindow();
                    stage.setX(x_stage + event.getScreenX() - x1);
                    stage.setY(y_stage + event.getScreenY() - y1);
            });

            topBar.setOnMousePressed(event -> {
                Stage stage = (Stage) topBar.getScene().getWindow();
                x1 = event.getScreenX();
                y1 = event.getScreenY();
                x_stage = stage.getX();
                y_stage = stage.getY();
            });
=======
            tabPane.setOnMouseDragged(dragHandler);
            tabPane.setOnMousePressed(pressHandler);
            topBar.setOnMouseDragged(dragHandler);
            topBar.setOnMousePressed(pressHandler);
>>>>>>> da729542ebc1cbbfe3f0a03368f50cc7af316911

            Tab userTab = new Tab();
            userTab.setText("助课管理");
            FXMLLoader assistLoader = new FXMLLoader(getClass().getResource("/assist_teaching_tab.fxml"));
            Parent root = assistLoader.load();
            userTab.setContent(root);
<<<<<<< HEAD
            AssistTeachingTabController assistController = assistLoader.getController();
            assistController.initializeController();
=======
            BaseViewController controller = loader.getController();
            controller.initializeController();
>>>>>>> da729542ebc1cbbfe3f0a03368f50cc7af316911

            //controller.TabModule = module;
            tabPane.getTabs().add(userTab);

            Tab assistTab = new Tab();
            assistTab.setText("成员管理");
            FXMLLoader memberLoader = new FXMLLoader(getClass().getResource("/member_tab.fxml"));
            Parent memberRoot  = memberLoader.load();
            assistTab.setContent(memberRoot);
            MemberTabController memberController = memberLoader.getController();
            memberController.initializeController();
            tabPane.getTabs().add(assistTab);
            controller = loader.getController();
            controller.initializeController();

            Tab registerTab = new Tab();
            registerTab.setText("签到与值班");
            FXMLLoader registerLoader = new FXMLLoader(getClass().getResource("/register_tab.fxml"));
            Parent registerRoot = registerLoader.load();
            registerTab.setContent(registerRoot);
            RegisterTabController registerController = registerLoader.getController();
            registerController.initializeController();
            tabPane.getTabs().add(registerTab);
            controller = loader.getController();
            controller.initializeController();

            Tab systemControlTab = new Tab();
            systemControlTab.setText("系统控制");
            FXMLLoader sysCtrlLoader = new FXMLLoader(getClass().getResource("/system_ctrl_tab.fxml"));
            Parent sysCtrlRoot = sysCtrlLoader.load();
            systemControlTab.setContent(sysCtrlRoot);
            SystemControlTabController sysCtrlController = sysCtrlLoader.getController();
            sysCtrlController.initializeController();
            tabPane.getTabs().add(systemControlTab);
            controller = loader.getController();
            controller.initializeController();

        } catch (Exception exp) {
            System.out.print(exp.toString());
        }
    }
}
