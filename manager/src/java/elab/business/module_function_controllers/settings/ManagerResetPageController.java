package elab.business.module_function_controllers.settings;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.sun.org.apache.xpath.internal.operations.Bool;
import elab.application.BaseFunctionContentController;
import elab.database.DatabaseOperations;
import elab.database.Session;
import elab.serialization.beans.rota.Rota;
import elab.serialization.beans.school_opening_information.SchoolOpeningInformation;
import elab.serialization.beans.student.Student;
import elab.util.Utilities;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ManagerResetPageController extends BaseFunctionContentController {

    @FXML
    private JFXDatePicker termStartDatePicker;
    @FXML
    private JFXComboBox<String> hardStartBox;
    @FXML
    private JFXComboBox<String> hardEndBox;
    @FXML
    private JFXComboBox<String> softStartBox;
    @FXML
    private JFXComboBox<String> softEndBox;
    @FXML
    private JFXButton saveBtn;
    @FXML
    private JFXButton nameListBtn;
    @FXML
    private VBox container;

    private Paint unfocusedColor;

    private JFXTextField datePickerEditor;

    Session<Boolean> updateGradeSession = new Session<Boolean>() {
        @Override
        public void onPostFetchResult(SessionResult<Boolean> sessionResult) {
            if (Utilities.getTerm().endsWith("秋")) {
                sessionResult.result = DatabaseOperations.getInstance().updateGrade();
                if (sessionResult.result == null) {
                    sessionResult.errorMessage = "更新所有成员年级信息失败";
                }
            } else {
                sessionResult.result = true;
            }

        }

        @Override
        public void onSuccess(Boolean param) {
            popupMessage("信息更新成功", 1500);
        }

        @Override
        public void onError(String errorMessage) {
            popupMessage(errorMessage, 1500);
        }

        @Override
        public void onBusy() {
            popupMessage("正在更新信息", 1500);
        }
    };

    Session<Boolean> setMessageSession = new Session<Boolean>() {
        @Override
        public void onPostFetchResult(SessionResult<Boolean> sessionResult) {
            SchoolOpeningInformation schoolOpeningInformation = new SchoolOpeningInformation();
            schoolOpeningInformation.setSchoolOpeningDate(termStartDatePicker.getValue() + " 00:00:00");
            schoolOpeningInformation.setHardWeeks(hardStartBox.getValue() + "~" + hardEndBox.getValue());
            schoolOpeningInformation.setHardTheory(Utilities.getWeekFirstDayDate(schoolOpeningInformation.getSchoolOpeningDate(), Integer.parseInt(hardStartBox.getValue()), 1));
            schoolOpeningInformation.setSoftWeeks(softStartBox.getValue() + "~" + softEndBox.getValue());
            schoolOpeningInformation.setSoftTheory(Utilities.getWeekFirstDayDate(schoolOpeningInformation.getSchoolOpeningDate(), Integer.parseInt(softStartBox.getValue()), 1));
            schoolOpeningInformation.setTerm(Utilities.getTerm());
            sessionResult.result = DatabaseOperations.getInstance().setSchoolOpeningDateInformation(schoolOpeningInformation);
            Utilities.setSchoolOpeningInformation(DatabaseOperations.getInstance().selectSchoolOpeningDateInformation());
            if (sessionResult.result == null) {
                sessionResult.errorMessage = "信息更新失败";
            }
        }

        @Override
        public void onSuccess(Boolean param) {
            updateGradeSession.send();
        }

        @Override
        public void onError(String errorMessage) {
            popupMessage(errorMessage, 1500);
        }

        @Override
        public void onBusy() {
            popupMessage("正在更新信息", 1500);
        }
    };

    public String getCellValue(Cell cell){
        String cellValue = "";
        if (cell == null){
            return cellValue;
        }
        //把数字当成String来读，避免出现1读成1.0的情况
        if (cell.getCellType() == CellType.NUMERIC){
            cell.setCellType(CellType.STRING);
        }
        //判断数据的类型
        switch (cell.getCellType()){
            case STRING: //字符串
                cellValue = String.valueOf(cell.getStringCellValue());
                break;
            case BOOLEAN: //Boolean
                cellValue = String.valueOf(cell.getBooleanCellValue());
                break;
            case FORMULA: //公式
                cellValue = String.valueOf(cell.getCellFormula());
                break;
            case BLANK: //空值
                cellValue = "";
                break;
            case ERROR: //故障
                cellValue = "非法字符";
                break;
            default:
                cellValue = "未知类型";
                break;
        }
        return cellValue;
    }

    private void initInformation() {
        try {
            SchoolOpeningInformation schoolOpeningInformation = Utilities.getSchoolOpeningInformation();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date termStartDate = simpleDateFormat.parse(schoolOpeningInformation.getSchoolOpeningDate());
            Instant instant = termStartDate.toInstant();
            ZoneId zoneId = ZoneId.systemDefault();
            LocalDate termStartLocalDate = instant.atZone(zoneId).toLocalDate();
            termStartDatePicker.setValue(termStartLocalDate);

            String[] hardWeeks = schoolOpeningInformation.getHardWeeks().split("~");
            hardStartBox.setValue(hardWeeks[0]);
            hardEndBox.setValue(hardWeeks[1]);
            for (int startWeek = Integer.parseInt(hardWeeks[0]) + 1; startWeek < 17; ++startWeek) {
                hardEndBox.getItems().add(Integer.toString(startWeek));
            }
            String[] softWeeks = schoolOpeningInformation.getSoftWeeks().split("~");
            softStartBox.setValue(softWeeks[0]);
            softEndBox.setValue(softWeeks[1]);
            for (int startWeek = Integer.parseInt(softWeeks[0]) + 1; startWeek < 17; ++startWeek) {
                softEndBox.getItems().add(Integer.toString(startWeek));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initializeController() {

        datePickerEditor = (JFXTextField)termStartDatePicker.getEditor();

        unfocusedColor = Color.valueOf("000000");

        for (int i = 1; i < 17; ++i) {
            hardStartBox.getItems().add(Integer.toString(i));
            softStartBox.getItems().add(Integer.toString(i));
        }

        initInformation();

        hardStartBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (!hardEndBox.getItems().isEmpty()) {
                hardEndBox.getItems().clear();
            }
            for (int startWeek = Integer.parseInt(newValue) + 1; startWeek < 17; ++startWeek) {
                hardEndBox.getItems().add(Integer.toString(startWeek));
            }
        });

        softStartBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (!softEndBox.getItems().isEmpty()) {
                softEndBox.getItems().clear();
            }
            for (int startWeek = Integer.parseInt(newValue) + 1; startWeek < 17; ++startWeek) {
                softEndBox.getItems().add(Integer.toString(startWeek));
            }
        });

        saveBtn.setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.PRIMARY) {
                Boolean isAllMessageFinished = true;
                if (termStartDatePicker.getValue() == null) {
                    datePickerEditor.setUnFocusColor(Color.RED);
                    isAllMessageFinished = false;
                }
                if (hardStartBox.getValue() == null) {
                    hardStartBox.setUnFocusColor(Color.RED);
                    isAllMessageFinished = false;
                }
                if (hardEndBox.getValue() == null) {
                    hardEndBox.setUnFocusColor(Color.RED);
                    isAllMessageFinished = false;
                }
                if (softStartBox.getValue() == null) {
                    softStartBox.setUnFocusColor(Color.RED);
                    isAllMessageFinished = false;
                }
                if (softEndBox.getValue() == null) {
                    softEndBox.setUnFocusColor(Color.RED);
                    isAllMessageFinished = false;
                }
                if (isAllMessageFinished) {
                    Utilities.popMessage("正在更新信息", container);
                    setMessageSession.send();
                }
                else {
                    popupMessage("请检查所有信息!", 1500);
                }
            }
        });

        nameListBtn.setOnMouseClicked(event -> { /*
            if(event.getButton() == MouseButton.PRIMARY) {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("选择文件");
                fileChooser.setInitialDirectory(
                        new File(System.getProperty("user.home"))
                );
                fileChooser.getExtensionFilters().addAll(
                        new FileChooser.ExtensionFilter("XLS", "*.xls"),
                        new FileChooser.ExtensionFilter("XLSX", "*.xlsx"),
                        new FileChooser.ExtensionFilter("CSV", "*.csv")
                );
                Stage stage = (Stage) container.getScene().getWindow();
                File file = fileChooser.showOpenDialog(stage);
                if (file != null) {
                    try {
                        ArrayList<Student> list = new ArrayList<>();
                        if (file.getName().endsWith(".csv")) {
                            String[] fileHeader = {"学号", "姓名", "院系", "理论课", "硬件时间", "软件时间", "硬件成绩", "软件成绩", "试卷成绩", "邮箱", "联系电话", "密码", "补课", "选课时间", "备注"};
                            FileReader reader = new FileReader(file);
                            CSVFormat csvFileFormat = CSVFormat.DEFAULT.withHeader(fileHeader);
                            CSVParser csvFileParser = new CSVParser(reader, csvFileFormat);
                            List<CSVRecord> csvRecords = csvFileParser.getRecords();
                            for (int i = 1; i < csvRecords.size(); i++) {
                                CSVRecord record = csvRecords.get(i);
                                Student student = new Student(record.get("学号"), record.get("姓名"), record.get("院系"), record.get("理论课"), record.get("硬件时间"), record.get("软件时间"),
                                        record.get("硬件成绩"), record.get("软件成绩"), record.get("试卷成绩"), record.get("邮箱"), record.get("联系电话"), record.get("密码"),
                                        record.get("补课"), record.get("选课时间"), record.get("备注"));
                                list.add(student);
                            }
                        } else {
                            FileInputStream is = new FileInputStream(file);
                            Workbook workbook = null;
                            if (file.getName().endsWith(".xls")) {
                                workbook = new HSSFWorkbook(is);
                            } else if (file.getName().endsWith(".xlsx")) {
                                workbook = new XSSFWorkbook(is);
                            }
                            if (workbook != null) {
                                Sheet sheet = workbook.getSheetAt(0);
                                //获取列名位置
                                int firstRowNum = sheet.getFirstRowNum();
                                Row firstRow = sheet.getRow(firstRowNum);
                                int firstCellNumb = firstRow.getFirstCellNum();
                                int lastCellNumb = firstRow.getLastCellNum();
                                ArrayList<Integer> sequence = new ArrayList<>();
                                ArrayList<Integer> cellSequence = new ArrayList<>();
                                for (int cellNum = firstCellNumb; cellNum < lastCellNumb; ++cellNum)
                                    switch (getCellValue(firstRow.getCell(cellNum))) {
                                        case "学号":
                                            sequence.add(0);
                                            cellSequence.add(cellNum);
                                            break;
                                        case "姓名":
                                            sequence.add(1);
                                            cellSequence.add(cellNum);
                                            break;
                                        case "院系":
                                            sequence.add(2);
                                            cellSequence.add(cellNum);
                                            break;
                                        case "理论课":
                                            sequence.add(3);
                                            cellSequence.add(cellNum);
                                            break;
                                        case "硬件时间":
                                            sequence.add(4);
                                            cellSequence.add(cellNum);
                                            break;
                                        case "软件时间":
                                            sequence.add(5);
                                            cellSequence.add(cellNum);
                                            break;
                                        case "硬件成绩":
                                            sequence.add(6);
                                            cellSequence.add(cellNum);
                                            break;
                                        case "软件成绩":
                                            sequence.add(7);
                                            cellSequence.add(cellNum);
                                            break;
                                        case "试卷成绩":
                                            sequence.add(8);
                                            cellSequence.add(cellNum);
                                            break;
                                        case "邮箱":
                                            sequence.add(9);
                                            cellSequence.add(cellNum);
                                            break;
                                        case "联系电话":
                                            sequence.add(10);
                                            cellSequence.add(cellNum);
                                            break;
                                        case "密码":
                                            sequence.add(11);
                                            cellSequence.add(cellNum);
                                            break;
                                        case "补课":
                                            sequence.add(12);
                                            cellSequence.add(cellNum);
                                            break;
                                        case "选课时间":
                                            sequence.add(13);
                                            cellSequence.add(cellNum);
                                            break;
                                        case "备注":
                                            sequence.add(14);
                                            cellSequence.add(cellNum);
                                            break;
                                        default:
                                            break;
                                    }
                                int lastRowNum = sheet.getLastRowNum();
                                for (int rowNum = firstRowNum + 1; rowNum <= lastRowNum; ++rowNum) {
                                    Row row = sheet.getRow(rowNum);
                                    if (row == null) {
                                        continue;
                                    }
                                    String[] cells = new String[row.getLastCellNum()];
                                    //循环当前行的每一小格
                                    for (int i = 0; i < 15; ++i)
                                        cells[i] = getCellValue(row.getCell(cellSequence.get(i)));
                                    Student studentRow = new Student();
                                    for (int i = 0; i < sequence.size(); ++i) {
                                        switch (sequence.get(i)) {
                                            case 0:
                                                studentRow.setNumber(cells[i]);
                                                break;
                                            case 1:
                                                studentRow.setName(cells[i]);
                                                break;
                                            case 2:
                                                studentRow.setCollege(cells[i]);
                                                break;
                                            case 3:
                                                studentRow.setTheoryClass(cells[i]);
                                                break;
                                            case 4:
                                                studentRow.setHardTime(cells[i]);
                                                break;
                                            case 5:
                                                studentRow.setSoftTime(cells[i]);
                                                break;
                                            case 6:
                                                studentRow.setHardScore(cells[i]);
                                                break;
                                            case 7:
                                                studentRow.setSoftScore(cells[i]);
                                                break;
                                            case 8:
                                                studentRow.setPaperScore(cells[i]);
                                                break;
                                            case 9:
                                                studentRow.setEmail(cells[i]);
                                                break;
                                            case 10:
                                                studentRow.setTel(cells[i]);
                                                break;
                                            case 11:
                                                studentRow.setPwd(cells[i]);
                                                break;
                                            case 12:
                                                studentRow.setMakeUpLessons(cells[i]);
                                                break;
                                            case 13:
                                                studentRow.setCourseSelectionTime(cells[i]);
                                                break;
                                            case 14:
                                                studentRow.setRemark(cells[i]);
                                                break;
                                            default:
                                                break;
                                        }
                                    }
                                    list.add(studentRow);
                                }
                            } else {
                                Utilities.popMessage("工作簿为空！", container);
                            }
                            is.close();
                            workbook.close();
                        }
                        DatabaseOperations.getInstance().leadingInStudentNameList(list);
                        Utilities.popMessage("表单已导入", container);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }*/
        });

        termStartDatePicker.setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.PRIMARY) {
                datePickerEditor.setUnFocusColor(unfocusedColor);
            }
        });

        datePickerEditor.setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.PRIMARY) {
                datePickerEditor.setUnFocusColor(unfocusedColor);
            }
        });

        hardStartBox.setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.PRIMARY) {
                hardStartBox.setUnFocusColor(unfocusedColor);
            }
        });

        hardEndBox.setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.PRIMARY) {
                hardEndBox.setUnFocusColor(unfocusedColor);
            }
        });

        softStartBox.setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.PRIMARY) {
                softStartBox.setUnFocusColor(unfocusedColor);
            }
        });

        softEndBox.setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.PRIMARY) {
                softEndBox.setUnFocusColor(unfocusedColor);
            }
        });

        finishLoading();
    }
}
