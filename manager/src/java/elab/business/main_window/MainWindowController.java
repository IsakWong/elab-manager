package elab.business.main_window;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTabPane;
import com.sun.org.apache.xpath.internal.operations.Mod;
import elab.application.BaseViewController;
import elab.application.BaseFunctionContentController;
import elab.application.BaseModulePageController;
import elab.application.ElabManagerApplication;
import elab.database.DatabaseOperations;
import elab.database.Session;
import elab.serialization.beans.log.Log;
import elab.serialization.beans.member.LoginMessage;
import elab.serialization.module.Function;
import elab.serialization.module.Module;
import elab.util.Utilities;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Tab;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javax.swing.*;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class MainWindowController extends BaseViewController {

    @FXML
    private JFXTabPane tabPane;
    @FXML
    private JFXButton mainMenuCloseBtn;
    @FXML
    private JFXButton mainMenuMinBtn;

    ArrayList<Module> moduleList;

    private double x1;
    private double y1;
    private double x_stage;
    private double y_stage;

    Session<Boolean> closeLogSession = new Session<Boolean>() {
        @Override
        public void onPostFetchResult(SessionResult<Boolean> sessionResult) {
            Log log = new Log();
            if(ElabManagerApplication.properties.getProperty("LAST_LOG_IN_USER_DUTY").equals("班委"))
                log.setInformation("管理员退出");
            else
                log.setInformation("科中成员退出");
            log.setOperatingNumber(ElabManagerApplication.properties.getProperty("LAST_LOG_IN_USER"));
            log.setTime(Utilities.getSystemDate("yyyy-MM-dd HH:mm:ss"));
            log.setIP(Utilities.getIP());
            log.setVersion(ElabManagerApplication.properties.getProperty("VERSION"));
            log.setTerm(DatabaseOperations.getInstance().selectSchoolOpeningDateInformation().getTerm());
            log.setID(null);
            log.setOperatedNumber(null);
            log.setHardScore(null);
            log.setSoftScore(null);
            log.setPaperScore(null);
            sessionResult.result = DatabaseOperations.getInstance().writeLog(log);
        }

        @Override
        public void onSuccess(Boolean param) {
            Stage stage = (Stage) mainMenuCloseBtn.getScene().getWindow();
            stage.close();
        }

        @Override
        public void onError(String errorMessage) {
            Stage stage = (Stage) mainMenuCloseBtn.getScene().getWindow();
            stage.close();
        }

        @Override
        public void onBusy() {

        }
    };

    private void loadModuleFunctionFxmlAtIndex(Module module , int index)
    {
        Module selectModule = module;
        BaseModulePageController moduleController = selectModule.Controller;
        try {
            if(index >= selectModule.Functions.length)
                return;
            Function func = selectModule.Functions[index];
            if (!func.IsFxmlInitialized) {

                long begintime = System.nanoTime();

                FXMLLoader functionLoader = new FXMLLoader(getClass().getResource(func.FunctionFXML));
                Pane functionRoot = functionLoader.load();
                BaseFunctionContentController baseViewController = functionLoader.getController();

                long endtime = System.nanoTime();
                float costTime = (endtime - begintime) / 1000000;
                System.out.println(func.FunctionName + " FXML 加载完毕，加载时间为：" + costTime + " 毫秒");

                baseViewController.ParentModuleController = selectModule.Controller;
                begintime = System.nanoTime();

                baseViewController.initializeController();

                endtime = System.nanoTime();
                costTime = (endtime - begintime) / 1000000;
                System.out.println(func.FunctionName + " 初始化完毕 ，加载时间为：" + costTime + " 毫秒");

                func.IsFxmlInitialized = true;
                func.FxmlRoot = functionRoot;
                func.Controller = baseViewController;

                moduleController.addFunctionContent(func);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initTabPane()
    {
        tabPane.setOnMouseDragged(event -> {
            if (event.getButton() == MouseButton.PRIMARY) {
                Stage stage = (Stage) tabPane.getScene().getWindow();
                stage.setX(x_stage + event.getScreenX() - x1);
                stage.setY(y_stage + event.getScreenY() - y1);
            }
        });

        tabPane.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if(moduleList != null)
                {
                    Module selectModule = moduleList.get(newValue.intValue());
                    BaseModulePageController moduleController = selectModule.Controller;
                    if( selectModule != null && moduleController != null)
                    {
                        if(moduleController.getCurrentFunction() == null && selectModule.Functions != null && selectModule.Functions[0] != null)
                        {
                            Function func = selectModule.Functions[0];
                            long begintime = System.nanoTime();
                            loadModuleFunctionFxmlAtIndex(selectModule,0);
                            moduleController.setCurrentFunction(selectModule.Functions[0]);
                            moduleController.beginLoading();
                            long endtime = System.nanoTime();
                            float costTime = (endtime - begintime) / 1000000;
                            System.out.println(func.FunctionName + " 显示完毕 ，加载时间为：" + costTime + " 毫秒");
                        }
                    }
                }
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

    }
    private void initToolbar()
    {
        mainMenuCloseBtn.setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.PRIMARY) {
                closeLogSession.send();
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
    }
    public void initializeController() {


        try {

            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

            Gson gson = new Gson();
            String moduleJson;
            String duty = ElabManagerApplication.currentCertification.getDuty();
            if(duty.equals("班委"))
                moduleJson = Utilities.loadStringFromStream(getClass().getResourceAsStream("/modules_settings/admin_modules.json"));
            else
                moduleJson = Utilities.loadStringFromStream(getClass().getResourceAsStream("/modules_settings/user_modules.json"));
            Type typeList = new TypeToken<ArrayList<Module>>() {}.getType();

            moduleList = gson.fromJson(moduleJson, typeList);

            for (Module module : moduleList) {
                FXMLLoader moduleLoader = new FXMLLoader(getClass().getResource(module.ModuleFxml));
                Parent root = moduleLoader.load();
                Tab userTab = new Tab();
                userTab.setText(module.ModuleName);
                BaseModulePageController moduleController = moduleLoader.getController();
                moduleController.initializeController();

                module.FxmlRoot = root;
                module.Controller = moduleController;

                Pane container = (Pane) module.FxmlRoot.lookup("#container");
                for (final Function func : module.Functions) {
                    Label label = new Label(func.FunctionName);
                    moduleController.list.getItems().add(label);
                }
                moduleController.list.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
                moduleController.list.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                        loadModuleFunctionFxmlAtIndex(module,newValue.intValue());
                        moduleController.setCurrentFunction(module.Functions[newValue.intValue()]);
                        moduleController.beginLoading();
                    }
                });
                userTab.setContent(root);
                tabPane.getTabs().add(userTab);
            }
        } catch (Exception exp) {
            exp.printStackTrace();
        }

        initToolbar();
        initTabPane();
    }
}
