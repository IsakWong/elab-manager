package elab.business.main_window;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTabPane;
import elab.application.BaseViewController;
import elab.business.ModulePageController;
import elab.serialization.module.Function;
import elab.serialization.module.Module;
import elab.util.Utilities;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Double.MAX_VALUE;


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

    public void initializeController() {
        try {

            mainMenuCloseBtn.setOnMouseClicked(event -> {
                if (event.getButton() == MouseButton.PRIMARY) {
                    Stage stage = (Stage) mainMenuCloseBtn.getScene().getWindow();
                    stage.close();
                }
            });

            mainMenuMinBtn.setOnMouseClicked(event -> {
                if (event.getButton() == MouseButton.PRIMARY) {
                    Stage stage = (Stage) mainMenuMinBtn.getScene().getWindow();
                    stage.setIconified(true);
                }
            });

            topBar.setOnMouseDragged(event -> {
                if (event.getButton() == MouseButton.PRIMARY) {
                    Stage stage = (Stage) topBar.getScene().getWindow();
                    stage.setX(x_stage + event.getScreenX() - x1);
                    stage.setY(y_stage + event.getScreenY() - y1);
                }
            });

            topBar.setOnMousePressed(event -> {
                if (event.getButton() == MouseButton.PRIMARY) {
                    Stage stage = (Stage) topBar.getScene().getWindow();
                    x1 = event.getScreenX();
                    y1 = event.getScreenY();
                    x_stage = stage.getX();
                    y_stage = stage.getY();
                }
            });

            Gson gson = new Gson();
            String moduleJson = Utilities.loadStringFromStream(getClass().getResourceAsStream("/modules_settings/manager_modules.json"));
            Type typeList = new TypeToken<ArrayList<Module>>() {
            }.getType();
            ArrayList<Module> moduleList = gson.fromJson(moduleJson, typeList);
            for (Module module : moduleList) {
                FXMLLoader moduleLoader = new FXMLLoader(getClass().getResource("/module_page.fxml"));
                Parent root = moduleLoader.load();
                Tab userTab = new Tab();
                module.Root = root;
                userTab.setText(module.ModuleName);
                ModulePageController modulePageController = moduleLoader.getController();
                modulePageController.initializeController();

                for (final Function func : module.Functions) {
                    JFXButton funcBtn = new JFXButton();
                    func.ParentModule = module;
                    funcBtn.getStyleClass().add("left-panel-button");
                    funcBtn.setText(func.FunctionName);
                    funcBtn.setMaxWidth(MAX_VALUE);
                    FXMLLoader functionLoader = new FXMLLoader(getClass().getResource(func.FunctionFXML));
                    Parent functionRoot = functionLoader.load();
                    ArrayList<ScrollPane> scrollPanes = func.ParentModule.scrollPanes;
                    ScrollPane functionScrollPane = new ScrollPane();
                    functionScrollPane.setContent(functionRoot);
                    functionScrollPane.setVisible(false);
                    scrollPanes.add(functionScrollPane);
                    BaseViewController baseViewController = functionLoader.getController();
                    baseViewController.initializeController();
                    func.Root = functionRoot;
                    func.IsInit = true;
                    funcBtn.setOnMouseClicked(event -> {
                        if(event.getButton() == MouseButton.PRIMARY) {
                            for(int i = 0; i < scrollPanes.size(); ++i)
                                if(scrollPanes.get(i).isVisible())
                                    scrollPanes.get(i).setVisible(false);
                            functionScrollPane.setVisible(true);
                        }
                    });
                    modulePageController.leftPanel.getChildren().add(funcBtn);
                }
                AnchorPane container = (AnchorPane) module.Root.lookup("#container");
                container.getChildren().addAll(module.scrollPanes);
                userTab.setContent(root);
                tabPane.getTabs().add(userTab);
            }
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }
}
