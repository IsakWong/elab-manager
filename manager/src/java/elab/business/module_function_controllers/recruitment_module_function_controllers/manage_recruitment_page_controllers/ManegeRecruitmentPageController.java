package elab.business.module_function_controllers.recruitment_module_function_controllers.manage_recruitment_page_controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextField;
import elab.application.BaseFunctionContentController;
import elab.database.DatabaseOperations;
import elab.serialization.beans.new_person.NewPerson;
import elab.util.Utilities;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Callback;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class ManegeRecruitmentPageController extends BaseFunctionContentController {

    @FXML
    private VBox container;
    @FXML
    private Label batchLabel;
    @FXML
    private Label cancelBatchLabel;
    @FXML
    private Label fileOutLabel;
    @FXML
    private JFXButton batchBtn;
    @FXML
    private JFXButton cancelBatchBtn;
    @FXML
    private JFXButton fileIn;
    @FXML
    private JFXButton fileOut;
    @FXML
    private JFXButton addBtn;
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
    private TableColumn<NewPerson, ScrollPane> time;
    @FXML
    private TableColumn<NewPerson, String> Email;
    @FXML
    private TableColumn<NewPerson, String> experience;
    @FXML
    private TableColumn<NewPerson, String> understanding;
    @FXML
    private TableColumn<NewPerson, String> evaluation;

    private ContextMenu contextMenu = null;

    private String[] times = {"24日晚18:00", "24日晚19:00", "24日晚20:00", "25日晚18:00", "25日晚19:00", "25日晚20:00"};

    public void chooseFileIn() {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("选择文件");
        fileChooser.setInitialDirectory(
                new File(System.getProperty("user.home"))
        );
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("XLS", "*.xls"),
                new FileChooser.ExtensionFilter("CSV", "*.csv")
        );
        Stage stage = (Stage) container.getScene().getWindow();
        File file = fileChooser.showOpenDialog(stage);
        if (file != null) {
            if (file.getName().endsWith(".xls")) ;
        }
    }

    public void chooseFileOut() {
        try {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("选择路径");
            fileChooser.setInitialDirectory(
                    new File(System.getProperty("user.home"))
            );
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("XLS", "*.xls"),
                    new FileChooser.ExtensionFilter("XLSX", "*.xlsx"),
                    new FileChooser.ExtensionFilter("CSV", "*.csv")
            );
            Stage stage = (Stage) container.getScene().getWindow();
            File file = fileChooser.showSaveDialog(stage);
            if (file != null) {
                if (file.getName().endsWith("xls")) {
                    HSSFWorkbook workbook = new HSSFWorkbook();
                    HSSFSheet sheet = workbook.createSheet("sheet1");
                    HSSFRow titleRow = sheet.createRow(0);
                    //第一行列名
                    for (int i = 0, j = 0; i < tableView.getColumns().size(); ++i) {
                        TableColumn tableColumn = tableView.getColumns().get(i);
                        if (!tableColumn.getText().equals("")) {
                            HSSFCell cell = titleRow.createCell(i - j);
                            cell.setCellValue(tableColumn.getText());
                        } else {
                            ++j;
                        }
                    }
                    //数据
                    ObservableList<NewPerson> newPeople = tableView.getItems();
                    int i = 1;
                    if (batchLabel.isVisible()) {
                        for (NewPerson newPerson : newPeople) {
                            HSSFRow row = sheet.createRow(i);
                            String[] informations = newPerson.toString().split(" ");
                            int j = 0;
                            for (String information : informations) {
                                HSSFCell cell = row.createCell(j);
                                cell.setCellValue(information);
                                ++j;
                            }
                            ++i;
                        }
                    } else {
                        for (NewPerson newPerson : newPeople) {
                            if (newPerson.getSelectionSituation()) {
                                HSSFRow row = sheet.createRow(i);
                                String[] informations = newPerson.toString().split(" ");
                                int j = 0;
                                for (String information : informations) {
                                    HSSFCell cell = row.createCell(j);
                                    cell.setCellValue(information);
                                    ++j;
                                }
                                ++i;
                            }
                        }
                    }
                    FileOutputStream stream = new FileOutputStream(file);
                    workbook.write(stream);
                    stream.flush();
                    stream.close();
                    Utilities.popMessage("导出成功", container);
                } else if (file.getName().endsWith("xlsx")) {
                    XSSFWorkbook workbook = new XSSFWorkbook();
                    XSSFSheet sheet = workbook.createSheet("sheet1");
                    XSSFRow titleRow = sheet.createRow(0);
                    //第一行列名
                    for (int i = 0, j = 0; i < tableView.getColumns().size(); ++i) {
                        TableColumn tableColumn = tableView.getColumns().get(i);
                        if (!tableColumn.getText().equals("")) {
                            XSSFCell cell = titleRow.createCell(i - j);
                            cell.setCellValue(tableColumn.getText());
                        } else {
                            ++j;
                        }
                    }
                    //数据
                    ObservableList<NewPerson> newPeople = tableView.getItems();
                    int i = 1;
                    if (batchLabel.isVisible()) {
                        for (NewPerson newPerson : newPeople) {
                            XSSFRow row = sheet.createRow(i);
                            String[] informations = newPerson.toString().split(" ");
                            int j = 0;
                            for (String information : informations) {
                                XSSFCell cell = row.createCell(j);
                                cell.setCellValue(information);
                                ++j;
                            }
                            ++i;
                        }
                    } else {
                        for (NewPerson newPerson : newPeople) {
                            if (newPerson.getSelectionSituation()) {
                                XSSFRow row = sheet.createRow(i);
                                String[] informations = newPerson.toString().split(" ");
                                int j = 0;
                                for (String information : informations) {
                                    XSSFCell cell = row.createCell(j);
                                    cell.setCellValue(information);
                                    ++j;
                                }
                                ++i;
                            }
                        }
                    }
                    FileOutputStream stream = new FileOutputStream(file);
                    workbook.write(stream);
                    stream.flush();
                    stream.close();
                    Utilities.popMessage("导出成功", container);
                } else {
                    try {
                        CSVFormat format = CSVFormat.DEFAULT.withRecordSeparator("\n");
                        FileWriter fileWriter = new FileWriter(file.getPath(), true);
                        CSVPrinter printer = new CSVPrinter(fileWriter, format);
                        //第一行
                        ArrayList<String> titleRow = new ArrayList<>();
                        for (int i = 0; i < tableView.getColumns().size(); ++i) {
                            TableColumn tableColumn = tableView.getColumns().get(i);
                            if (!tableColumn.getText().equals(""))
                                titleRow.add(tableColumn.getText());
                        }
                        printer.printRecord(titleRow);
                        //数据
                        ObservableList<NewPerson> newPeople = tableView.getItems();
                        if (batchLabel.isVisible()) {
                            for (NewPerson newPerson : newPeople) {
                                String[] data = newPerson.toString().split(" ");
                                printer.printRecord(data);
                            }
                        } else {
                            for(NewPerson newPerson : newPeople) {
                                if(newPerson.getSelectionSituation()) {
                                    String[] data = newPerson.toString().split(" ");
                                    printer.printRecord(data);
                                }
                            }
                        }
                        fileWriter.flush();
                        printer.close(true);
                        fileWriter.close();
                        Utilities.popMessage("导出成功", container);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void creatBtn(VBox timeContainer) {
        try {
            FXMLLoader btnLoader = new FXMLLoader(getClass().getResource("/business_pages/module_function_pages/recruitment_module_function_pages/manage_recruitment_pages/add_time_btn.fxml"));
            Node btnNode = btnLoader.load();
            JFXButton button = (JFXButton) btnNode.lookup("#addTimeBtn");
            button.setOnMouseClicked(clickEvent -> {
                if(clickEvent.getButton() == MouseButton.PRIMARY) {
                    int size = timeContainer.getChildren().size();
                    if (size < 7)
                        timeContainer.getChildren().add(size - 1, new JFXTextField());
                    else
                        Utilities.popMessage("仅有六个面试时间段", container);
                }
            });
            button.setText("+");
            timeContainer.getChildren().add(button);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void removeBtn(VBox timeContainer) {
        timeContainer.getChildren().remove(timeContainer.getChildren().size() - 1);
    }

    public void setTextFieldEnable(VBox timeContainer, Boolean enable) {
        for (int i = 0; i < timeContainer.getChildren().size(); ++i) {
            JFXTextField textField = (JFXTextField) timeContainer.getChildren().get(i);
            textField.setDisable(!enable);
        }
    }

    public ScrollPane creatTimeContainer() {
        ScrollPane returnScrollPane = null;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/business_pages/module_function_pages/recruitment_module_function_pages/manage_recruitment_pages/time_container.fxml"));
            Node node = loader.load();
            ScrollPane scrollPane = (ScrollPane) node.lookup("#scrollPane");
            returnScrollPane = scrollPane;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return returnScrollPane;
    }

    public void addTextField(NewPerson newPerson, String time) {
        JFXTextField textField = new JFXTextField();
        textField.setText(time);
        textField.setDisable(true);
        VBox timeContainer = (VBox) newPerson.getScrollPane().getContent();
        timeContainer.getChildren().add(textField);
    }

    public void clearUnusedField(VBox timeContainer) {
        for(int i = 0; i < timeContainer.getChildren().size(); ++i) {
            JFXTextField child = (JFXTextField) timeContainer.getChildren().get(i);
            if(child.getText().equals("")) {
                timeContainer.getChildren().remove(i);
                --i;
            }
        }
    }

    public void initItems() {
        List list = DatabaseOperations.getInstance().selectNewPeople();
        ObservableList<NewPerson> newPeople = FXCollections.<NewPerson>observableArrayList();
        newPeople.addAll(list);
        for (NewPerson newPerson : newPeople) {
            newPerson.setOldNumber(newPerson.getNumber());
            newPerson.setScrollPane(creatTimeContainer());
            creatSheetTime(newPerson);
        }
        for (int i = 0; i < newPeople.size(); ++i) {
            String[] time = newPeople.get(i).getTime().split(",");
            for (int j = 0; j < time.length; ++j) {
                switch (time[j]) {
                    case "0":
                        addTextField(newPeople.get(i), times[0]);
                        break;
                    case "1":
                        addTextField(newPeople.get(i), times[1]);
                        break;
                    case "2":
                        addTextField(newPeople.get(i), times[2]);
                        break;
                    case "3":
                        addTextField(newPeople.get(i), times[3]);
                        break;
                    case "4":
                        addTextField(newPeople.get(i), times[4]);
                        break;
                    case "5":
                        addTextField(newPeople.get(i), times[5]);
                        break;
                    default:
                        break;
                }
            }
        }
        tableView.setItems(newPeople);
    }

    public void creatSheetTime(NewPerson newPerson) {
        String[] time = newPerson.getTime().split(",");
        String newTime = null;
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
        for(int i = 1; i < time.length; ++i) {
                newTime += ",";
                switch (time[i]) {
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
        newPerson.setSheetTime(newTime);
    }

    public void returnTime(NewPerson newPerson) {
        String newTime = null;
        VBox timeContainer = (VBox) newPerson.getScrollPane().getContent();
        int size = timeContainer.getChildren().size();
        if (size >= 1) {
            JFXTextField firstChild = (JFXTextField) timeContainer.getChildren().get(0);
            switch (firstChild.getText()) {
                case "24日晚18:00":
                    newTime = "0";
                    break;
                case "24日晚19:00":
                    newTime = "1";
                    break;
                case "24日晚20:00":
                    newTime = "2";
                    break;
                case "25日晚18:00":
                    newTime = "3";
                    break;
                case "25日晚19:00":
                    newTime = "4";
                    break;
                case "25日晚20:00":
                    newTime = "5";
                    break;
                default:
            }
            for (int i = 1; i < size; ++i) {
                newTime += ",";
                JFXTextField child = (JFXTextField) timeContainer.getChildren().get(i);
                switch (child.getText()) {
                    case "24日晚18:00":
                        newTime += "0";
                        break;
                    case "24日晚19:00":
                        newTime += "1";
                        break;
                    case "24日晚20:00":
                        newTime += "2";
                        break;
                    case "25日晚18:00":
                        newTime += "3";
                        break;
                    case "25日晚19:00":
                        newTime += "4";
                        break;
                    case "25日晚20:00":
                        newTime += "5";
                        break;
                    default:
                }
            }
        }
        newPerson.setTime(newTime);
    }

    public ContextMenu getContextMenu() {
        if(contextMenu == null) {
            contextMenu = new ContextMenu();
            MenuItem delete = new MenuItem();
            if(batchLabel.isVisible())
                delete.setText("删除信息");
            else
                delete.setText("删除所选信息");
            delete.setOnAction(event -> {
                contextMenu.hide();
                if(batchLabel.isVisible()) {
                    NewPerson newPerson = tableView.getSelectionModel().getSelectedItem();
                    ObservableList<NewPerson> newPeople = tableView.getItems();
                    newPeople.remove(newPerson);
                    tableView.refresh();
                    DatabaseOperations.getInstance().deleteNewPerson(newPerson.getNumber());
                    Utilities.popMessage("删除成功", container);
                } else {
                    Object[] options ={"确定", "取消"};
                    int m = JOptionPane.showOptionDialog(null, "确定删除所选信息？", "注意", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
                    if(m == 0) {
                        ObservableList<NewPerson> newPeople = tableView.getItems();
                        ObservableList<NewPerson> deleteInformation = FXCollections.observableArrayList();
                        for (NewPerson newPerson : newPeople) {
                            if (newPerson.getSelectionSituation()) {
                                deleteInformation.add(newPerson);
                                newPeople.remove(newPerson);
                            }
                        }
                        tableView.refresh();
                        DatabaseOperations.getInstance().deleteNewPeople(deleteInformation);
                        Utilities.popMessage("删除成功", container);
                    }
                }
            });
            contextMenu.getItems().add(delete);
        } else {
            MenuItem delete = contextMenu.getItems().get(0);
            if(batchLabel.isVisible())
                delete.setText("删除信息");
            else
                delete.setText("删除所选信息");
        }
        return contextMenu;
    }

    public void initTableView() {

        tableView.setEditable(true);
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        tableView.getSelectionModel().setCellSelectionEnabled(true);
        tableView.setOnMousePressed(event -> {
            if(event.getButton() == MouseButton.SECONDARY) {
                getContextMenu().hide();
                getContextMenu().show(container, event.getScreenX(), event.getScreenY());
            } else {
                getContextMenu().hide();
            }
        });

        number.setCellFactory(TextFieldTableCell.forTableColumn());
        number.setOnEditCommit(event -> {
            NewPerson newPerson = tableView.getItems().get(event.getTablePosition().getRow());
            if(newPerson.getNumber() == null) {
                ObservableList<NewPerson> newPeople = tableView.getItems();
                Boolean newNumber = true;
                for(NewPerson person : newPeople) {
                    if(person.getNumber() != null && person.getNumber().equals(event.getNewValue())) {
                        newNumber = false;
                        Utilities.popMessage("此学号已存在,此信息无效", container);
                        break;
                    }
                }
                if(newNumber) {
                    Utilities.popMessage("添加成功,请完善相关信息", container);
                    newPerson.setNumber(event.getNewValue());
                    DatabaseOperations.getInstance().insertNewPerson(newPerson);
                    newPerson.setOldNumber(newPerson.getNumber());
                }
            } else {
                newPerson.setNumber(event.getNewValue());
                DatabaseOperations.getInstance().updateNewPerson(newPerson);
                newPerson.setOldNumber(newPerson.getNumber());
            }
        });

        name.setCellFactory(TextFieldTableCell.forTableColumn());
        name.setOnEditCommit(event -> {
            NewPerson newPerson = tableView.getItems().get(event.getTablePosition().getRow());
            if(newPerson.getNumber() == null)
                Utilities.popMessage("请先填写学号,否则信息无法更新到数据库", container);
            else {
                newPerson.setName(event.getNewValue());
                DatabaseOperations.getInstance().updateNewPerson(newPerson);
            }
        });
        sex.setCellFactory(TextFieldTableCell.forTableColumn());
        sex.setOnEditCommit(event -> {
            NewPerson newPerson = tableView.getItems().get(event.getTablePosition().getRow());
            if(newPerson.getNumber() == null)
                Utilities.popMessage("请先填写学号,否则信息无法更新到数据库", container);
            else {
                newPerson.setSex(event.getNewValue());
                DatabaseOperations.getInstance().updateNewPerson(newPerson);
            }
        });
        tel.setCellFactory(TextFieldTableCell.forTableColumn());
        tel.setOnEditCommit(event -> {
            NewPerson newPerson = tableView.getItems().get(event.getTablePosition().getRow());
            if(newPerson.getNumber() == null)
                Utilities.popMessage("请先填写学号,否则信息无法更新到数据库", container);
            else {
                newPerson.setTel(event.getNewValue());
                DatabaseOperations.getInstance().updateNewPerson(newPerson);
            }
        });
        group.setCellFactory(TextFieldTableCell.forTableColumn());
        group.setOnEditCommit(event -> {
            NewPerson newPerson = tableView.getItems().get(event.getTablePosition().getRow());
            if(newPerson.getNumber() == null)
                Utilities.popMessage("请先填写学号,否则信息无法更新到数据库", container);
            else {
                newPerson.setGroup(event.getNewValue());
                DatabaseOperations.getInstance().updateNewPerson(newPerson);
            }
        });
        specialty.setCellFactory(TextFieldTableCell.forTableColumn());
        specialty.setOnEditCommit(event -> {
            NewPerson newPerson = tableView.getItems().get(event.getTablePosition().getRow());
            if(newPerson.getNumber() == null)
                Utilities.popMessage("请先填写学号,否则信息无法更新到数据库", container);
            else {
                newPerson.setSpecialty(event.getNewValue());
                DatabaseOperations.getInstance().updateNewPerson(newPerson);
            }
        });
        birthplace.setCellFactory(TextFieldTableCell.forTableColumn());
        birthplace.setOnEditCommit(event -> {
            NewPerson newPerson = tableView.getItems().get(event.getTablePosition().getRow());
            if(newPerson.getNumber() == null)
                Utilities.popMessage("请先填写学号,否则信息无法更新到数据库", container);
            else {
                newPerson.setBirthplace(event.getNewValue());
                DatabaseOperations.getInstance().updateNewPerson(newPerson);
            }
        });
        classes.setCellFactory(TextFieldTableCell.forTableColumn());
        classes.setOnEditCommit(event -> {
            NewPerson newPerson = tableView.getItems().get(event.getTablePosition().getRow());
            if(newPerson.getNumber() == null)
                Utilities.popMessage("请先填写学号,否则信息无法更新到数据库", container);
            else {
                newPerson.setClasses(event.getNewValue());
                DatabaseOperations.getInstance().updateNewPerson(newPerson);
            }
        });
        duty.setCellFactory(TextFieldTableCell.forTableColumn());
        duty.setOnEditCommit(event -> {
            NewPerson newPerson = tableView.getItems().get(event.getTablePosition().getRow());
            if(newPerson.getNumber() == null)
                Utilities.popMessage("请先填写学号,否则信息无法更新到数据库", container);
            else {
                newPerson.setDuty(event.getNewValue());
                DatabaseOperations.getInstance().updateNewPerson(newPerson);
            }
        });
        corporation.setCellFactory(TextFieldTableCell.forTableColumn());
        corporation.setOnEditCommit(event -> {
            NewPerson newPerson = tableView.getItems().get(event.getTablePosition().getRow());
            if(newPerson.getNumber() == null)
                Utilities.popMessage("请先填写学号,否则信息无法更新到数据库", container);
            else {
                newPerson.setCorporation(event.getNewValue());
                DatabaseOperations.getInstance().updateNewPerson(newPerson);
            }
        });
        hobby.setCellFactory(TextFieldTableCell.forTableColumn());
        hobby.setOnEditCommit(event -> {
            NewPerson newPerson = tableView.getItems().get(event.getTablePosition().getRow());
            if(newPerson.getNumber() == null)
                Utilities.popMessage("请先填写学号,否则信息无法更新到数据库", container);
            else {
                newPerson.setHobby(event.getNewValue());
                DatabaseOperations.getInstance().updateNewPerson(newPerson);
            }
        });
        Email.setCellFactory(TextFieldTableCell.forTableColumn());
        Email.setOnEditCommit(event -> {
            NewPerson newPerson = tableView.getItems().get(event.getTablePosition().getRow());
            if(newPerson.getNumber() == null)
                Utilities.popMessage("请先填写学号,否则信息无法更新到数据库", container);
            else {
                newPerson.setEmail(event.getNewValue());
                DatabaseOperations.getInstance().updateNewPerson(newPerson);
            }
        });
        experience.setCellFactory(TextFieldTableCell.forTableColumn());
        experience.setOnEditCommit(event -> {
            NewPerson newPerson = tableView.getItems().get(event.getTablePosition().getRow());
            if(newPerson.getNumber() == null)
                Utilities.popMessage("请先填写学号,否则信息无法更新到数据库", container);
            else {
                newPerson.setExperience(event.getNewValue());
                DatabaseOperations.getInstance().updateNewPerson(newPerson);
            }
        });
        understanding.setCellFactory(TextFieldTableCell.forTableColumn());
        understanding.setOnEditCommit(event -> {
            NewPerson newPerson = tableView.getItems().get(event.getTablePosition().getRow());
            if(newPerson.getNumber() == null)
                Utilities.popMessage("请先填写学号,否则信息无法更新到数据库", container);
            else {
                newPerson.setUnderstanding(event.getNewValue());
                DatabaseOperations.getInstance().updateNewPerson(newPerson);
            }
        });
        evaluation.setCellFactory(TextFieldTableCell.forTableColumn());
        evaluation.setOnEditCommit(event -> {
            NewPerson newPerson = tableView.getItems().get(event.getTablePosition().getRow());
            if(newPerson.getNumber() == null)
                Utilities.popMessage("请先填写学号,否则信息无法更新到数据库", container);
            else {
                newPerson.setEvaluation(event.getNewValue());
                DatabaseOperations.getInstance().updateNewPerson(newPerson);
            }
        });

        time.setCellFactory(new Callback<TableColumn<NewPerson, ScrollPane>, TableCell<NewPerson, ScrollPane>>() {
            @Override
            public TableCell<NewPerson, ScrollPane> call(TableColumn<NewPerson, ScrollPane> param) {
                AtomicReference<Boolean> isTimeEditing = new AtomicReference<>(false);
                TableCell<NewPerson, ScrollPane> cell = new TableCell<NewPerson, ScrollPane>() {
                    @Override
                    protected void updateItem(ScrollPane scrollPane, boolean arg1) {
                        super.updateItem(scrollPane, arg1);
                        if (arg1) {
                            setGraphic(null);
                        } else {
                            setGraphic(scrollPane);
                        }
                    }
                };
                cell.setOnMouseClicked(event -> {
                    if (event.getClickCount() == 2 && event.getButton() == MouseButton.PRIMARY) {
                        if(!isTimeEditing.get()) {
                            isTimeEditing.set(true);
                            VBox timeContainer = (VBox) cell.getItem().getContent();
                            int size = timeContainer.getChildren().size();
                            if (size == 0) {
                                creatBtn(timeContainer);
                            } else {
                                setTextFieldEnable(timeContainer, true);
                                creatBtn(timeContainer);
                            }
                        }
                    }
                });
                cell.focusedProperty().addListener(new ChangeListener<Boolean>() {
                    @Override
                    public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                        if(!newValue && isTimeEditing.get()) {
                            isTimeEditing.set(false);
                            VBox timeContainer = (VBox) cell.getItem().getContent();
                            int size = timeContainer.getChildren().size();
                            if (size == 0) {
                                removeBtn(timeContainer);
                            } else {
                                removeBtn(timeContainer);
                                clearUnusedField(timeContainer);
                                setTextFieldEnable(timeContainer, false);
                            }
                            NewPerson newPerson = (NewPerson) cell.getTableRow().getItem();
                            returnTime(newPerson);
                            creatSheetTime(newPerson);
                            DatabaseOperations.getInstance().updateNewPerson(newPerson);
                        }
                    }
                });
                return cell;
            }
        });
    }

    public void setContextMenuHideEvent() {
        container.setOnMousePressed(event -> {
            if(getContextMenu().isShowing())
                getContextMenu().hide();
        });

        batchBtn.setOnMousePressed(event -> {
            if(getContextMenu().isShowing())
                getContextMenu().hide();
        });

        cancelBatchBtn.setOnMousePressed(event -> {
            if(getContextMenu().isShowing())
                getContextMenu().hide();
        });

        fileIn.setOnMouseClicked(event -> {
            if(getContextMenu().isShowing())
                getContextMenu().hide();
        });

        fileOut.setOnMousePressed(event -> {
            if(getContextMenu().isShowing())
                getContextMenu().hide();
        });

        addBtn.setOnMousePressed(event -> {
            if(getContextMenu().isShowing())
                getContextMenu().hide();
        });
    }

    @Override
    public void initializeController() {

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
        time.setCellValueFactory(new PropertyValueFactory<NewPerson, ScrollPane>("scrollPane"));
        Email.setCellValueFactory(new PropertyValueFactory<NewPerson, String>("Email"));
        experience.setCellValueFactory(new PropertyValueFactory<NewPerson, String>("experience"));
        understanding.setCellValueFactory(new PropertyValueFactory<NewPerson, String>("understanding"));
        evaluation.setCellValueFactory(new PropertyValueFactory<NewPerson, String>("evaluation"));

        initTableView();
        initItems();

        fileIn.setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.PRIMARY) {
                chooseFileIn();
            }
        });

        fileOut.setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.PRIMARY) {
                chooseFileOut();
            }
        });

        batchBtn.setOnMouseClicked(event -> {
            if(event.getButton() == MouseButton.PRIMARY) {
                batchLabel.setVisible(false);
                batchBtn.setVisible(false);
                cancelBatchLabel.setVisible(true);
                cancelBatchBtn.setVisible(true);
                fileOutLabel.setText("导出所选信息");
                TableColumn<NewPerson, Boolean> selectColumn = new TableColumn<>();
                tableView.getColumns().add(0, selectColumn);
                selectColumn.setCellFactory(new Callback<TableColumn<NewPerson, Boolean>, TableCell<NewPerson, Boolean>>() {
                    @Override
                    public TableCell<NewPerson, Boolean> call(TableColumn<NewPerson, Boolean> param) {
                        TableCell<NewPerson, Boolean> cell = new TableCell<NewPerson, Boolean>() {
                            @Override
                            protected void updateItem(Boolean selectionSituation, boolean arg1) {
                                super.updateItem(selectionSituation, arg1);
                                if (arg1) {
                                    setGraphic(null);
                                } else {
                                    try {
                                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/business_pages/module_function_pages/recruitment_module_function_pages/manage_recruitment_pages/check_box.fxml"));
                                        Node node = loader.load();
                                        JFXCheckBox checkBox = (JFXCheckBox) node.lookup("#checkBox");
                                        setGraphic(checkBox);
                                        checkBox.setOnMouseClicked(event1 -> {
                                            TableCell<NewPerson, Boolean> cell = (TableCell<NewPerson, Boolean>) checkBox.getParent();
                                            NewPerson newPerson = (NewPerson) cell.getTableRow().getItem();
                                            newPerson.setSelectionSituation(checkBox.isSelected());
                                        });
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        };
                        return cell;
                    }
                });
                selectColumn.setCellValueFactory(new PropertyValueFactory<NewPerson, Boolean>("selectionSituation"));
                tableView.refresh();
            }
        });

        cancelBatchBtn.setOnMouseClicked(event -> {
            if(event.getButton() == MouseButton.PRIMARY) {
                cancelBatchLabel.setVisible(false);
                cancelBatchBtn.setVisible(false);
                batchLabel.setVisible(true);
                batchBtn.setVisible(true);
                fileOutLabel.setText("导出信息");
                tableView.getColumns().remove(0);
                ObservableList<NewPerson> newPeople = tableView.getItems();
                for(NewPerson newPerson : newPeople) {
                    newPerson.setSelectionSituation(false);
                }
                tableView.refresh();
            }
        });

        addBtn.setOnMouseClicked(event -> {
            if(event.getButton() == MouseButton.PRIMARY) {
                try {
                    ObservableList<NewPerson> newPeople = tableView.getItems();
                    NewPerson newPerson = new NewPerson();
                    newPerson.setName("无");
                    newPerson.setSex("男");
                    newPerson.setTel("无");
                    newPerson.setGroup("无");
                    newPerson.setSpecialty("无");
                    newPerson.setBirthplace("无");
                    newPerson.setClasses("无");
                    newPerson.setDuty("无");
                    newPerson.setCorporation("无");
                    newPerson.setHobby("无");
                    newPerson.setTime("0");
                    newPerson.setEmail("无");
                    newPerson.setSheetTime("24日晚18:00");
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/business_pages/module_function_pages/recruitment_module_function_pages/manage_recruitment_pages/time_container.fxml"));
                    Node node = loader.load();
                    ScrollPane scrollPane = (ScrollPane) node.lookup("#scrollPane");
                    newPerson.setScrollPane(scrollPane);
                    addTextField(newPerson, times[0]);
                    newPeople.add(0, newPerson);
                    tableView.refresh();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        setContextMenuHideEvent();
    }
}
