package elab.business.module_function_controllers.member_module_function_controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.sun.deploy.Environment;
import elab.application.BaseFunctionContentController;
import elab.database.DatabaseOperations;
import elab.serialization.beans.member.LoginMessage;
import elab.util.Utilities;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.*;

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
    private AnchorPane photoPane;
    @FXML
    private ImageView pwdOK;
    @FXML
    private ImageView twicePwdOK;
    @FXML
    private ImageView photoView;
    @FXML
    private HBox container;

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
        try {
            if(loginMessage.getPhoto() != null) {
                File photo = new File("src/resources/pictures/photo." + loginMessage.getPhotoFormat());
                FileOutputStream fos = new FileOutputStream(photo);
                fos.write(loginMessage.getPhoto());
                fos.flush();
                fos.close();
                if (photo != null) {
                    Image newPhoto = new Image(photo.toURI().toString());
                    photoView.setImage(newPhoto);
                } else {
                    Utilities.popMessage("照片加载失败", container);
                }
            }
            numberInputField.setText(Integer.toString(loginMessage.getNumber()));
            userInputField.setText(loginMessage.getUserName());
            nameInputField.setText(loginMessage.getName());
            telInputField.setText(loginMessage.getTel());
            collegeChooseBox.setValue(loginMessage.getCollege());
            groupChooseBox.setValue(loginMessage.getGroup());
            if (loginMessage.getSex().equals("男"))
                sexChoose_man.setSelected(true);
            else
                sexChoose_woman.setSelected(true);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void loadPhoto() {
        try {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("选择照片");
            fileChooser.setInitialDirectory(
                    new File(System.getProperty("user.home"))
            );
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                    new FileChooser.ExtensionFilter("PNG", "*.png"),
                    new FileChooser.ExtensionFilter("BMP", "*.bmp")
            );
            Stage stage = (Stage) container.getScene().getWindow();
            File file = fileChooser.showOpenDialog(stage);
            if (file != null) {
                byte[] photoData = new byte[(int) file.length()];
                FileInputStream fis = new FileInputStream(file);
                fis.read(photoData);
                fis.close();
                loginMessage.setPhoto(photoData);
                String[] photoName = file.getName().split("\\.");
                loginMessage.setPhotoFormat(photoName[1]);
                Image photo = new Image(file.toURI().toString());
                photoView.setImage(photo);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
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
                if (photoView.getImage() == null) {
                    allMessageCkecked = false;
                    photoPane.setStyle("-fx-border-color: #ff0000");
                }
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
                photoView.setImage(null);
            }
        });

        PwdReturnButton.setOnMouseClicked(event -> {
            if(event.getButton() == MouseButton.PRIMARY)
                cleanPwd();
        });

        photoView.setOnMouseClicked(event -> {
            if(event.getButton() == MouseButton.PRIMARY) {
                photoPane.setStyle("-fx-border-color: #000000");
                if(photoView.getImage() == null) {
                    loadPhoto();
                } else {
                    Object[] options = {"确定", "取消"};
                    int m = JOptionPane.showOptionDialog(null, "新照片将覆盖已有照片，是否继续？", "Attention",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                    if(m == 0) {
                        loadPhoto();
                    }
                }
            }
        });

        IsDataInitialized = true;
    }
}
