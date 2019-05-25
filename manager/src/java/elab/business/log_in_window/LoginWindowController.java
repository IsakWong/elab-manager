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
import elab.serialization.beans.log.Log;
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
import javafx.scene.paint.Color;
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
    private String duty;
    private String logInformation;

    private double x1;
    private double y1;
    private double x_stage;
    private double y_stage;

    private Boolean isUserChanged = false;
    private Boolean isPwdChanged = false;

    Session<LoginMessage> loginSession = new Session<LoginMessage>() {

        @Override
        public void onPostFetchResult(SessionResult<LoginMessage> sessionResult) {
            setControlDisable(true);
            sessionResult.result = DatabaseOperations.getInstance().selectLoginMessage(user);
            if (sessionResult.result == null)
                sessionResult.errorMessage = "无此学号用户";
            else if (md5Password.equals(sessionResult.result.getPassword())) {

            } else {
                sessionResult.result = null;
                sessionResult.errorMessage = "用户名或密码错误";
            }
        }

        @Override
        public void onSuccess(LoginMessage param) {
            //保存登陆凭证
            param.setValid(true);
            ElabManagerApplication.currentCertification = param;
            if(param.getDuty() == null)
                duty = "同学";
            else
                duty = "班委";
            writeUserInformationToDisk();
            showMainWindow();
            loginSession.IsSending = false;
        }

        @Override
        public void onError(String errorMessage) {
            logInformation = "密码错误";
            writeLogSession.send();
            setControlDisable(false);
            Utilities.popMessage(errorMessage, container);
        }

        @Override
        public void onBusy() {
            Utilities.popMessage("正在登陆中", container);
        }
    };

    Session<Boolean> writeLogSession = new Session<Boolean>() {
        @Override
        public void onPostFetchResult(SessionResult<Boolean> sessionResult) {
            Log log = new Log();
            log.setInformation(logInformation);
            log.setOperatingNumber(userInputField.getText());
            log.setTime(Utilities.getSystemDate("yyyy-MM-dd HH:mm:ss"));
            log.setIP(Utilities.getIP());
            log.setVersion(ElabManagerApplication.properties.getProperty("VERSION"));
            log.setTerm(DatabaseOperations.getInstance().selectSchoolOpeningDateInformation().getTerm());
            log.setID(null);
            log.setOperatedNumber(null);
            log.setHardScore(null);
            log.setSoftScore(null);
            log.setPaperScore(null);
            DatabaseOperations.getInstance().writeLog(log);
        }

        @Override
        public void onSuccess(Boolean param) {
        }

        @Override
        public void onError(String errorMessage) {
        }

        @Override
        public void onBusy() {
        }
    };

    private void setControlDisable(Boolean statue) {
        userInputField.setDisable(statue);
        pwdInputField.setDisable(statue);
        autoLogin.setDisable(statue);
        rememberPwd.setDisable(statue);
        logButton.setDisable(statue);
    }

    private void loadUserInformationFromDisk() {
        try {
            String autoLoginProperty = ElabManagerApplication.properties.getProperty("AUTO_LOG_IN");
            String rememberPwdProperty = ElabManagerApplication.properties.getProperty("REMEMBER_PASSWORD");
            user = ElabManagerApplication.properties.getProperty("LAST_LOG_IN_USER");
            md5Password = ElabManagerApplication.properties.getProperty("LAST_LOG_IN_USER_PASSWORD");
            userInputField.setText(user);
            if (rememberPwdProperty == null) {

            } else {
                if (rememberPwdProperty.equals("true")) {
                    rememberPwd.setSelected(true);
                    pwdInputField.setText("0123456789");
                }
            }
            if (autoLoginProperty == null) {

            } else {
                if (autoLoginProperty.equals("true")) {
                    autoLogin.setSelected(true);
                    if (user != null && md5Password != null) {
                        Utilities.popMessage("正在登陆中", container);
                        loginSession.send();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeUserInformationToDisk() {
        ElabManagerApplication.properties.setProperty("LAST_LOG_IN_USER", user);
        ElabManagerApplication.properties.setProperty("LAST_LOG_IN_USER_PASSWORD", md5Password);
        ElabManagerApplication.properties.setProperty("LAST_LOG_IN_USER_DUTY", duty);
    }

    public void showMainWindow() {
        if( !ElabManagerApplication.currentCertification.isValid())
            return;
        try {
            if(duty.equals("班委"))
                logInformation = "管理员登录";
            else
                logInformation = "科中成员登陆";
            writeLogSession.send();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/business_pages/main_window.fxml"));
            Parent root = loader.load();
            MainWindowController controller = loader.getController();
            Stage mainStage = new Stage();
            mainStage.initStyle(StageStyle.TRANSPARENT);
            float width =Float.valueOf(ElabManagerApplication.properties.getProperty("WINDOW_WIDTH"));
            float height = Float.valueOf(ElabManagerApplication.properties.getProperty("WINDOW_HEIGHT"));
            Scene scene = new Scene(root);
            mainStage.setScene(scene);
            scene.setFill(Color.TRANSPARENT);
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

        autoLogin.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == true) {
                rememberPwd.setSelected(true);
                ElabManagerApplication.properties.setProperty("AUTO_LOG_IN", "true");
            } else {
                ElabManagerApplication.properties.setProperty("AUTO_LOG_IN", "false");
            }
        });

        rememberPwd.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == true) {
                ElabManagerApplication.properties.setProperty("REMEMBER_PASSWORD", "true");
            } else {
                ElabManagerApplication.properties.setProperty("REMEMBER_PASSWORD", "false");
            }
        });

        userInputField.textProperty().addListener((observable, oldValue, newValue) -> {
            isUserChanged = true;
        });

        userInputField.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER)
                pwdInputField.requestFocus();
        });

        pwdInputField.textProperty().addListener((observable, oldValue, newValue) -> {
            isPwdChanged = true;
        });

        pwdInputField.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                if (userInputField.getText().equals("") || pwdInputField.getText().equals(""))
                    Utilities.popMessage("用户名和密码不能为空", container);
                else {
                    if(isUserChanged)
                        user = userInputField.getText();
                    if(isPwdChanged)
                        md5Password = Utilities.encrypt(pwdInputField.getText());
                    Utilities.popMessage("正在登陆中", container);
                    loginSession.send();
                }
            }
        });

        logButton.setOnMouseClicked(event -> {
            if(event.getButton() == MouseButton.PRIMARY) {
                if (userInputField.getText().equals("") || pwdInputField.getText().equals(""))
                    Utilities.popMessage("用户名和密码不能为空", container);
                else {
                    if(isUserChanged)
                        user = userInputField.getText();
                    if(isPwdChanged)
                        md5Password = Utilities.encrypt(pwdInputField.getText());
                    Utilities.popMessage("正在登陆中", container);
                    loginSession.send();
                }
            }
        });

        closeBtn.setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.PRIMARY) {
                if(duty.equals("班委"))
                    logInformation = "管理员退出";
                else
                    logInformation = "科中成员退出";
                writeLogSession.send();
                ElabManagerApplication.primaryStage.close();
            }
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