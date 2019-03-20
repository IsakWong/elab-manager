package elab.business.module_function_controllers.member_module_function_controllers.user_management_page_controllers;

import elab.application.BaseFunctionContentController;
import elab.application.BaseViewController;
import elab.database.DatabaseOperations;
import elab.database.Session;
import elab.serialization.beans.member.Member;
import elab.serialization.beans.student.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class MemberInformationPageController extends BaseFunctionContentController {

    @FXML
    private TableView<Member> tableView;
    @FXML
    private TableColumn<Member, String> number;
    @FXML
    private TableColumn<Member, String> userName;
    @FXML
    private TableColumn<Member, String> name;
    @FXML
    private TableColumn<Member, String> sex;
    @FXML
    private TableColumn<Member, Integer> teachingAmount;
    @FXML
    private TableColumn<Member, Integer> assistAmount;
    @FXML
    private TableColumn<Member, String> college;
    @FXML
    private TableColumn<Member, String> grade;
    @FXML
    private TableColumn<Member, String> tel;
    @FXML
    private TableColumn<Member, String> duty;
    @FXML
    private TableColumn<Member, String> group;

    private Boolean isInit = false;

    Session<List> queryMemberSession = new Session<List>() {
        @Override
        public void onPostFetchResult(SessionResult<List> sessionResult) {
            sessionResult.result = DatabaseOperations.getInstance().selectAllMembers();
            if(sessionResult.result == null)
                sessionResult.errorMessage="无法获取成员信息";
        }

        @Override
        public void onSuccess(List param) {
            ObservableList<Member> members = FXCollections.observableArrayList();
            members.addAll(param);
            tableView.setItems(members);
            isInit = true;
        }

        @Override
        public void onError(String errorMessage) {
            popupMessage(errorMessage,3000);
        }

        @Override
        public void onBusy() {
            popupMessage("正在获取信息中",3000);
        }
    };

    @Override
    public void initializeController() {
        queryMemberSession.send();
        number.setCellValueFactory(new PropertyValueFactory<Member, String>("number"));
        userName.setCellValueFactory(new PropertyValueFactory<Member, String>("userName"));
        name.setCellValueFactory(new PropertyValueFactory<Member, String>("name"));
        sex.setCellValueFactory(new PropertyValueFactory<Member, String>("sex"));
        teachingAmount.setCellValueFactory(new PropertyValueFactory<Member, Integer>("teachingAmount"));
        assistAmount.setCellValueFactory(new PropertyValueFactory<Member, Integer>("assistAmount"));
        college.setCellValueFactory(new PropertyValueFactory<Member, String>("college"));
        grade.setCellValueFactory(new PropertyValueFactory<Member, String>("grade"));
        tel.setCellValueFactory(new PropertyValueFactory<Member, String>("tel"));
        duty.setCellValueFactory(new PropertyValueFactory<Member, String>("duty"));
        group.setCellValueFactory(new PropertyValueFactory<Member, String>("group"));
    }

    public Boolean isInit() {
        return isInit;
    }
}
