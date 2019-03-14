package elab.business.module_function_controllers.register_module_function_controllers;

import com.jfoenix.controls.JFXButton;
import elab.application.BaseFunctionContentController;
import elab.application.BaseViewController;
import elab.database.DatabaseOperations;
import elab.serialization.beans.Rota;
import elab.util.Utilities;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class RotaPageController extends BaseFunctionContentController {

    @FXML
    private JFXButton rotaFileIn;
    @FXML
    private AnchorPane container;
    @FXML
    private TableView tableView;
    @FXML
    private TableColumn number;
    @FXML
    private TableColumn name;
    @FXML
    private TableColumn group;
    @FXML
    private TableColumn time;
    @FXML
    private TableColumn week;
    @FXML
    private TableColumn day;

    public String getCellValue(Cell cell){
        String cellValue = "";
        if(cell == null){
            return cellValue;
        }
        //把数字当成String来读，避免出现1读成1.0的情况
        if(cell.getCellType() == CellType.NUMERIC){
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

    public void chooseFileIn(){
        Object[] options = {"确定", "取消"};
        int m = JOptionPane.showOptionDialog(null, "新表单将覆盖已有表单，是否继续？", "Attention",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        if(m == 0) {


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
                    ArrayList<Rota> list = new ArrayList<>();
                    if(file.getName().endsWith(".csv")) {
                        String [] fileHeader = {"学号", "姓名", "组别", "时段", "单双周", "星期"};
                        FileReader reader = new FileReader(file);
                        CSVFormat csvFileFormat = CSVFormat.DEFAULT.withHeader(fileHeader);
                        CSVParser csvFileParser = new CSVParser(reader, csvFileFormat);
                        List<CSVRecord> csvRecords = csvFileParser.getRecords();
                        for (int i = 1; i < csvRecords.size(); i++) {
                            CSVRecord record = csvRecords.get(i);
                            Rota rota = new Rota(record.get("学号"), record.get("姓名"), record.get("组别"), record.get("时段"), record.get("单双周"), record.get("星期"));
                            list.add(rota);
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
                                    case "组别":
                                        sequence.add(2);
                                        cellSequence.add(cellNum);
                                        break;
                                    case "时段":
                                        sequence.add(3);
                                        cellSequence.add(cellNum);
                                        break;
                                    case "单双周":
                                        sequence.add(4);
                                        cellSequence.add(cellNum);
                                        break;
                                    case "星期":
                                        sequence.add(5);
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
                                for (int i = 0; i < 6; ++i)
                                    cells[i] = getCellValue(row.getCell(cellSequence.get(i)));
                                Rota rotaRow = new Rota();
                                for(int i = 0; i < sequence.size(); ++i) {
                                    switch (sequence.get(i)) {
                                        case 0:
                                            rotaRow.setNumber(cells[i]);
                                            break;
                                        case 1:
                                            rotaRow.setName(cells[i]);
                                            break;
                                        case 2:
                                            rotaRow.setGroup(cells[i]);
                                            break;
                                        case 3:
                                            rotaRow.setTime(cells[i]);
                                            break;
                                        case 4:
                                            rotaRow.setWeek(cells[i]);
                                            break;
                                        case 5:
                                            rotaRow.setDay(cells[i]);
                                            break;
                                        default:
                                            break;
                                    }
                                }
                                list.add(rotaRow);
                            }
                        } else {
                            Utilities.popMessage("工作簿为空！", container);
                        }
                        is.close();
                        workbook.close();
                    }
                    DatabaseOperations.getInstance().leadingInRota(list);
                    ObservableList<Rota> rotas = FXCollections.observableArrayList();
                    rotas.addAll(list);
                    tableView.setItems(rotas);
                    tableView.refresh();
                    Utilities.popMessage("表单已导入", container);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void initializeController() {

        number.setCellValueFactory(new PropertyValueFactory<String, Rota>("number"));
        name.setCellValueFactory(new PropertyValueFactory<String, Rota>("name"));
        group.setCellValueFactory(new PropertyValueFactory<String, Rota>("group"));
        time.setCellValueFactory(new PropertyValueFactory<String, Rota>("time"));
        week.setCellValueFactory(new PropertyValueFactory<String, Rota>("week"));
        day.setCellValueFactory(new PropertyValueFactory<String, Rota>("day"));

        ObservableList<Rota> rota = FXCollections.observableArrayList();
        rota.addAll(DatabaseOperations.getInstance().selectRota());
        tableView.setItems(rota);

        rotaFileIn.setOnMouseClicked(event -> {
            if(event.getButton() == MouseButton.PRIMARY) {
                chooseFileIn();
            }
        });
    }
}
