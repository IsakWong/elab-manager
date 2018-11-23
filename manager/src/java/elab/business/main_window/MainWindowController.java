package elab.business.main_window;

import com.jfoenix.controls.JFXTabPane;
import elab.application.BaseViewController;
import elab.business.module_tab.MemberTabController;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Tab;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
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

            mainMenuCloseBtn.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    Stage stage = (Stage) mainMenuCloseBtn.getScene().getWindow();
                    stage.close();
                }
            });

            mainMenuMinBtn.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    Stage stage = (Stage) mainMenuMinBtn.getScene().getWindow();
                    stage.setIconified(true);
                }
            });

            tabPane.setOnMouseDragged(dragHandler);
            tabPane.setOnMousePressed(pressHandler);
            topBar.setOnMouseDragged(dragHandler);
            topBar.setOnMousePressed(pressHandler);

            Tab userTab = new Tab();
            userTab.setText("成员管理");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/member_tab.fxml"));
            Parent root = loader.load();
            userTab.setContent(root);
            BaseViewController controller = loader.getController();
            controller.initializeController();

            //controller.TabModule = module;
            tabPane.getTabs().add(userTab);

            Tab assistTab = new Tab();
            assistTab.setText("助课管理");
            Parent root2 = FXMLLoader.load(getClass().getResource("/assist_teaching_tab.fxml"));
            assistTab.setContent(root2);
            tabPane.getTabs().add(assistTab);
            controller = loader.getController();
            controller.initializeController();

            Tab registerTab = new Tab();
            registerTab.setText("签到与值班");
            Parent root3 = FXMLLoader.load(getClass().getResource("/register_tab.fxml"));
            registerTab.setContent(root3);
            tabPane.getTabs().add(registerTab);
            controller = loader.getController();
            controller.initializeController();

            Tab systemControlTab = new Tab();
            systemControlTab.setText("系统控制");
            Parent root4 = FXMLLoader.load(getClass().getResource("/system_ctrl_tab.fxml"));
            systemControlTab.setContent(root4);
            tabPane.getTabs().add(systemControlTab);
            controller = loader.getController();
            controller.initializeController();



        } catch (Exception exp) {
            System.out.print(exp.toString());
        }
    }
}
