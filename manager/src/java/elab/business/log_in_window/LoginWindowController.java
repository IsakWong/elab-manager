package elab.business.log_in_window;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXSnackbar;
import com.jfoenix.controls.JFXTextField;
import elab.application.BaseViewController;
import elab.application.ElabManagerApplication;
import elab.business.main_window.MainWindowController;
import elab.database.DatabaseOperations;
import elab.serialization.member.LoginMessage;
import elab.serialization.member.Member;
import elab.serialization.module.Module;
import elab.util.Encryptioner;
import elab.utility.Utilities;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.apache.ibatis.session.SqlSession;
import sun.nio.cs.ArrayEncoder;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class LoginWindowController extends BaseViewController {

    private DatabaseOperations operations = new DatabaseOperations();
    private Encryptioner encryptioner = new Encryptioner();

    private LoginMessage loginMessage;

    @FXML
    private HBox topBar;
    @FXML
    private Button logButton;
    @FXML
    private ImageView closeBtn;
    @FXML
    private ImageView minBtn;
    @FXML
    private JFXPasswordField pwdInputField;
    @FXML
    private JFXTextField userInputField;
    @FXML
    private VBox container;

    private double x1;
    private double y1;
    private double x_stage;
    private double y_stage;

    public void loadModuleSettings(String toLoadModulesName) {
        Gson gson = new Gson();
        String strJson = Utilities.loadStringFromStream(getClass().getResourceAsStream("/modules_settings/" + toLoadModulesName));
        Type typeList = new TypeToken<ArrayList<Module>>() {
        }.getType();
        ElabManagerApplication.modulesArrayList = gson.fromJson(strJson, typeList);
    }

    public void popMessage(String message) {
        JFXSnackbar bar = new JFXSnackbar(container);
        JFXSnackbar.SnackbarEvent event = new JFXSnackbar.SnackbarEvent(message);
        bar.enqueue(event);
    }

    public void showMainWindow() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/main_window.fxml"));
            Parent root = loader.load();
            MainWindowController controller = loader.getController();
            Stage mainStage = new Stage();
            mainStage.initStyle(StageStyle.UNDECORATED);
            mainStage.setScene(new Scene(root, 1200, 800));
            controller.initializeController();
            mainStage.show();
            ElabManagerApplication.primaryStage.close();
        } catch (Exception exp) {

        }

    }

    public boolean isPwdValidated(int number, String password) {
        loginMessage = operations.selectLoginMessage(number);
        if(loginMessage == null) {
            return false;
        } else if(!encryptioner.encrypt(password).equals(loginMessage.getPassword())) {
            return false;
        }
        return true;
    }

    public boolean isUserValidated(int number, String password) {
        if (userInputField.getText().equals("") || pwdInputField.getText().equals("")) {
            popMessage("用户名和密码不能为空");
            return false;
        } else if(!isPwdValidated(number, password)) {
            popMessage("用户名或密码错误");
            return false;
        } else
            return true;
    }

    @Override
    public void initializeController() {

        /**
         * 加载数据库配置文件
         */

        DatabaseOperations databaseOperations = new DatabaseOperations();
        databaseOperations.build();

        userInputField.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER)
                pwdInputField.requestFocus();
        });

        pwdInputField.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER)
                if (isUserValidated(Integer.parseInt(userInputField.getText()), pwdInputField.getText())) {
                    showMainWindow();
                }
        });

        logButton.setOnAction(event -> {
            if (isUserValidated(Integer.parseInt(userInputField.getText()), pwdInputField.getText())) {
                showMainWindow();
            }
        });

        closeBtn.setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.PRIMARY)
                ElabManagerApplication.primaryStage.close();
        });

        minBtn.setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.PRIMARY) {
                Stage stage = (Stage) minBtn.getScene().getWindow();
                stage.setIconified(true);
            }
        });

        //Drag Event
        topBar.setOnMouseDragged(event -> {
            if (event.getButton() == MouseButton.PRIMARY) {
                ElabManagerApplication.primaryStage.setX(x_stage + event.getScreenX() - x1);
                ElabManagerApplication.primaryStage.setY(y_stage + event.getScreenY() - y1);
            }
        });

        topBar.setOnMousePressed(event -> {
            //按下鼠标后，记录当前鼠标的坐标
            if (event.getButton() == MouseButton.PRIMARY) {
                x1 = event.getScreenX();
                y1 = event.getScreenY();
                x_stage = ElabManagerApplication.primaryStage.getX();
                y_stage = ElabManagerApplication.primaryStage.getY();
            }
        });
    }
/*
    class LoginMessageSelectThread extends Thread {

        public void run() {
            DatabaseOperations databaseOperations = new DatabaseOperations();
            SqlSession session = databaseOperations.getSession();
            LoginMessage loginMessage = session.selectOne("member.findLoginMessage", 201782019);
            ArrayList<Member> members = new ArrayList<>();
            System.out.println(loginMessage);
            session.close();
        }
    }*/
}