package elab.business.module_function_controllers.person_space_controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.sun.org.apache.xpath.internal.operations.Bool;
import elab.application.BaseFunctionContentController;
import elab.application.ElabManagerApplication;
import elab.database.DatabaseOperations;
import elab.database.Session;
import elab.serialization.beans.free_time.FreeTime;
import elab.serialization.beans.member.LoginMessage;
import elab.serialization.beans.member.Member;
import elab.util.Utilities;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Separator;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class FreeTimeCollectPageController extends BaseFunctionContentController {

    @FXML
    private HBox pageContainer;
    @FXML
    private VBox container;
    @FXML
    private JFXButton save;
    @FXML
    private TextArea questionBoard;

    private ListView finishedListView;
    private ListView unfinishedListView;

    private Boolean isInfoExist = false;

    String[] DayString = {" ","周一","周二","周三","周四","周五","周六","周日"};
    String[] WeekString = {"所有周","第一周","第二周","第三周","第四周","第五周","第六周","第七周","第八周","第九周","第十周","第十一周","第十二周","第十三周","第十四周"};

    JFXCheckBox[][][] checkBoxes;

    Session<List> getAllMemberSession = new Session<List>() {
        @Override
        public void onPostFetchResult(SessionResult<List> sessionResult) {
            sessionResult.result = DatabaseOperations.getInstance().selectInSchoolMembers();
            if(sessionResult.result == null)
                sessionResult.errorMessage = "获取所有在校成员失败";
        }

        @Override
        public void onSuccess(List param) {
            ObservableList<Member> members = FXCollections.observableArrayList();
            members.addAll(param);
            ObservableList<String> finishedList = finishedListView.getItems();
            for(int i = 0; i < finishedList.size(); ++i) {
                String[] information = finishedList.get(i).split(" ");
                for(int j = 0; j < members.size(); ++j)
                    if(members.get(j).getNumber().equals(information[0]))
                        members.remove(j);
            }
            ObservableList<String> unfinishedList = FXCollections.observableArrayList();
            for(int i = 0; i < members.size(); ++i)
                unfinishedList.add(members.get(i).getNumber() + " " + members.get(i).getName());
            unfinishedListView.setItems(unfinishedList);
        }

        @Override
        public void onError(String errorMessage) {
            popupMessage(errorMessage, 1500);
        }

        @Override
        public void onBusy() {

        }
    };

    Session<List> getAllFreeTimeSession = new Session<List>() {
        @Override
        public void onPostFetchResult(SessionResult<List> sessionResult) {
            sessionResult.result = DatabaseOperations.getInstance().selectAllFreeTime(Utilities.getTerm());
            if(sessionResult.result == null)
                sessionResult.errorMessage = "";
        }

        @Override
        public void onSuccess(List param) {
            ObservableList<FreeTime> allFreeTime = FXCollections.observableArrayList();
            allFreeTime.addAll(param);
            ObservableList<String> finishedList = FXCollections.observableArrayList();
            for(int i = 0; i < allFreeTime.size(); ++i)
                finishedList.add(allFreeTime.get(i).getNumber() + " " + allFreeTime.get(i).getName());
            finishedListView.setItems(finishedList);
            getAllMemberSession.send();
        }

        @Override
        public void onError(String errorMessage) {
            getAllMemberSession.send();
        }

        @Override
        public void onBusy() {

        }
    };

    Session<Boolean> addFreeTimeSession = new Session<Boolean>() {
        @Override
        public void onPostFetchResult(SessionResult<Boolean> sessionResult) {
            LoginMessage loginMessage = ElabManagerApplication.currentCertification;
            FreeTime freeTime = new FreeTime();
            freeTime.setNumber(loginMessage.getNumber());
            freeTime.setName(loginMessage.getName());
            freeTime.setTerm(Utilities.getTerm());
            freeTime.setModificationDate(Utilities.getSystemDate("yyyy-MM-dd HH:mm:ss"));
            sessionResult.result = DatabaseOperations.getInstance().insertFreeTime(freeTime);
        }

        @Override
        public void onSuccess(Boolean param) {
            updateFreeTimeSession.send();
        }

        @Override
        public void onError(String errorMessage) {
        }

        @Override
        public void onBusy() {

        }
    };

    Session<FreeTime> getFreeTimeSession = new Session<FreeTime>() {
        @Override
        public void onPostFetchResult(SessionResult<FreeTime> sessionResult) {
            FreeTime freeTime = new FreeTime();
            freeTime.setNumber(ElabManagerApplication.currentCertification.getNumber());
            freeTime.setTerm(Utilities.getTerm());
            sessionResult.result = DatabaseOperations.getInstance().selectFreeTime(freeTime);
            if(sessionResult.result == null)
                sessionResult.errorMessage = "";    //如果不将errorMessage初始化是不会调用onError方法的
        }

        @Override
        public void onSuccess(FreeTime param) {
            checkBoxes = new JFXCheckBox[17][8][3];
            initControls();
            initCheckBoxSelected(param.getFreeTime());
            questionBoard.setText(param.getRemarks());
            isInfoExist = true;
            finishLoading();
        }

        @Override
        public void onError(String errorMessage) {
            checkBoxes = new JFXCheckBox[17][8][3];
            initControls();
            finishLoading();
        }

        @Override
        public void onBusy() {

        }
    };

    Session<Boolean> updateFreeTimeSession = new Session<Boolean>() {
        @Override
        public void onPostFetchResult(SessionResult<Boolean> sessionResult) {
            save.setDisable(true);
            FreeTime freeTime = new FreeTime();
            freeTime.setNumber(ElabManagerApplication.currentCertification.getNumber());
            String freeTimeString = "";
            for (int i = 0; i < WeekString.length; ++i) {
                for (int j = 0; j < 8; ++j) {
                    for (int k = 0; k < 3; ++k) {
                        if(checkBoxes[i][j][k].isSelected())
                            freeTimeString += ",true";
                        else
                            freeTimeString += ",false";
                    }
                }
            }
            freeTime.setFreeTime(freeTimeString);
            freeTime.setRemarks(questionBoard.getText());
            freeTime.setTerm(Utilities.getTerm());
            freeTime.setModificationDate(Utilities.getSystemDate("yyyy-MM-dd HH:mm:ss"));
            sessionResult.result = DatabaseOperations.getInstance().updateFreeTime(freeTime);
            if(sessionResult.result == null)
                sessionResult.errorMessage = "保存信息失败";
        }

        @Override
        public void onSuccess(Boolean param) {
            save.setDisable(false);
            popupMessage("保存信息成功", 1500);
        }

        @Override
        public void onError(String errorMessage) {
            popupMessage(errorMessage, 1500);
        }

        @Override
        public void onBusy() {
            popupMessage("正在保存信息", 1500);
        }
    };

    private void addAdminControls() {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/business_pages/module_function_pages/person_space_pages/free_time_pages/view_free_time_list.fxml"));
            Node node = loader.load();
            VBox vBox = (VBox) node.lookup("#listViewContainer");
            finishedListView = (ListView) node.lookup("#finishedListView");
            unfinishedListView = (ListView) node.lookup("#unfinishedListView");
            pageContainer.getChildren().add(vBox);
            getAllFreeTimeSession.send();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initCheckBoxSelected(String freeTimeString) {
        String[] selectedInformation = freeTimeString.split(",");
        int number = 1;
        for (int i = 0; i < WeekString.length; ++i) {
            for (int j = 0; j < 8; ++j) {
                for (int k = 0; k < 3; ++k) {
                    if(selectedInformation[number].equals("true"))
                        checkBoxes[i][j][k].setSelected(true);
                    ++number;
                }
            }
        }
    }

    private void loadDayCheckBoxGroup(HBox WeekRow,int WeekIndex, int DayIndex) {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/business_pages/module_function_pages/person_space_pages/free_time_pages/free_time_checkbox.fxml"));
            Node checkboxGroup = loader.load();
            Label day = (Label) checkboxGroup.lookup("#dayLabel");
            day.setText(DayString[DayIndex]);

            checkBoxes[WeekIndex][DayIndex][0] = (JFXCheckBox)checkboxGroup.lookup("#checkbox1");
            checkBoxes[WeekIndex][DayIndex][1] = (JFXCheckBox)checkboxGroup.lookup("#checkbox2");
            checkBoxes[WeekIndex][DayIndex][2] = (JFXCheckBox)checkboxGroup.lookup("#checkbox3");

            WeekRow.getChildren().add(checkboxGroup);

        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }

    private void loadWeekCheckBoxGroup(VBox Container,int WeekIndex) {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/business_pages/module_function_pages/person_space_pages/free_time_pages/free_time_row.fxml"));
            HBox row = loader.load();
            Label day = (Label)row.lookup("#weekLabel");
            day.setText(WeekString[WeekIndex]);
            Container.getChildren().add(row);
            for (int i = 0; i < 8; ++i) {
                loadDayCheckBoxGroup(row, WeekIndex, i);
            }
            Separator sep = new Separator();
            sep.setPrefWidth(container.getWidth());
            container.getChildren().add(sep);

        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }

    private void setOrdinaryBoxesSelectEvent() {
        for (int i = 1; i < WeekString.length; ++i) {
            final int r = i;
            for (int j = 1; j < 8; ++j) {
                final int s = j;
                for (int k = 0; k < 3; ++k) {
                    final int t = k;
                    checkBoxes[i][j][k].setOnAction(event -> {
                        checkBoxes[r][0][t].setSelected(
                                checkBoxes[r][1][t].isSelected() && checkBoxes[r][2][t].isSelected() &&
                                        checkBoxes[r][3][t].isSelected() && checkBoxes[r][4][t].isSelected() &&
                                        checkBoxes[r][5][t].isSelected() && checkBoxes[r][6][t].isSelected() &&
                                        checkBoxes[r][7][t].isSelected());
                        checkBoxes[0][s][t].setSelected(
                                checkBoxes[1][s][t].isSelected() && checkBoxes[2][s][t].isSelected() && checkBoxes[3][s][t].isSelected() &&
                                        checkBoxes[4][s][t].isSelected() && checkBoxes[5][s][t].isSelected() && checkBoxes[6][s][t].isSelected() &&
                                        checkBoxes[7][s][t].isSelected() && checkBoxes[8][s][t].isSelected() && checkBoxes[9][s][t].isSelected() &&
                                        checkBoxes[10][s][t].isSelected() && checkBoxes[11][s][t].isSelected() && checkBoxes[12][s][t].isSelected() &&
                                        checkBoxes[13][s][t].isSelected() && checkBoxes[14][s][t].isSelected());
                        checkBoxes[0][0][t].setSelected(
                                checkBoxes[0][1][t].isSelected() && checkBoxes[0][2][t].isSelected() && checkBoxes[0][3][t].isSelected() &&
                                        checkBoxes[0][4][t].isSelected() && checkBoxes[0][5][t].isSelected() && checkBoxes[0][6][t].isSelected() &&
                                        checkBoxes[0][7][t].isSelected() && checkBoxes[1][1][t].isSelected() && checkBoxes[2][1][t].isSelected() &&
                                        checkBoxes[3][1][t].isSelected() && checkBoxes[4][1][t].isSelected() && checkBoxes[5][1][t].isSelected() &&
                                        checkBoxes[6][1][t].isSelected() && checkBoxes[7][1][t].isSelected() && checkBoxes[8][1][t].isSelected() &&
                                        checkBoxes[9][1][t].isSelected() && checkBoxes[10][1][t].isSelected() && checkBoxes[11][1][t].isSelected() &&
                                        checkBoxes[12][1][t].isSelected() && checkBoxes[13][1][t].isSelected() && checkBoxes[14][1][t].isSelected());
                    });
                }
            }
        }
    }

    private void initControls () {

        if(ElabManagerApplication.currentCertification.getDuty().equals("班委"))
            addAdminControls();

        for (int i = 0; i < WeekString.length; ++i) {
            loadWeekCheckBoxGroup(container, i);
        }

        setOrdinaryBoxesSelectEvent();

        /**
         * 最上的选项监听
         */

        for (int j = 1; j < 8; ++j) {
            final int s = j;
            for (int k = 0; k < 3; ++k) {
                final int t = k;
                checkBoxes[0][j][k].setOnAction(event -> {
                    for (int i = 1; i < WeekString.length; ++i) {
                        checkBoxes[i][s][t].setSelected(checkBoxes[0][s][t].isSelected());
                        checkBoxes[i][0][t].setSelected(
                                checkBoxes[i][1][t].isSelected() && checkBoxes[i][2][t].isSelected() &&
                                        checkBoxes[i][3][t].isSelected() && checkBoxes[i][4][t].isSelected() &&
                                        checkBoxes[i][5][t].isSelected() && checkBoxes[i][6][t].isSelected() &&
                                        checkBoxes[i][7][t].isSelected());
                        checkBoxes[0][0][t].setSelected(
                                checkBoxes[0][1][t].isSelected() && checkBoxes[0][2][t].isSelected() && checkBoxes[0][3][t].isSelected() &&
                                        checkBoxes[0][4][t].isSelected() && checkBoxes[0][5][t].isSelected() && checkBoxes[0][6][t].isSelected() &&
                                        checkBoxes[0][7][t].isSelected() && checkBoxes[1][1][t].isSelected() && checkBoxes[2][1][t].isSelected() &&
                                        checkBoxes[3][1][t].isSelected() && checkBoxes[4][1][t].isSelected() && checkBoxes[5][1][t].isSelected() &&
                                        checkBoxes[6][1][t].isSelected() && checkBoxes[7][1][t].isSelected() && checkBoxes[8][1][t].isSelected() &&
                                        checkBoxes[9][1][t].isSelected() && checkBoxes[10][1][t].isSelected() && checkBoxes[11][1][t].isSelected() &&
                                        checkBoxes[12][1][t].isSelected() && checkBoxes[13][1][t].isSelected() && checkBoxes[14][1][t].isSelected());
                    }
                });
            }
        }

        /**
         * 最左的选项监听
         */

        for (int i = 1; i < WeekString.length; ++i) {
            final int r = i;
            for (int k = 0; k < 3; ++k) {
                final int t = k;
                checkBoxes[i][0][k].setOnAction(event -> {
                    for (int j = 1; j < 8; ++j) {
                        checkBoxes[r][j][t].setSelected(checkBoxes[r][0][t].isSelected());
                        checkBoxes[0][j][t].setSelected(
                                checkBoxes[1][j][t].isSelected() && checkBoxes[2][j][t].isSelected() && checkBoxes[3][j][t].isSelected() &&
                                        checkBoxes[4][j][t].isSelected() && checkBoxes[5][j][t].isSelected() && checkBoxes[6][j][t].isSelected() &&
                                        checkBoxes[7][j][t].isSelected() && checkBoxes[8][j][t].isSelected() && checkBoxes[9][j][t].isSelected() &&
                                        checkBoxes[10][j][t].isSelected() && checkBoxes[11][j][t].isSelected() && checkBoxes[12][j][t].isSelected() &&
                                        checkBoxes[13][j][t].isSelected() && checkBoxes[14][j][t].isSelected());
                        checkBoxes[0][0][t].setSelected(
                                checkBoxes[0][1][t].isSelected() && checkBoxes[0][2][t].isSelected() && checkBoxes[0][3][t].isSelected() &&
                                        checkBoxes[0][4][t].isSelected() && checkBoxes[0][5][t].isSelected() && checkBoxes[0][6][t].isSelected() &&
                                        checkBoxes[0][7][t].isSelected() && checkBoxes[1][1][t].isSelected() && checkBoxes[2][1][t].isSelected() &&
                                        checkBoxes[3][1][t].isSelected() && checkBoxes[4][1][t].isSelected() && checkBoxes[5][1][t].isSelected() &&
                                        checkBoxes[6][1][t].isSelected() && checkBoxes[7][1][t].isSelected() && checkBoxes[8][1][t].isSelected() &&
                                        checkBoxes[9][1][t].isSelected() && checkBoxes[10][1][t].isSelected() && checkBoxes[11][1][t].isSelected() &&
                                        checkBoxes[12][1][t].isSelected() && checkBoxes[13][1][t].isSelected() && checkBoxes[14][1][t].isSelected());
                    }
                });
            }
        }

        /**
         * 左上角三个选项
         */

        for (int k = 0; k < 3; ++k) {
            final int t = k;
            checkBoxes[0][0][k].setOnAction(event -> {
                for (int i = 0; i < WeekString.length; ++i)
                    for (int j = 0; j < 8; ++j)
                        checkBoxes[i][j][t].setSelected(checkBoxes[0][0][t].isSelected());
            });
        }
    }

    @Override
    public void initializeController() {
        save.setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.PRIMARY) {
                if(!isInfoExist)
                    addFreeTimeSession.send();
                else
                    updateFreeTimeSession.send();
            }
        });

        getFreeTimeSession.send();
    }
}
