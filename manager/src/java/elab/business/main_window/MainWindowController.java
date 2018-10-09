package elab.business.main_window;

import com.google.gson.Gson;
import com.jfoenix.controls.JFXTabPane;
import elab.business.module_tab.ModuleTabController;
import elab.serialization.module.Module;
import elab.utility.Utilities;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Tab;

import java.net.URL;
import java.util.ResourceBundle;


public class MainWindowController implements Initializable {

    @FXML
    private JFXTabPane tabPane;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {

            Tab userTab = new Tab();
            userTab.setText("成员管理");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/module_tab.fxml"));
            Parent root = loader.load();
            userTab.setContent(root);
            ModuleTabController controller = loader.getController();

            Gson gson = new Gson();
            String moduleJson = Utilities.loadStringFromStream(getClass().getResourceAsStream("/modules_settings/manager_modules.json"));
            Module module = gson.fromJson(moduleJson, Module.class);
            controller.TabModule = module;

            Observable<String> observable = Observable.create(new ObservableOnSubscribe<String>() {
                @Override
                public void subscribe(ObservableEmitter<String> observableEmitter) throws Exception {

                }
            });
            observable.subscribeOn(Schedulers.io()).observeOn(Schedulers.trampoline()).subscribe();

            tabPane.getTabs().add(userTab);

            Tab tab2 = new Tab();
            tab2.setText("助课管理");
            Parent root2 = FXMLLoader.load(getClass().getResource("/module_tab.fxml"));
            tab2.setContent(root2);
            tabPane.getTabs().add(tab2);


        } catch (Exception exp) {
            System.out.print(exp.toString());
        }
    }
}
