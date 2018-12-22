package elab.business.member_tab_function_controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import elab.application.BaseViewController;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseButton;

public class PersonalInformationPageController extends BaseViewController {

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
    private JFXButton PwdReturnButton;
    @FXML
    private RadioButton sexChoose_man;
    @FXML
    private RadioButton sexChoose_woman;

    @Override
    public void initializeController() {

        PwdReturnButton.setOnMouseClicked(event -> {
            if(event.getButton() == MouseButton.PRIMARY) {
                pwdInputField.setText("");
                twicePwdInputField.setText("");
            }
        });

        collegeChooseBox.getItems().addAll(
                new Label("电子信息与电气工程学部"),
                new Label("化学与环境生命学部"),
                new Label("建设工程学部"),
                new Label("运载工程与力学学部"),
                new Label("机械工程与材料能源学部"),
                new Label("管理与经济学部"),
                new Label("人文与社会科学学部"),
                new Label("建筑与艺术学院"),
                new Label("外国语学院")
        );

        sexChoose_man.setOnAction(event -> {
            sexChoose_woman.setSelected(sexChoose_man.isSelected());
        });

        sexChoose_woman.setOnAction(event -> {
            sexChoose_man.setSelected(sexChoose_woman.isSelected());
        });
    }
}
