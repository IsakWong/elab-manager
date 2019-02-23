package elab.business.module_function_controllers.member_module_function_controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import elab.application.BaseFunctionContentController;
import elab.database.DatabaseOperations;
import elab.serialization.beans.member.LoginMessage;
import elab.util.Utilities;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class PersonalInformationPageController extends BaseFunctionContentController {

    private LoginMessage loginMessage = new LoginMessage();

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
    private JFXComboBox<String> collegeChooseBox;
    @FXML
    private JFXComboBox<String> groupChooseBox;
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
    @FXML
    private ImageView pwdOK;
    @FXML
    private ImageView twicePwdOK;
    @FXML
    private AnchorPane container;

    private Paint unFocusColor;

    public void cleanPwd() {
        pwdInputField.setText("");
        pwdInputField.setUnFocusColor(unFocusColor);
        pwdOK.setVisible(false);
        twicePwdInputField.setText("");
        twicePwdInputField.setUnFocusColor(unFocusColor);
        twicePwdOK.setVisible(false);
    }

    public void setMessage() {
        numberInputField.setText(Integer.toString(loginMessage.getNumber()));
        userInputField.setText(loginMessage.getUserName());
        nameInputField.setText(loginMessage.getName());
        telInputField.setText(loginMessage.getTel());
        collegeChooseBox.setValue(loginMessage.getCollege());
        groupChooseBox.setValue(loginMessage.getGroup());
        if(loginMessage.getSex().equals("男"))
            sexChoose_man.setSelected(true);
        else
            sexChoose_woman.setSelected(true);
    }

    @Override
    public void initializeController() {

        unFocusColor = pwdInputField.getUnFocusColor();

        collegeChooseBox.getItems().addAll(
                "电子信息与电气工程学部",
                "化学与环境生命学部",
                "建设工程学部",
                "运载工程与力学学部",
                "机械工程与材料能源学部",
                "管理与经济学部",
                "人文与社会科学学部",
                "建筑与艺术学院",
                "外国语学院"
        );

        groupChooseBox.getItems().addAll(
                "电子组",
                "软件组"
        );

        setMessage();

        pwdInputField.focusedProperty().addListener(event -> {
            if(!pwdInputField.isFocused()) {
                if(pwdInputField.getText().equals("")) {
                    pwdInputField.setUnFocusColor(Color.RED);
                    Utilities.popMessage("密码不能为空", container);
                    pwdOK.setVisible(false);
                }
                else if(!twicePwdInputField.getText().equals("")) {
                    if(!twicePwdInputField.getText().equals(pwdInputField.getText())) {
                        twicePwdInputField.setUnFocusColor(Color.RED);
                        pwdOK.setVisible(true);
                        twicePwdOK.setVisible(false);
                        Utilities.popMessage("两次输入的密码不一致", container);
                    }
                    else {
                        pwdOK.setVisible(true);
                        twicePwdOK.setVisible(true);
                        twicePwdInputField.setUnFocusColor(unFocusColor);
                    }
                }
                else {
                    pwdOK.setVisible(true);
                }
            }
            else {
                pwdInputField.setUnFocusColor(unFocusColor);
            }
        });

        twicePwdInputField.focusedProperty().addListener(event -> {
            if(!twicePwdInputField.isFocused()) {
                if(pwdInputField.getText().equals("")) {
                    pwdInputField.setUnFocusColor(Color.RED);
                    Utilities.popMessage("密码不能为空", container);
                    pwdOK.setVisible(false);
                    twicePwdOK.setVisible(false);
                }
                else if(twicePwdInputField.getText().equals("")) {
                    twicePwdInputField.setUnFocusColor(Color.RED);
                    twicePwdOK.setVisible(false);
                    Utilities.popMessage("请再次输入密码", container);
                }
                else if(twicePwdInputField.getText().equals(pwdInputField.getText())) {
                    pwdOK.setVisible(true);
                    twicePwdOK.setVisible(true);
                }
                else {
                    twicePwdInputField.setUnFocusColor(Color.RED);
                    twicePwdOK.setVisible(false);
                    Utilities.popMessage("两次输入的密码不一致", container);
                }
            }
            else {
                twicePwdInputField.setUnFocusColor(unFocusColor);
            }
        });

        sexChoose_man.setOnAction(event -> {
            sexChoose_woman.setSelected(!sexChoose_man.isSelected());
        });

        sexChoose_woman.setOnAction(event -> {
            sexChoose_man.setSelected(!sexChoose_woman.isSelected());
        });

        logButton.setOnMouseClicked(event -> {
            if(event.getButton() == MouseButton.PRIMARY) {
                boolean allMessageCkecked = true;
                if (numberInputField.getText().equals("")) {
                    allMessageCkecked = false;
                    numberInputField.setUnFocusColor(Color.RED);
                }
                if (userInputField.getText().equals("")) {
                    allMessageCkecked = false;
                    userInputField.setUnFocusColor(Color.RED);
                }
                if (nameInputField.getText().equals("")) {
                    allMessageCkecked = false;
                    nameInputField.setUnFocusColor(Color.RED);
                }
                if (pwdInputField.getText().equals("")) {
                    allMessageCkecked = false;
                    pwdInputField.setUnFocusColor(Color.RED);
                }
                if (twicePwdInputField.getText().equals("")) {
                    allMessageCkecked = false;
                    twicePwdInputField.setUnFocusColor(Color.RED);
                }
                if (telInputField.getText().equals("")) {
                    allMessageCkecked = false;
                    telInputField.setUnFocusColor(Color.RED);
                }
                if (!allMessageCkecked) {
                    Utilities.popMessage("请查看信息填写是否完整", container);
                } else {
                    loginMessage.setNumber(Integer.parseInt(numberInputField.getText()));
                    loginMessage.setUserName(userInputField.getText());
                    loginMessage.setName(nameInputField.getText());
                    loginMessage.setTel(telInputField.getText());
                    loginMessage.setCollege(collegeChooseBox.getValue());
                    loginMessage.setGroup(groupChooseBox.getValue());
                    if(sexChoose_man.isSelected())
                        loginMessage.setSex("男");
                    else
                        loginMessage.setSex("女");
                    loginMessage.setPassword(Utilities.encrypt(pwdInputField.getText()));
                    DatabaseOperations.getInstance().updateMember(loginMessage);
                    loginMessage.setOldNumber(loginMessage.getNumber());
                    Utilities.popMessage("修改信息成功!", container);
                    cleanPwd();
                }
            }
        });

        returnButton.setOnMouseClicked(event -> {
            if(event.getButton() == MouseButton.PRIMARY) {
                setMessage();
                numberInputField.setUnFocusColor(unFocusColor);
                userInputField.setUnFocusColor(unFocusColor);
                nameInputField.setUnFocusColor(unFocusColor);
                pwdInputField.setUnFocusColor(unFocusColor);
                pwdOK.setVisible(false);
                twicePwdInputField.setUnFocusColor(unFocusColor);
                twicePwdOK.setVisible(false);
                telInputField.setUnFocusColor(unFocusColor);
            }
        });

        PwdReturnButton.setOnMouseClicked(event -> {
            if(event.getButton() == MouseButton.PRIMARY)
                cleanPwd();
        });
    }
}
