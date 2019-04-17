package elab.business.module_function_controllers.settings;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import elab.application.BaseFunctionContentController;
import elab.application.ElabManagerApplication;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.input.MouseButton;

public class ManagerSettings extends BaseFunctionContentController {

    @FXML
    private JFXCheckBox autoLoginBox;
    @FXML
    private JFXCheckBox rememberPwdBox;

    private String autoLogin = ElabManagerApplication.properties.getProperty("AUTO_LOG_IN");
    private String rememberPwd = ElabManagerApplication.properties.getProperty("REMEMBER_PASSWORD");

    public void initializeController() {

        if(autoLogin.equals("true"))
            autoLoginBox.setSelected(true);

        if(rememberPwd.equals("true"))
            rememberPwdBox.setSelected(true);

        autoLoginBox.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue == true) {
                    ElabManagerApplication.properties.setProperty("AUTO_LOG_IN", "true");
                } else {
                    ElabManagerApplication.properties.setProperty("AUTO_LOG_IN", "false");
                }
            }
        });

        rememberPwdBox.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue == true) {
                    ElabManagerApplication.properties.setProperty("REMEMBER_PASSWORD", "true");
                } else {
                    ElabManagerApplication.properties.setProperty("REMEMBER_PASSWORD", "false");
                }
            }
        });

        finishLoading();
    }
}
