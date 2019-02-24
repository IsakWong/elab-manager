package elab.application;

import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXListView;
import elab.application.BaseViewController;
import elab.serialization.module.Function;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class BaseModulePageController extends BaseViewController {

    @FXML
    public JFXListView list;
    @FXML
    public StackPane container;

    private JFXDialog dialog = null;

    private Function CurrentFunction;

    public ArrayList<Function> loadedFuncs = new ArrayList<Function>();

    public void setCurrentFunction(Function func)
    {
        if(func == CurrentFunction)
            return;
        for (Function f : loadedFuncs) {
            if(f != func)
            {
                f.FxmlRoot.setVisible(false);
            }else
            {
                f.FxmlRoot.setVisible(true);
                double top = 16;
                double right = 16;
            }
        }
        func.FxmlRoot.setVisible(true);
        CurrentFunction = func;
    }
    public void addFunctionContent(Function func)
    {
        if(func == null)
            return;
        else
        {
            loadedFuncs.add(func);
            container.getChildren().add(func.FxmlRoot);
        }
    }

    public void beginLoading()
    {
        if(!CurrentFunction.Controller.IsDataInitialized)
        {
            if(dialog == null)
            {
                try
                {
                    dialog = new JFXDialog();
                    dialog.setOverlayClose(false);
                    FXMLLoader moduleLoader = new FXMLLoader(getClass().getResource("/business_pages/loading_dialog.fxml"));
                    Parent root = moduleLoader.load();
                    VBox box = (VBox) root.lookup("#dialog");
                    dialog.setContent(box);
                }catch (Exception e)
                {
                    e.printStackTrace();
                }

            }
            dialog.show(container);
        }else{
            if(dialog != null)
                dialog.close();
        }

    }
    public void finishLoading()
    {
        if(dialog !=null)
            dialog.close();
    }
    @Override
    public void initializeController() {
    }
}
