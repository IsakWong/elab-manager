package elab.business.assist_teaching_tab_function_controllers;

import elab.application.BaseViewController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ViewSelectCoursesInformationController extends BaseViewController {

    @FXML
    private VBox container;

    String[] WeekString = {"周\\天","第四周","第五周","第六周","第七周"};
    String[] DayString = {"周一","周二","周三","周四","周五","周六","周日"};
    String[][] LabelString = {{"硬件","硬件","硬件","硬件","硬件","硬件","硬件"},{"硬件","硬件","硬件","硬件","禁止选课","禁止选课","禁止选课"},
            {"软件","软件","软件","软件","软件","软件","软件"},{"软件","软件","软件","软件","禁止选课","禁止选课","禁止选课"}};

    public void loadDayLabelGroup(HBox WeekRow, int WeekIndex, int DayIndex) {
        try {

            if(WeekIndex == 0) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view_select_courses_information_page/view_select_courses_column.fxml"));
                Label labelGroup = loader.load();
                Label day = (Label) labelGroup.lookup("#weekLabel");
                day.setText(DayString[DayIndex]);
                WeekRow.getChildren().add(day);
            }
            else {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view_select_courses_information_page/view_select_courses_label.fxml"));
                Label labelGroup = loader.load();
                Label day = (Label) labelGroup.lookup("#dayLabel");
                day.setText(LabelString[WeekIndex-1][DayIndex]);
                day.setOnMouseClicked(event -> {
                    if(event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 2) {
                        System.out.println("双击左键");
                    }
                });
                WeekRow.getChildren().add(day);
            }

        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }

    public void loadWeekLabelGroup(VBox Container, int WeekIndex) {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view_select_courses_information_page/view_select_courses_row.fxml"));
            HBox row = loader.load();
            Label day = (Label)row.lookup("#weekLabel");
            day.setText(WeekString[WeekIndex]);
            Container.getChildren().add(row);
            for (int i = 0; i < 7; ++i) {
                loadDayLabelGroup(row, WeekIndex, i);
            }
            Separator sep = new Separator();
            sep.setPrefWidth(container.getWidth());
            container.getChildren().add(sep);

        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }

    @Override
    public void initializeController() {
        for(int i = 0; i < WeekString.length; ++i) {
            loadWeekLabelGroup(container, i);
        }
    }
}
