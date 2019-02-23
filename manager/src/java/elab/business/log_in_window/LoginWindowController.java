package elab.business.log_in_window;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import elab.application.BaseViewController;
import elab.application.ElabManagerApplication;
import elab.business.main_window.MainWindowController;
import elab.database.DatabaseOperations;
import elab.database.Session;
import elab.serialization.beans.member.LoginMessage;
import elab.util.Utilities;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class LoginWindowController extends BaseViewController {


    @FXML
    private HBox topBar;
    @FXML
    private Button logButton;
    @FXML
    private JFXButton closeBtn;
    @FXML
    private JFXButton minBtn;
    @FXML
    private JFXCheckBox autoLogin;
    @FXML
    private JFXCheckBox rememberPwd;
    @FXML
    private JFXPasswordField pwdInputField;
    @FXML
    private JFXTextField userInputField;
    @FXML
    private VBox container;

    private String user;
    private String md5Password;

    Session<LoginMessage> loginSession = new Session<LoginMessage>() {
        @Override
        public void onPostFetchResult(SessionResult<LoginMessage> sessionResult) {
            sessionResult.result = DatabaseOperations.getInstance().selectLoginMessage(user);
            if (md5Password.equals(sessionResult.result.getPassword())) {

            } else {
                sessionResult.result = null;
                sessionResult.errorMessage = "用户名密码错误";
            }
            if (sessionResult.result == null)
                sessionResult.errorMessage = "无此学号用户";
        }

        @Override
        public void onSuccess(LoginMessage param) {
            writeUserInfomationToDisk();
            showMainWindow();
        }

        @Override
        public void onError(String errorMessage) {
            Utilities.popMessage(errorMessage, container);
        }

        @Override
        public void onBusy() {
            Utilities.popMessage("正在登陆中", container);
        }
    };

    private double x1;
    private double y1;
    private double x_stage;
    private double y_stage;

    public void loadUserInformationFromDisk() {
        try {
            String autoLoginProperty = ElabManagerApplication.properties.getProperty("AUTO_LOG_IN");
            String rememberPwdProperty = ElabManagerApplication.properties.getProperty("REMEMBER_PASSWORD");
            if (autoLoginProperty == null) {

            } else {
                if (autoLoginProperty.equals("true")) {
                    autoLogin.setSelected(true);
                    user = ElabManagerApplication.properties.getProperty("LAST_LOG_IN_USER");
                    md5Password = ElabManagerApplication.properties.getProperty("LAST_LOG_IN_USER_PASSWORD");
                    if (user != null && md5Password != null) {
                        Utilities.popMessage("正在登陆中", container);
                        loginSession.send();
                    }
                }
            }
            if (rememberPwdProperty == null) {

            } else {
                if (rememberPwdProperty.equals("true")) {
                    rememberPwd.setSelected(true);
                    userInputField.setText(user);
                    pwdInputField.setText(md5Password);
                }
            }

        } catch (Exception e) {

        }
    }

    public void writeUserInfomationToDisk() {
        if (autoLogin.isSelected()) {
            ElabManagerApplication.properties.setProperty("AUTO_LOG_IN", "true");
            ElabManagerApplication.properties.setProperty("REMEMBER_PASSWORD", "true");
            ElabManagerApplication.properties.setProperty("LAST_LOG_IN_USER", user);
            ElabManagerApplication.properties.setProperty("LAST_LOG_IN_USER_PASSWORD", md5Password);
        }
        if (rememberPwd.isSelected()) {
            ElabManagerApplication.properties.setProperty("REMEMBER_PASSWORD", "true");
            ElabManagerApplication.properties.setProperty("LAST_LOG_IN_USER", user);
            ElabManagerApplication.properties.setProperty("LAST_LOG_IN_USER_PASSWORD", md5Password);
        }
    }

    public void showMainWindow() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/business_pages/main_window.fxml"));
            Parent root = loader.load();
            MainWindowController controller = loader.getController();
            Stage mainStage = new Stage();
            mainStage.initStyle(StageStyle.UNDECORATED);
            mainStage.setScene(new Scene(root, 1200, 800));
            controller.initializeController();
            mainStage.show();
            ElabManagerApplication.primaryStage.close();
        } catch (Exception exp) {
            exp.printStackTrace();
        }

    }

    @Override
    public void initializeController() {

        loadUserInformationFromDisk();

        autoLogin.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (newValue == true) {
                    rememberPwd.setSelected(true);
                }
            }
        });

        userInputField.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER)
                pwdInputField.requestFocus();
        });

        pwdInputField.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                if (userInputField.getText().equals("") || pwdInputField.getText().equals(""))
                    Utilities.popMessage("用户名和密码不能为空", container);
                else {

                    user = userInputField.getText();
                    md5Password = Utilities.encrypt(pwdInputField.getText());
                    Utilities.popMessage("正在登陆中", container);
                    loginSession.send();
                }
            }
        });

        logButton.setOnAction(event -> {
            if (userInputField.getText().equals("") || pwdInputField.getText().equals(""))
                Utilities.popMessage("用户名和密码不能为空", container);
            else {
                user = userInputField.getText();
                md5Password = Utilities.encrypt(pwdInputField.getText());
                Utilities.popMessage("正在登陆中", container);
                loginSession.send();
            }
        });

        closeBtn.setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.PRIMARY)
                ElabManagerApplication.primaryStage.close();
        });
        closeBtn.setGraphic(Utilities.getImage("/pictures/close.png"));

        minBtn.setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.PRIMARY) {
                Stage stage = (Stage) minBtn.getScene().getWindow();
                stage.setIconified(true);
            }
        });
        minBtn.setGraphic(Utilities.getImage("/pictures/min.png"));

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
}