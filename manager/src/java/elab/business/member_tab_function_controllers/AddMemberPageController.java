package elab.business.member_tab_function_controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import elab.application.BaseViewController;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;

public class AddMemberPageController extends BaseViewController {

    @FXML
    private JFXTextField numberInputField;
    @FXML
    private JFXTextField userInputField;
    @FXML
    private JFXTextField nameInputField;
    @FXML
    private JFXTextField telInputField;
    @FXML
    private JFXPasswordField pwdInputField;
    @FXML
    private JFXPasswordField twicePwdInputField;
    @FXML
    private JFXComboBox collegeChooseBox;
    @FXML
    private JFXComboBox groupChooseBox;
    @FXML
    private JFXButton logButton;
    @FXML
    private JFXButton returnButton;
    @FXML
    private RadioButton sexChoose_man;
    @FXML
    private RadioButton sexChoose_woman;

    @Override
    public void initializeController() {

    }
}
