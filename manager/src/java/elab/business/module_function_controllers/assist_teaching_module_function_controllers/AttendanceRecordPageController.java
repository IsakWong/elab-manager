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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseButton;

public class AttendanceRecordPageController extends BaseFunctionContentController {

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
                                   teachingList.addAll(nameList);
                                   assistChooseList.addAll(nameList);
                                   primaryComboBox.setItems(teachingList);
                                   secondaryComboBox.setItems(assistChooseList);
                                   primaryComboBox.showingProperty();
                                   finishLoading();
                               }

                               @Override
                               public void onError(Throwable throwable) {
                               }

                               @Override
                               public void onComplete() {
                               }
                           }
                );

        primaryInputField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (teachingList.size() != 0) {
                teachingList.clear();
            }
            if (primaryInputField.getText().equals("")) {
                teachingList.addAll(nameList);
            } else {
                for (int i = 0; i < nameList.size(); ++i) {
                    if (Utilities.getPinyinString(nameList.get(i)).startsWith(primaryInputField.getText())
                            || Utilities.getFirstLettersLo(nameList.get(i)).startsWith(primaryInputField.getText())
                            || nameList.get(i).startsWith(primaryInputField.getText())
                            || Utilities.getFirstLettersUp(nameList.get(i)).startsWith(primaryInputField.getText())) {
                        teachingList.add(nameList.get(i));
                        if (assistList.size() != 0) {
                            teachingList.removeAll(assistList);
                        }
                    }
                }
            }
        });

        secondaryInputField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (assistChooseList.size() != 0) {
                assistChooseList.clear();
            }
            if (secondaryInputField.getText().equals("")) {
                assistChooseList.addAll(nameList);
                if (primaryComboBox.getValue() != null && assistChooseList.contains(primaryComboBox.getValue())) {
                    assistChooseList.remove(primaryComboBox.getValue());
                }
            } else {
                for (String aNameList : nameList) {
                    if (Utilities.getPinyinString(aNameList).startsWith(secondaryInputField.getText())
                            || Utilities.getFirstLettersLo(aNameList).startsWith(secondaryInputField.getText())
                            || aNameList.startsWith(secondaryInputField.getText())
                            || Utilities.getFirstLettersUp(aNameList).startsWith(secondaryInputField.getText())) {
                        assistChooseList.add(aNameList);
                        if (primaryComboBox.getValue() != null) {
                            if (assistChooseList.contains(primaryComboBox.getValue())) {
                                assistChooseList.remove(primaryComboBox.getValue());
                            }
                        }
                        if (assistList.size() != 0) {
                            assistChooseList.removeAll(assistList);
                        }
                    }
                }
            }
        });

        primaryComboBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue != null) {
                if (assistChooseList.contains(newValue)) {
                    assistChooseList.remove(newValue);
                }
                if (oldValue != null) {
                    if (!assistChooseList.contains(oldValue)) {
                        assistChooseList.add((String)oldValue);
                    }
                }
            }
            if (oldValue != null && !assistChooseList.contains(oldValue)) {
                assistChooseList.add((String) oldValue);
            }
        });

        secondaryComboBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue != null) {
                if (teachingList.contains(newValue)) {
                    teachingList.remove(newValue);
                }
                if (!assistList.contains(newValue)) {
                    assistList.add((String) newValue);
                }
            }
            if (oldValue != null && !teachingList.contains(oldValue)) {
                teachingList.add((String) oldValue);
            }
        });

        assistListView.setOnMouseClicked(event -> {
            if(event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 2) {
                String selectedItem = assistListView.getSelectionModel().getSelectedItem();
                if(selectedItem != null) {
                    assistList.remove(selectedItem);
                    if (Utilities.getPinyinString(selectedItem).startsWith(secondaryInputField.getText())
                            || Utilities.getFirstLettersLo(selectedItem).startsWith(secondaryInputField.getText())
                            || selectedItem.startsWith(secondaryInputField.getText())
                            || Utilities.getFirstLettersUp(selectedItem).startsWith(secondaryInputField.getText())) {
                        assistChooseList.add(selectedItem);
                    }
                    if (Utilities.getPinyinString(selectedItem).startsWith(primaryInputField.getText())
                            || Utilities.getFirstLettersLo(selectedItem).startsWith(primaryInputField.getText())
                            || selectedItem.startsWith(primaryInputField.getText())
                            || Utilities.getFirstLettersUp(selectedItem).startsWith(primaryInputField.getText())) {
                        teachingList.add(selectedItem);
                    }
                }
            }
        });
/*
        assistList.addListener((ListChangeListener<String>) c -> {
            while(c.next()) {
                if (c.wasAdded()) {
                    assistChooseList.remove(c.getAddedSubList());
                }
            }
        });
*/
        saveBtn.setOnMouseClicked(event -> {
            if(event.getButton() == MouseButton.PRIMARY) {
                System.out.println(primaryComboBox.getValue() + "/n" + assistList + "/n" + questionInputArea.getText());
            }
        });

        assistListView.setItems(assistList);
    }
}
