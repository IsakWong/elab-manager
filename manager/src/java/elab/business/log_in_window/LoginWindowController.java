package elab.business.log_in_window;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import elab.application.BaseViewController;
import elab.application.ElabManagerApplication;
import elab.business.main_window.MainWindowController;
import elab.database.DatabaseOperations;
import elab.serialization.beans.member.LoginMessage;
import elab.util.Utilities;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.rxjavafx.schedulers.JavaFxScheduler;
import io.reactivex.schedulers.Schedulers;
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

    private LoginMessage loginMessage;

    @FXML
    private HBox topBar;
    @FXML
    private Button logButton;
    @FXML
    private JFXButton closeBtn;
    @FXML
    private JFXButton minBtn;
    @FXML
    private JFXPasswordField pwdInputField;
    @FXML
    private JFXTextField userInputField;
    @FXML
    private VBox container;


    boolean isLogging = false;
    private double x1;
    private double y1;
    private double x_stage;
    private double y_stage;

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
            System.out.println(exp);
        }

    }

    public void asynchronousProcessing() {
        if(!isLogging)
        {
            isLogging = true;
            Utilities.popMessage("正在登录中",container);
            ObservableOnSubscribe<Boolean> ob = new ObservableOnSubscribe<Boolean>(){

                @Override
                public void subscribe(ObservableEmitter<Boolean> observableEmitter) throws Exception {
                    observableEmitter.onNext(isUserValidated(userInputField.getText(), pwdInputField.getText()));
                    isLogging = false;
                }
            };
            Observable.create(ob)
                    .subscribeOn(Schedulers.io())
                    .observeOn(JavaFxScheduler.platform())
                    .subscribe(new Observer<Boolean>() {
                                   @Override
                                   public void onSubscribe(Disposable disposable) {
                                   }

                                   @Override
                                   public void onNext(Boolean s) {
                                       if (s.booleanValue())
                                           showMainWindow();
                                       else
                                           Utilities.popMessage("用户名或密码错误", container);
                                   }

                                   @Override
                                   public void onError(Throwable throwable) {
                                   }

                                   @Override
                                   public void onComplete() {
                                   }
                               }
                    );
        }else
        {
            Utilities.popMessage("正在登录中",container);
        }

    }

    public boolean isPwdValidated(String number, String password) {
        loginMessage = DatabaseOperations.getInstance().selectLoginMessage(number);
        if (loginMessage == null) {
            return false;
        } else if (!Utilities.encrypt(password).equals(loginMessage.getPassword())) {
            return false;
        } else {
            loginMessage.setOldNumber(loginMessage.getNumber());
            return true;
        }
    }

    public boolean isUserValidated(String number, String password) {
        if(!isPwdValidated(number, password)) {
            Utilities.popMessage("用户名或密码错误", container);
            return false;
        } else
            return true;
    }

    @Override
    public void initializeController() {

        userInputField.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER)
                pwdInputField.requestFocus();
        });

        pwdInputField.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                if (userInputField.getText().equals("") || pwdInputField.getText().equals(""))
                    Utilities.popMessage("用户名和密码不能为空", container);
                else
                    asynchronousProcessing();
            }
        });

        logButton.setOnAction(event -> {
            if (userInputField.getText().equals("") || pwdInputField.getText().equals(""))
                Utilities.popMessage("用户名和密码不能为空", container);
            else
                asynchronousProcessing();
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