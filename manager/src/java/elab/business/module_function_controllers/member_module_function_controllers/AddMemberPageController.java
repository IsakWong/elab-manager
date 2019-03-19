package elab.business.module_function_controllers.member_module_function_controllers;

import com.jfoenix.controls.*;
import elab.application.BaseFunctionContentController;
import elab.database.DatabaseOperations;
import elab.serialization.beans.member.Member;
import elab.util.Utilities;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class AddMemberPageController extends BaseFunctionContentController {

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
    private RadioButton sexChoose_man;
    @FXML
    private RadioButton sexChoose_woman;
    @FXML
    private ImageView pwdOK;
    @FXML
    private ImageView twicePwdOK;
    @FXML
    private VBox container;

    private Paint unFocusColor;

    public void cleanMessage() {
        numberInputField.setText("");
        userInputField.setText("");
        nameInputField.setText("");
        sexChoose_man.setSelected(true);
        sexChoose_woman.setSelected(false);
        pwdInputField.setText("");
        pwdOK.setVisible(false);
        twicePwdInputField.setText("");
        twicePwdOK.setVisible(false);
        collegeChooseBox.setValue("电子信息与电气工程学部");
        groupChooseBox.setValue("电子组");
        telInputField.setText("");
    }

    @Override
    public void initializeController() {

        unFocusColor = pwdInputField.getUnFocusColor();

        sexChoose_man.setOnAction(event -> {
            sexChoose_woman.setSelected(!sexChoose_man.isSelected());
        });
        sexChoose_man.setSelected(true);

        sexChoose_woman.setOnAction(event -> {
            sexChoose_man.setSelected(!sexChoose_woman.isSelected());
        });

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
        collegeChooseBox.setValue("电子信息与电气工程学部");

        groupChooseBox.getItems().addAll(
                "电子组",
                "软件组"
        );
        groupChooseBox.setValue("电子组");

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

        returnButton.setOnMouseClicked(event -> {
            if(event.getButton() == MouseButton.PRIMARY) {
                cleanMessage();
                numberInputField.setUnFocusColor(unFocusColor);
                userInputField.setUnFocusColor(unFocusColor);
                nameInputField.setUnFocusColor(unFocusColor);
                pwdInputField.setUnFocusColor(unFocusColor);
                twicePwdInputField.setUnFocusColor(unFocusColor);
                telInputField.setUnFocusColor(unFocusColor);
            }
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
                    Member newMember = new Member();
                    newMember.setNumber(numberInputField.getText());
                    newMember.setUserName(userInputField.getText());
                    newMember.setName(nameInputField.getText());
                    if(sexChoose_man.isSelected())
                        newMember.setSex("男");
                    else
                        newMember.setSex("女");
                    newMember.setPassword(Utilities.encrypt(pwdInputField.getText()));
                    newMember.setCollege(collegeChooseBox.getValue());
                    newMember.setGroup(groupChooseBox.getValue());
                    newMember.setTel(telInputField.getText());
                    DatabaseOperations.getInstance().insertMember(newMember);
                    Utilities.popMessage("新增成员成功!", container);
                    cleanMessage();
                }
            }
        });

        numberInputField.setOnMousePressed(event -> {
            if(event.getButton() == MouseButton.PRIMARY) {
                numberInputField.setUnFocusColor(unFocusColor);
            }
        });

        userInputField.setOnMousePressed(event -> {
            if(event.getButton() == MouseButton.PRIMARY) {
                userInputField.setUnFocusColor(unFocusColor);
            }
        });

        nameInputField.setOnMousePressed(event -> {
            if(event.getButton() == MouseButton.PRIMARY) {
                nameInputField.setUnFocusColor(unFocusColor);
            }
        });

        telInputField.setOnMousePressed(event -> {
            if(event.getButton() == MouseButton.PRIMARY) {
                telInputField.setUnFocusColor(unFocusColor);
            }
        });
        IsDataInitialized = true;
    }
}