package elab.business.member_tab_function_controllers;

import com.jfoenix.controls.*;
import elab.application.BaseViewController;
import elab.business.member_tab_page_controllers.MemberInformationPageController;
import elab.business.member_tab_page_controllers.SearchResultPageController;
import elab.business.member_tab_page_controllers.StudentInformationPageController;
import elab.database.DatabaseOperations;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Tab;
import javafx.scene.input.MouseButton;

import java.util.List;

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
    private JFXButton returnBtn;
    @FXML
    private JFXTabPane tabPane;

    private Tab searchResult = new Tab("搜索结果");
    private SearchResultPageController searchResultPageController;

    private List filterListElement(List list, String filteringString, int equalInformationIndex) {
        for(int i = 0; i < list.size(); ++i) {
            String[] properties = list.get(i).toString().split(" ");
            if(!properties[equalInformationIndex].equals(filteringString)) {
                list.remove(i);
                --i;
            }
        }
        return list;
    }

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
            college.setValue("");

            Tab memberTab = new Tab("科中成员");
            FXMLLoader memberInformationLoader = new FXMLLoader(getClass().getResource("/member_tab_page_fxml_files/member_information_page.fxml"));
            Parent memberInformationRoot = memberInformationLoader.load();
            MemberInformationPageController memberInformationPageController = memberInformationLoader.getController();
            //memberInformationPageController.initializeController();
            memberTab.setContent(memberInformationRoot);
            tabPane.getTabs().add(memberTab);

            Tab studentTab = new Tab("上课同学");
            FXMLLoader studentInformationLoader = new FXMLLoader(getClass().getResource("/member_tab_page_fxml_files/student_information_page.fxml"));
            Parent studentInformationRoot = studentInformationLoader.load();
            StudentInformationPageController studentInformationPageController = studentInformationLoader.getController();
            //studentInformationPageController.initializeController();
            studentTab.setContent(studentInformationRoot);
            tabPane.getTabs().add(studentTab);

            FXMLLoader searchResultLoader = new FXMLLoader(getClass().getResource("/member_tab_page_fxml_files/search_result_page.fxml"));
            Parent searchResultRoot = searchResultLoader.load();
            searchResultPageController = searchResultLoader.getController();
            searchResultPageController.initializeController();
            searchResult.setContent(searchResultRoot);
            tabPane.getTabs().add(searchResult);

            /**
             * 搜索按钮点击后，检查三个信息栏的信息填写情况并找到符合的信息
             */

            searchBtn.setOnMouseClicked(event -> {
                if(event.getButton() == MouseButton.PRIMARY) {
                    if(!name.getText().equals("")) {
                        if(member.isSelected()) {
                            List result = DatabaseOperations.getInstance().selectMemberByName(name.getText());
                            if(!number.getText().equals("")) {
                                result = filterListElement(result, number.getText(), 0);
                                if(!college.getValue().equals("")) {
                                    result = filterListElement(result, college.getValue().toString(), 4);
                                    searchResultPageController.showMemberResult(result);
                                }
                                else searchResultPageController.showMemberResult(result);
                            }
                            else if(!college.getValue().equals("")) {
                                result = filterListElement(result, college.getValue().toString(), 4);
                                searchResultPageController.showMemberResult(result);
                            }
                            else searchResultPageController.showMemberResult(result);
                        }
                        else {
                            List result = DatabaseOperations.getInstance().selectStudentByName(name.getText());
                            if(!number.getText().equals("")) {
                                result = filterListElement(result, number.getText(), 0);
                                if(!college.getValue().equals("")) {
                                    result = filterListElement(result, college.getValue().toString(), 2);
                                    searchResultPageController.showStudentResult(result);
                                }
                                else searchResultPageController.showStudentResult(result);
                            }
                            else if(!college.getValue().equals("")) {
                                result = filterListElement(result, college.getValue().toString(), 2);
                                searchResultPageController.showStudentResult(result);
                            }
                            else searchResultPageController.showStudentResult(result);
                        }
                    }
                    else if(!number.getText().equals("")) {
                        if(member.isSelected()) {
                            List result = DatabaseOperations.getInstance().selectMemberByNumber(number.getText());
                            if(!college.getValue().equals("")) {
                                result = filterListElement(result, college.getValue().toString(), 4);
                                searchResultPageController.showMemberResult(result);
                            }
                            else searchResultPageController.showMemberResult(result);
                        }
                        else {
                            List result = DatabaseOperations.getInstance().selectStudentByNumber(number.getText());
                            if(!college.getValue().equals("")) {
                                result = filterListElement(result, college.getValue().toString(), 2);
                                searchResultPageController.showStudentResult(result);
                            }
                            else searchResultPageController.showStudentResult(result);
                        }
                    }
                    else if(!college.getValue().equals("")) {
                        if(member.isSelected()) searchResultPageController.showMemberResult(DatabaseOperations.getInstance().selectMemberByCollege(college.getValue().toString()));
                        else searchResultPageController.showStudentResult(DatabaseOperations.getInstance().selectStudentByCollege(college.getValue().toString()));
                    }
                    else {
                        if(member.isSelected()) searchResultPageController.showMemberResult();
                        else searchResultPageController.showStudentResult();
                    }
                    tabPane.getSelectionModel().select(searchResult);
                }
            });

            returnBtn.setOnMouseClicked(event -> {
                if(event.getButton() == MouseButton.PRIMARY) {
                    name.setText("");
                    number.setText("");
                    college.setValue("");
                }
            });

        } catch (Exception exp) {
            System.out.println(exp.toString());
        }
    }
}
