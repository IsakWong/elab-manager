package elab.business.main_window;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTabPane;
import elab.application.BaseViewController;
import elab.application.BaseFunctionContentController;
import elab.application.BaseModulePageController;
import elab.serialization.module.Function;
import elab.serialization.module.Module;
import elab.util.Utilities;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Tab;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.lang.reflect.Type;
import java.util.ArrayList;

import static java.lang.Double.MAX_VALUE;

public class MainWindowController extends BaseViewController {

    @FXML
    private HBox topBar;
    @FXML
    private JFXTabPane tabPane;
    @FXML
    private JFXButton mainMenuCloseBtn;
    @FXML
    private JFXButton mainMenuMinBtn;

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
            mainMenuCloseBtn.setGraphic(Utilities.getImage("/pictures/close.png"));

            mainMenuMinBtn.setOnMouseClicked(event -> {
                if (event.getButton() == MouseButton.PRIMARY) {
                    Stage stage = (Stage) mainMenuMinBtn.getScene().getWindow();
                    stage.setIconified(true);
                }
            });
            mainMenuMinBtn.setGraphic(Utilities.getImage("/pictures/min.png"));

            tabPane.setOnMouseDragged(event -> {
                if (event.getButton() == MouseButton.PRIMARY) {
                    Stage stage = (Stage) tabPane.getScene().getWindow();
                    stage.setX(x_stage + event.getScreenX() - x1);
                    stage.setY(y_stage + event.getScreenY() - y1);
                }
            });

            tabPane.setOnMousePressed(event -> {
                if (event.getButton() == MouseButton.PRIMARY) {
                    Stage stage = (Stage) tabPane.getScene().getWindow();
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
                FXMLLoader moduleLoader = new FXMLLoader(getClass().getResource("/business_pages/module_page.fxml"));
                Parent root = moduleLoader.load();
                Tab userTab = new Tab();


                userTab.setText(module.ModuleName);
                BaseModulePageController moduleController = moduleLoader.getController();
                moduleController.initializeController();

                module.FxmlRoot = root;
                module.Controller = moduleController;

                Pane container = (Pane) module.FxmlRoot.lookup("#container");
                for (final Function func : module.Functions) {
                    JFXButton funcBtn = new JFXButton();
                    func.ParentModule = module;
                    funcBtn.getStyleClass().add("left-panel-button");
                    funcBtn.setText(func.FunctionName);
                    funcBtn.setMaxWidth(MAX_VALUE);
                    funcBtn.setOnMouseClicked(event -> {
                        if (event.getButton() == MouseButton.PRIMARY) {
                            try {
                                if (!func.IsFxmlInitialized) {

                                    long begintime = System.nanoTime();

                                    FXMLLoader functionLoader = new FXMLLoader(getClass().getResource(func.FunctionFXML));
                                    Parent functionRoot = functionLoader.load();
                                    BaseFunctionContentController baseViewController = functionLoader.getController();

                                    long endtime = System.nanoTime();
                                    float costTime = (endtime - begintime)/1000000;
                                    System.out.println(func.FunctionName + " FXML 加载完毕，加载时间为：" + costTime + " 毫秒");

                                    baseViewController.ParentModuleController = moduleController;
                                    begintime = System.nanoTime();

                                    baseViewController.initializeController();

                                    endtime = System.nanoTime(); costTime = (endtime - begintime)/1000000;
                                    System.out.println(func.FunctionName + " 初始化完毕 ，加载时间为：" + costTime + " 毫秒");

                                    func.IsFxmlInitialized = true;
                                    func.FxmlRoot = functionRoot;
                                    func.Controller = baseViewController;

                                    moduleController.addFunctionContent(func);
                                    moduleController.setCurrentFunction(func);
                                    moduleController.BeginLoading();

                                } else {

                                    moduleController.setCurrentFunction(func);
                                    moduleController.BeginLoading();
                                }
                            } catch (Exception excep) {
                                excep.printStackTrace();
                            }
                        }
                    });
                    moduleController.leftPanel.getChildren().add(funcBtn);
                }
                userTab.setContent(root);
                tabPane.getTabs().add(userTab);
            }
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }
}
