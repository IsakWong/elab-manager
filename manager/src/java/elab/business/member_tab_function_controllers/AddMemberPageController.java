package elab.business.member_tab_function_controllers;

import com.jfoenix.controls.*;
import elab.application.BaseViewController;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import org.apache.logging.log4j.core.pattern.AbstractStyleNameConverter;

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
    @FXML
    private ImageView pwdOK;
    @FXML
    private ImageView twicePwdOK;
    @FXML
    private AnchorPane container;

    Border redBorder = new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT));

    Label label = new Label("电子信息与电气工程学部");
    Label elabel = new Label("电子组");

    public void popMessage(String message) {
        JFXSnackbar bar = new JFXSnackbar(container);
        JFXSnackbar.SnackbarEvent event = new JFXSnackbar.SnackbarEvent(message);
        bar.enqueue(event);
    }

    @Override
    public void initializeController() {

        sexChoose_man.setOnAction(event -> {
            sexChoose_woman.setSelected(!sexChoose_man.isSelected());
        });
        sexChoose_man.setSelected(true);

        sexChoose_woman.setOnAction(event -> {
            sexChoose_man.setSelected(!sexChoose_woman.isSelected());
        });

        collegeChooseBox.getItems().addAll(
                label,
                new Label("化学与环境生命学部"),
                new Label("建设工程学部"),
                new Label("运载工程与力学学部"),
                new Label("机械工程与材料能源学部"),
                new Label("管理与经济学部"),
                new Label("人文与社会科学学部"),
                new Label("建筑与艺术学院"),
                new Label("外国语学院")
        );
        collegeChooseBox.setValue(label);

        groupChooseBox.getItems().addAll(
                elabel,
                new Label("软件组")
        );
        groupChooseBox.setValue(elabel);

        pwdInputField.focusedProperty().addListener(event -> {
            if(!pwdInputField.isFocused()) {
                if(pwdInputField.getText().equals("")) {
                    pwdInputField.setBorder(redBorder);
                    popMessage("密码不能为空");
                    pwdOK.setVisible(false);
                }
                else if(!twicePwdInputField.getText().equals("")) {
                    if(!twicePwdInputField.getText().equals(pwdInputField.getText())) {
                        twicePwdInputField.setBorder(redBorder);
                        pwdOK.setVisible(true);
                        twicePwdOK.setVisible(false);
                        popMessage("两次输入的密码不一致");
                    }
                    else {
                        pwdOK.setVisible(true);
                        twicePwdOK.setVisible(true);
                        twicePwdInputField.setBorder(null);
                    }
                }
                else {
                    pwdOK.setVisible(true);
                }
            }
            else {
                pwdInputField.setBorder(null);
            }
        });

        twicePwdInputField.focusedProperty().addListener(event -> {
            if(!twicePwdInputField.isFocused()) {
                if(pwdInputField.getText().equals("")) {
                    pwdInputField.setBorder(redBorder);
                    popMessage("密码不能为空");
                    pwdOK.setVisible(false);
                    twicePwdOK.setVisible(false);
                }
                else if(twicePwdInputField.getText().equals("")) {
                    twicePwdInputField.setBorder(redBorder);
                    twicePwdOK.setVisible(false);
                    popMessage("请再次输入密码");
                }
                else if(twicePwdInputField.getText().equals(pwdInputField.getText())) {
                    pwdOK.setVisible(true);
                    twicePwdOK.setVisible(true);
                }
                else {
                    twicePwdInputField.setBorder(redBorder);
                    twicePwdOK.setVisible(false);
                    popMessage("两次输入的密码不一致");
                }
            }
            else {
                twicePwdInputField.setBorder(null);
            }
        });

        returnButton.setOnMousePressed(event -> {
            numberInputField.setText("");
            numberInputField.setBorder(null);
            userInputField.setText("");
            userInputField.setBorder(null);
            nameInputField.setText("");
            nameInputField.setBorder(null);
            sexChoose_man.setSelected(true);
            sexChoose_woman.setSelected(false);
            pwdInputField.setText("");
            pwdInputField.setBorder(null);
            pwdOK.setVisible(false);
            twicePwdInputField.setText("");
            twicePwdInputField.setBorder(null);
            twicePwdOK.setVisible(false);
            collegeChooseBox.setValue(label);
            groupChooseBox.setValue(elabel);
            telInputField.setText("");
            telInputField.setBorder(null);
        });

        logButton.setOnMousePressed(event -> {
            boolean allMessageCkecked = true;
            if (numberInputField.getText().equals("")) {
                allMessageCkecked = false;
                numberInputField.setBorder(redBorder);
            }
            if (userInputField.getText().equals("")) {
                allMessageCkecked = false;
                userInputField.setBorder(redBorder);
            }
            if (nameInputField.getText().equals("")) {
                allMessageCkecked = false;
                nameInputField.setBorder(redBorder);
            }
            if (pwdInputField.getText().equals("")) {
                allMessageCkecked = false;
                pwdInputField.setBorder(redBorder);
            }
            if (twicePwdInputField.getText().equals("")) {
                allMessageCkecked = false;
                twicePwdInputField.setBorder(redBorder);
            }
            if (telInputField.getText().equals("")) {
                allMessageCkecked = false;
                telInputField.setBorder(redBorder);
            }
            if(!allMessageCkecked) {
                popMessage("请查看信息填写是否完整");
            }
            else {
                System.out.println("Successfully add a new member!");
            }

            numberInputField.setOnMousePressed(event1 -> {
                numberInputField.setBorder(null);
            });

            userInputField.setOnMousePressed(event1 -> {
                userInputField.setBorder(null);
            });

            nameInputField.setOnMousePressed(event1 -> {
                nameInputField.setBorder(null);
            });

            telInputField.setOnMousePressed(event1 -> {
                telInputField.setBorder(null);
            });
        });
    }
}