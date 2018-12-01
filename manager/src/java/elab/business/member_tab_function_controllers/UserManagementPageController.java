package elab.business.member_tab_function_controllers;

import com.jfoenix.controls.*;
import elab.application.BaseViewController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Side;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

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

    @Override
    public void initializeController() {

        try {

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

            Tab searchResult = new Tab("搜索结果");
            FXMLLoader searchResultLoader = new FXMLLoader(getClass().getResource("/member_tab_page_fxml_files/search_result_page.fxml"));
            Parent searchResultRoot = searchResultLoader.load();
            searchResult.setContent(searchResultRoot);
            tabPane.getTabs().add(searchResult);

        } catch (Exception exp) {
            System.out.println(exp.toString());
        }
    }
}
