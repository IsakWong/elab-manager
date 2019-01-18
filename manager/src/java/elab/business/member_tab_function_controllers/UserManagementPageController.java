package elab.business.member_tab_function_controllers;

import com.jfoenix.controls.*;
import elab.application.BaseViewController;
import elab.business.member_tab_page_controllers.MemberInformationPageController;
import elab.business.member_tab_page_controllers.SearchResultPageController;
import elab.business.member_tab_page_controllers.StudentInformationPageController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
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
                    "电子信息与电气工程学部",
                    "化学与环境生命学部",
                    "建设工程学部",
                    "运载工程与力学学部",
                    "机械工程与材料能源学部",
                    "管理与经济学部",
                    "人文与社会科学学部",
                    "建筑与艺术学院",
                    "外国语学院",
                    "物理学院",
                    "数学科学学院"
            );

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

            MemberInformationPageController memberInformationPageController = memberInformationLoader.getController();
            memberInformationPageController.initializeController();

            StudentInformationPageController studentInformationPageController = studentInformationLoader.getController();
            studentInformationPageController.initializeController();

            //SearchResultPageController searchResultPageController = searchResultLoader.getController();
            //searchResultPageController.initializeController();

        } catch (Exception exp) {
            System.out.println(exp.toString());
        }
    }
}
