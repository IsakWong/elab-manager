package elab.business.member_tab_page_controllers;

import elab.application.BaseViewController;
import elab.serialization.member.Member;
import elab.serialization.student.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class SearchResultPageController extends BaseViewController {

    @FXML
    private TableView<Member> memberTableView;
    @FXML
    private TableColumn<Member, String> numberM;
    @FXML
    private TableColumn<Member, String> userName;
    @FXML
    private TableColumn<Member, String> nameM;
    @FXML
    private TableColumn<Member, String> sex;
    @FXML
    private TableColumn<Member, Integer> teachingAmount;
    @FXML
    private TableColumn<Member, Integer> assistAmount;
    @FXML
    private TableColumn<Member, String> collegeM;
    @FXML
    private TableColumn<Member, String> grade;
    @FXML
    private TableColumn<Member, String> telM;
    @FXML
    private TableColumn<Member, String> duty;
    @FXML
    private TableColumn<Member, String> group;

    @FXML
    private TableView<Student> studentTableView;
    @FXML
    private TableColumn<Student, String> number;
    @FXML
    private TableColumn<Student, String> name;
    @FXML
    private TableColumn<Student, String> college;
    @FXML
    private TableColumn<Student, Integer> hardTime;
    @FXML
    private TableColumn<Student, Integer> softTime;
    @FXML
    private TableColumn<Student, Integer> hardScore;
    @FXML
    private TableColumn<Student, Integer> softScore;
    @FXML
    private TableColumn<Student, Integer> paperScore;
    @FXML
    private TableColumn<Student, String> tel;

    private ObservableList<Member> memberResult = FXCollections.<Member>observableArrayList();
    private ObservableList<Student> studentResult = FXCollections.<Student>observableArrayList();

    public void showMemberResult(List member) {
        if(memberResult != null) memberResult.remove(0, memberResult.size());
        memberResult.addAll(member);
        memberTableView.setItems(memberResult);
        studentTableView.setVisible(false);
        memberTableView.setVisible(true);
    }

    public void showMemberResult() {
        memberResult.remove(0, memberResult.size());
        memberTableView.setItems(memberResult);
        studentTableView.setVisible(false);
        memberTableView.setVisible(true);
    }

    public void showStudentResult(List student) {
        if(studentResult != null) studentResult.remove(0, studentResult.size());
        studentResult.addAll(student);
        studentTableView.setItems(studentResult);
        memberTableView.setVisible(false);
        studentTableView.setVisible(true);
    }

    public void showStudentResult() {
        studentResult.remove(0, studentResult.size());
        studentTableView.setItems(studentResult);
        memberTableView.setVisible(false);
        studentTableView.setVisible(true);
    }

    @Override
    public void initializeController() {
        numberM.setCellValueFactory(new PropertyValueFactory<Member, String>("number"));
        userName.setCellValueFactory(new PropertyValueFactory<Member, String>("userName"));
        nameM.setCellValueFactory(new PropertyValueFactory<Member, String>("name"));
        sex.setCellValueFactory(new PropertyValueFactory<Member, String>("sex"));
        teachingAmount.setCellValueFactory(new PropertyValueFactory<Member, Integer>("teachingAmount"));
        assistAmount.setCellValueFactory(new PropertyValueFactory<Member, Integer>("assistAmount"));
        collegeM.setCellValueFactory(new PropertyValueFactory<Member, String>("college"));
        grade.setCellValueFactory(new PropertyValueFactory<Member, String>("grade"));
        telM.setCellValueFactory(new PropertyValueFactory<Member, String>("tel"));
        duty.setCellValueFactory(new PropertyValueFactory<Member, String>("duty"));
        group.setCellValueFactory(new PropertyValueFactory<Member, String>("group"));

        number.setCellValueFactory(new PropertyValueFactory<Student, String>("number"));
        name.setCellValueFactory(new PropertyValueFactory<Student, String>("name"));
        college.setCellValueFactory(new PropertyValueFactory<Student, String>("college"));
        hardTime.setCellValueFactory(new PropertyValueFactory<Student, Integer>("hardTime"));
        softTime.setCellValueFactory(new PropertyValueFactory<Student, Integer>("softTime"));
        hardScore.setCellValueFactory(new PropertyValueFactory<Student, Integer>("hardScore"));
        softScore.setCellValueFactory(new PropertyValueFactory<Student, Integer>("softScore"));
        paperScore.setCellValueFactory(new PropertyValueFactory<Student, Integer>("paperScore"));
        tel.setCellValueFactory(new PropertyValueFactory<Student, String>("tel"));

        memberTableView.setPlaceholder(new Label("未搜索到成员信息"));
        studentTableView.setPlaceholder(new Label("未搜索到学生信息"));
    }
}
