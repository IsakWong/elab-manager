package elab.business.module_function_controllers.assist_teaching_module_function_controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import elab.application.BaseFunctionContentController;
import elab.database.DatabaseOperations;
import elab.serialization.beans.member.Member;
import elab.util.Utilities;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.rxjavafx.schedulers.JavaFxScheduler;
import io.reactivex.schedulers.Schedulers;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.VBox;

public class AttendanceRecordPageController extends BaseFunctionContentController {

    @FXML
    private VBox container;
    @FXML
    private JFXComboBox primaryComboBox;
    @FXML
    private JFXComboBox secondaryComboBox;
    @FXML
    private JFXDatePicker datePicker;
    @FXML
    private JFXTextField primaryInputField;
    @FXML
    private JFXTextField secondaryInputField;
    @FXML
    private ListView<String> assistListView;
    @FXML
    private TextArea questionInputArea;
    @FXML
    private JFXButton saveBtn;

    private ObservableList<String> nameList = FXCollections.observableArrayList();
    private ObservableList<String> teachingList = FXCollections.observableArrayList();
    private ObservableList<String> assistChooseList = FXCollections.observableArrayList();
    private ObservableList<String> assistList = FXCollections.observableArrayList();

    @Override
    public void initializeController() {
        ObservableList<Member> members = FXCollections.observableArrayList();
        ObservableOnSubscribe<Boolean> ob = new ObservableOnSubscribe<Boolean>() {

            @Override
            public void subscribe(ObservableEmitter<Boolean> observableEmitter) throws Exception {
                members.addAll(DatabaseOperations.getInstance().selectInSchoolMembers());
                observableEmitter.onNext(true);
            }
        };

        Observable.create(ob)
                .subscribeOn(Schedulers.io())
                .observeOn(JavaFxScheduler.platform())
                .subscribe(new Observer<Boolean>() {
                               @Override
                               public void onSubscribe(Disposable disposable) {
                               }

                               @Override
                               public void onNext(Boolean s) {
                                   ParentModuleController.finishLoading();
                                   for(int i = 0; i < members.size(); ++i) {
                                       nameList.add(members.get(i).getName());
                                   }
                                   finishLoading();
                                   primaryComboBox.setItems(nameList);
                                   secondaryComboBox.setItems(nameList);
                                   primaryComboBox.showingProperty();
                               }

                               @Override
                               public void onError(Throwable throwable) {
                               }

                               @Override
                               public void onComplete() {
                               }
                           }
                );

        primaryInputField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(primaryInputField.getText().equals("")) {
                    primaryComboBox.setItems(nameList);
                } else {
                    if(teachingList.size() != 0) teachingList.clear();
                    for (int i = 0; i < nameList.size(); ++i)
                        if (Utilities.getPinyinString(nameList.get(i)).startsWith(primaryInputField.getText())
                                || Utilities.getFirstLettersLo(nameList.get(i)).startsWith(primaryInputField.getText())
                                || nameList.get(i).startsWith(primaryInputField.getText())
                                || Utilities.getFirstLettersUp(nameList.get(i)).startsWith(primaryInputField.getText())) {
                            teachingList.add(nameList.get(i));
                            if(assistList.size() != 0)
                                for(int j = 0; j < assistList.size(); j++)
                                    if(teachingList.contains(assistList.get(j)))
                                        teachingList.remove(assistList.get(j));
                        }
                    primaryComboBox.setItems(teachingList);
                }
            }
        });

        secondaryInputField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(secondaryInputField.getText().equals("")) {
                    if(primaryComboBox.getValue() == null)
                        secondaryComboBox.setItems(nameList);
                    else {
                        for(int i = 0; i < nameList.size(); ++i)
                            assistChooseList.add(nameList.get(i));
                        if(assistChooseList.contains(primaryComboBox.getValue()))
                            assistChooseList.remove(primaryComboBox.getValue());
                    }
                } else {
                    if(assistChooseList.size() != 0) assistChooseList.clear();
                    for (int i = 0; i < nameList.size(); ++i)
                        if (Utilities.getPinyinString(nameList.get(i)).startsWith(secondaryInputField.getText())
                                || Utilities.getFirstLettersLo(nameList.get(i)).startsWith(secondaryInputField.getText())
                                || nameList.get(i).startsWith(secondaryInputField.getText())
                                || Utilities.getFirstLettersUp(nameList.get(i)).startsWith(secondaryInputField.getText())) {
                            assistChooseList.add(nameList.get(i));
                            if(primaryComboBox.getValue() != null)
                                if(assistChooseList.contains(primaryComboBox.getValue()))
                                    assistChooseList.remove(primaryComboBox.getValue());
                            else if(assistList.size() != 0)
                                for(int j = 0; j < assistList.size(); ++j)
                                    if(assistChooseList.contains(assistList.get(j)))
                                        assistChooseList.remove(assistList.get(j));
                        }
                    secondaryComboBox.setItems(assistChooseList);
                }
            }
        });

        primaryComboBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if(assistChooseList.contains(newValue))
                assistChooseList.remove(newValue);
        });

        secondaryComboBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if(teachingList.contains(newValue))
                teachingList.remove(newValue);
            //if(assistChooseList.contains(newValue))
            //    assistChooseList.remove(newValue);
            assistList.add((String)newValue);
            assistListView.setItems(assistList);
        });

        assistListView.setOnMouseClicked(event -> {
            if(event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 2) {
                String selectedItem = assistListView.getSelectionModel().getSelectedItem();
                assistList.remove(selectedItem);
            }
        });

        saveBtn.setOnMouseClicked(event -> {
            if(event.getButton() == MouseButton.PRIMARY) {
                System.out.println(primaryComboBox.getValue() + "/n" + assistList + "/n" + questionInputArea.getText());
            }
        });
    }
}
