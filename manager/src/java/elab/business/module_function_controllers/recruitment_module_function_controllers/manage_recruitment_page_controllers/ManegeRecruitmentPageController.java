package elab.business.module_function_controllers.recruitment_module_function_controllers.manage_recruitment_page_controllers;

import com.jfoenix.controls.JFXButton;
import elab.application.BaseViewController;
import elab.database.DatabaseOperations;
import elab.serialization.beans.new_person.NewPerson;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.List;


public class ManegeRecruitmentPageController extends BaseViewController {

    @FXML
    private VBox container;
    @FXML
    private JFXButton fileIn;
    @FXML
    private JFXButton batchOperation;
    @FXML
    private JFXButton fileOut;
    @FXML
    private TableView<NewPerson> tableView;
    @FXML
    private TableColumn<NewPerson, String> number;
    @FXML
    private TableColumn<NewPerson, String> name;
    @FXML
    private TableColumn<NewPerson, String> sex;
    @FXML
    private TableColumn<NewPerson, String> tel;
    @FXML
    private TableColumn<NewPerson, String> group;
    @FXML
    private TableColumn<NewPerson, String> specialty;
    @FXML
    private TableColumn<NewPerson, String> birthplace;
    @FXML
    private TableColumn<NewPerson, String> classes;
    @FXML
    private TableColumn<NewPerson, String> duty;
    @FXML
    private TableColumn<NewPerson, String> corporation;
    @FXML
    private TableColumn<NewPerson, String> hobby;
    @FXML
    private TableColumn<NewPerson, String> time;
    @FXML
    private TableColumn<NewPerson, String> Email;
    @FXML
    private TableColumn<NewPerson, String> experience;
    @FXML
    private TableColumn<NewPerson, String> understanding;
    @FXML
    private TableColumn<NewPerson, String> evaluation;

    public void chooseFileIn() {
        /*
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("选择文件");
        Stage stage = (Stage) container.getScene().getWindow();
        File file = fileChooser.showOpenDialog(stage);
        */

    }

    public void FileOut() {
        FileChooser fileChooser = new FileChooser();
        Stage stage = (Stage) container.getScene().getWindow();
        File file = fileChooser.showOpenDialog(stage);
    }

    @Override
    public void initializeController() {

        String[] times = {"24日晚18:00","24日晚19:00","24日晚20:00","25日晚18:00","25日晚19:00","25日晚20:00"};
        List list = DatabaseOperations.getInstance().selectNewPeople();
        ObservableList<NewPerson> newPeople = FXCollections.<NewPerson>observableArrayList();
        newPeople.addAll(list);
        for(int i = 0; i < newPeople.size(); ++i) {
            String newTime = null;
            String[] time = newPeople.get(i).getTime().split(",");
            if(time[0] != null) {
                switch (time[0]) {
                    case "0":
                        newTime = times[0];
                        break;
                    case "1":
                        newTime = times[1];
                        break;
                    case "2":
                        newTime = times[2];
                        break;
                    case "3":
                        newTime = times[3];
                        break;
                    case "4":
                        newTime = times[4];
                        break;
                    case "5":
                        newTime = times[5];
                        break;
                    default:
                        break;
                }
                for (int j = 1; j < time.length; ++j) {
                    newTime += "\n";
                    switch (time[j]) {
                        case "0":
                            newTime += times[0];
                            break;
                        case "1":
                            newTime += times[1];
                            break;
                        case "2":
                            newTime += times[2];
                            break;
                        case "3":
                            newTime += times[3];
                            break;
                        case "4":
                            newTime += times[4];
                            break;
                        case "5":
                            newTime += times[5];
                            break;
                        default:
                            break;
                    }
                }
            }
            newPeople.get(i).setTime(newTime);
        }

        number.setCellValueFactory(new PropertyValueFactory<NewPerson, String>("number"));
        name.setCellValueFactory(new PropertyValueFactory<NewPerson, String>("name"));
        sex.setCellValueFactory(new PropertyValueFactory<NewPerson, String>("sex"));
        tel.setCellValueFactory(new PropertyValueFactory<NewPerson, String>("tel"));
        group.setCellValueFactory(new PropertyValueFactory<NewPerson, String>("group"));
        specialty.setCellValueFactory(new PropertyValueFactory<NewPerson, String>("specialty"));
        birthplace.setCellValueFactory(new PropertyValueFactory<NewPerson, String>("birthplace"));
        classes.setCellValueFactory(new PropertyValueFactory<NewPerson, String>("classes"));
        duty.setCellValueFactory(new PropertyValueFactory<NewPerson, String>("duty"));
        corporation.setCellValueFactory(new PropertyValueFactory<NewPerson, String>("corporation"));
        hobby.setCellValueFactory(new PropertyValueFactory<NewPerson, String>("hobby"));
        time.setCellValueFactory(new PropertyValueFactory<NewPerson, String>("time"));
        Email.setCellValueFactory(new PropertyValueFactory<NewPerson, String>("Email"));
        experience.setCellValueFactory(new PropertyValueFactory<NewPerson, String>("experience"));
        understanding.setCellValueFactory(new PropertyValueFactory<NewPerson, String>("understanding"));
        evaluation.setCellValueFactory(new PropertyValueFactory<NewPerson, String>("evaluation"));
        tableView.setItems(newPeople);

        fileIn.setOnMouseClicked(event -> {
            if(event.getButton() == MouseButton.PRIMARY) {
                chooseFileIn();
            }
        });

        fileOut.setOnMouseClicked(event -> {
            if(event.getButton() == MouseButton.PRIMARY) {
                chooseFileIn();
            }
        });
    }
}
