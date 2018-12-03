package elab.business.member_tab_function_controllers;

import com.jfoenix.controls.JFXCheckBox;
import elab.application.BaseViewController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class FreeTimeCollectPageController extends BaseViewController {

    @FXML
    VBox container;
    String[] DayString = {" ","周一","周二","周三","周四","周五","周六","周日"};
    String[] WeekString = {"所有周","第一周","第二周","第三周","第四周","第五周","第六周","第七周"};

    JFXCheckBox[][][] checkBoxes = new JFXCheckBox[17][8][3];

    public void LoadDayCheckBoxGroup(HBox WeekRow,int WeekIndex, int DayIndex)
    {
        try
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/free_time_page/free_time_checkbox.fxml"));
            Node checkboxGroup = loader.load();
            Label day = (Label)checkboxGroup.lookup("#dayLabel");
            day.setText(DayString[DayIndex]);

            checkBoxes[WeekIndex][DayIndex][0] = (JFXCheckBox)checkboxGroup.lookup("#checkbox1");
            checkBoxes[WeekIndex][DayIndex][1] = (JFXCheckBox)checkboxGroup.lookup("#checkbox2");
            checkBoxes[WeekIndex][DayIndex][2] = (JFXCheckBox)checkboxGroup.lookup("#checkbox3");

            WeekRow.getChildren().add(checkboxGroup);
        }
        catch (Exception exp)
        {
            exp.printStackTrace();
        }
    }
    public void LoadWeekCheckBoxGroup(VBox Container,int WeekIndex)
    {

        try
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/free_time_page/free_time_row.fxml"));
            HBox row = (HBox)loader.load();
            Label day = (Label)row.lookup("#weekLabel");
            day.setText(WeekString[WeekIndex]);
            Container.getChildren().add(row);
            for(int i = 0; i < 8; ++i)
            {
                LoadDayCheckBoxGroup(row,WeekIndex,i);
            }
            Separator sep = new Separator();
            sep.setPrefWidth(container.getWidth());
            container.getChildren().add(sep);

            for(int i = 0; i < 3; ++i)
            {
                final int s = i;
                checkBoxes[WeekIndex][0][i].setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        for(int j = 1; j < 8; ++j)
                            checkBoxes[WeekIndex][j][s].setSelected(checkBoxes[WeekIndex][0][s].isSelected());
                    }
                });
            }
        }
        catch (Exception exp)
        {
            exp.printStackTrace();
        }
    }
    @Override
    public void initializeController()
    {
        for(int i = 0; i<WeekString.length; ++i)
        {
            LoadWeekCheckBoxGroup(container,i);
        }

    }
}
