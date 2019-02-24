package elab.business.module_function_controllers.assist_teaching_module_function_controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.VBox;

public class AttendanceRecordPageController extends BaseFunctionContentController {

    @FXML
    private VBox container;
    @FXML
    private JFXComboBox comboBox;
    @FXML
    private DatePicker datePicker;
    @FXML
    private JFXTextField inputField;
    @FXML
    private ListView<String> assistListView;
    @FXML
    private TextArea questionInputArea;
    @FXML
    private JFXButton saveBtn;

    private ObservableList<String> nameList = FXCollections.<String>observableArrayList();
    private ObservableList<String> chooseList = FXCollections.<String>observableArrayList();
    private ObservableList<String> teachingList = FXCollections.<String>observableArrayList();
    private ObservableList<String> assistList = FXCollections.<String>observableArrayList();

    private void addTeachingListViewItem(String item) {
        if (teachingList.size() == 0) {
            if (!assistList.isEmpty()) {
                for (int i = 0; i < assistList.size(); ++i) {
                    if (assistList.get(i).equals(item)) {
                        Utilities.popMessage("此同学已在助教列表中", container);
                        break;
                    }
                    else if (i == assistList.size() - 1) {
                        teachingList.add(item);
                    }
                }
            }
            else {
                teachingList.add(item);
            }
        }
        else Utilities.popMessage("主讲只能有一位", container);
    }

    private void addAssistListViewItem(String item) {
        if(!teachingList.isEmpty()) {
            if (teachingList.get(0).equals(item)) {
                Utilities.popMessage("此同学已被选为主讲", container);
            }
            else if (assistList.size() == 0) {
                assistList.add(item);
            }
            else {
                for (int i = 0; i < assistList.size(); ++i) {
                    if (assistList.get(i).equals(item)) {
                        Utilities.popMessage("此同学已在助教列表中", container);
                        break;
                    } else if (i == assistList.size() - 1) {
                        assistList.add(item);
                        assistListView.refresh();
                        break;
                    }
                }
            }
        }
        else if (assistList.size() == 0) {
            assistList.add(item);
        }
        else {
            for (int i = 0; i < assistList.size(); ++i) {
                if (assistList.get(i).equals(item)) {
                    Utilities.popMessage("此同学已在助教列表中", container);
                    break;
                } else if (i == assistList.size() - 1) {
                    assistList.add(item);
                    assistListView.refresh();
                    break;
                }
            }
        }
    }

    @Override
    public void initializeController() {
        ObservableList<Member> members = FXCollections.<Member>observableArrayList();
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
                                   comboBox.setItems(nameList);
                                   comboBox.showingProperty();
                               }

                               @Override
                               public void onError(Throwable throwable) {
                               }

                               @Override
                               public void onComplete() {
                               }
                           }
                );

        inputField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (inputField.getText().equals("")) {
                } else {
                    if(chooseList.size() != 0) chooseList.remove(0, chooseList.size());
                    for (int i = 0; i < nameList.size(); ++i)
                        if (Utilities.getPinyinString(nameList.get(i)).startsWith(inputField.getText())
                                || Utilities.getFirstLettersLo(nameList.get(i)).startsWith(inputField.getText())
                                || nameList.get(i).startsWith(inputField.getText())
                                || Utilities.getFirstLettersUp(nameList.get(i)).startsWith(inputField.getText()))
                            chooseList.add(nameList.get(i));
                }
            }
        });

        saveBtn.setOnMouseClicked(event -> {
            if(event.getButton() == MouseButton.PRIMARY) {
                System.out.println(teachingList + "/n" + assistList + "/n" + questionInputArea.getText());
            }
        });
    }
}
