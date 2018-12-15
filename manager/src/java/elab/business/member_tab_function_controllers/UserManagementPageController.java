package elab.business.member_tab_function_controllers;

import com.jfoenix.controls.*;
import elab.application.BaseViewController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.input.MouseButton;

public class UserManagementPageController extends BaseViewController {

    @FXML
    private JFXTextField name;
    @FXML
    private JFXTextField number;
    @FXML
    private JFXComboBox college;
    @FXML
    private JFXRadioButton member;
    @FXML
    private JFXRadioButton student;
    @FXML
    private JFXButton searchBtn;
    @FXML
    private JFXTabPane tabPane;

    Label label = new Label("电子信息与电气工程学部");

    Tab searchResult = new Tab("搜索结果");

    @Override
    public void initializeController() {

        try {

            member.setOnAction(event -> {
                student.setSelected(!member.isSelected());
            });
            member.setSelected(true);

            student.setOnAction(event -> {
                member.setSelected(!student.isSelected());
            });

            college.getItems().addAll(
                    label,
                    new Label("化学与环境生命学部"),
                    new Label("建设工程学部"),
                    new Label("运载工程与力学学部"),
                    new Label("机械工程与材料能源学部"),
                    new Label("管理与经济学部"),
                    new Label("人文与社会科学学部"),
                    new Label("建筑与艺术学院"),
                    new Label("外国语学院"),
                    new Label("物理学院"),
                    new Label("数学科学学院")
            );
            college.setValue(label);

            Tab memberTab = new Tab("科中成员");
            FXMLLoader memberInformationLoader = new FXMLLoader(getClass().getResource("/member_tab_page_fxml_files/member_information_page.fxml"));
            Parent memberInformationRoot = memberInformationLoader.load();
            memberTab.setContent(memberInformationRoot);
            tabPane.getTabs().add(memberTab);

            Tab studentTab = new Tab("上课同学");
            FXMLLoader studentInformationLoader = new FXMLLoader(getClass().getResource("/member_tab_page_fxml_files/student_information_page.fxml"));
            Parent studentInformationRoot = studentInformationLoader.load();
            studentTab.setContent(studentInformationRoot);
            tabPane.getTabs().add(studentTab);

            FXMLLoader searchResultLoader = new FXMLLoader(getClass().getResource("/member_tab_page_fxml_files/search_result_page.fxml"));
            Parent searchResultRoot = searchResultLoader.load();
            searchResult.setContent(searchResultRoot);
            tabPane.getTabs().add(searchResult);

            searchBtn.setOnMouseClicked(event -> {
                if(event.getButton() == MouseButton.PRIMARY) {
                    tabPane.getSelectionModel().select(searchResult);
                    name.setText("");
                    number.setText("");
                }
            });

        } catch (Exception exp) {
            System.out.println(exp.toString());
        }
    }
}
