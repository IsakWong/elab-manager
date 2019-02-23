package elab.business.module_function_controllers.member_module_function_controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import elab.application.BaseFunctionContentController;
import elab.util.Utilities;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class FreeTimeCollectPageController extends BaseFunctionContentController {

    @FXML
    private VBox container;
    @FXML
    private JFXButton save;
    @FXML
    private TextArea questionBoard;
    @FXML
    private AnchorPane pageContainer;

    String[] DayString = {" ","周一","周二","周三","周四","周五","周六","周日"};
    String[] WeekString = {"所有周","第一周","第二周","第三周","第四周","第五周","第六周","第七周","第八周","第九周","第十周","第十一周","第十二周","第十三周","第十四周"};

    JFXCheckBox[][][] checkBoxes = new JFXCheckBox[17][8][3];

    public void loadDayCheckBoxGroup(HBox WeekRow,int WeekIndex, int DayIndex) {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/business_pages/module_function_pages/member_module_function_pages/free_time_pages/free_time_checkbox.fxml"));
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

    public void loadWeekCheckBoxGroup(VBox Container,int WeekIndex) {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/business_pages/module_function_pages/member_module_function_pages/free_time_pages/free_time_row.fxml"));
            HBox row = loader.load();
            Label day = (Label)row.lookup("#weekLabel");
            day.setText(WeekString[WeekIndex]);
            Container.getChildren().add(row);
            for (int i = 0; i < 8; ++i) {
                loadDayCheckBoxGroup(row,WeekIndex,i);
            }
            Separator sep = new Separator();
            sep.setPrefWidth(container.getWidth());
            container.getChildren().add(sep);

        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }

    /**
     * 用于处理每个非首个选项监听事件的内部线程类
     */

    class LoadOtherCheckBoxEventThread extends Thread {

        public void run() {
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
    }

    @Override
    public void initializeController() {

        for (int i = 0; i < WeekString.length; ++i) {
            loadWeekCheckBoxGroup(container,i);
        }

        new LoadOtherCheckBoxEventThread().start();

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

        save.setOnMouseClicked(event -> {
            if(event.getButton() == MouseButton.PRIMARY) {

                Utilities.popMessage("信息保存成功!", pageContainer);
            }
        });
    }
}
