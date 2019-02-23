package elab.application;

import com.jfoenix.controls.JFXDialog;
import elab.application.BaseViewController;
import elab.serialization.module.Function;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class BaseModulePageController extends BaseViewController {

    @FXML
    public VBox leftPanel;
    @FXML
    public StackPane container;

    private JFXDialog dialog = null;

    private Function CurrentFunction;

    public void setFunctionContent(Function func)
    {
        if(func == CurrentFunction)
            return;
        else
        {
            CurrentFunction = func;
            container.getChildren().clear();
            container.getChildren().add(func.FxmlRoot);
        }
    }

    public void BeginLoading()
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
        }

    }
    public void FinishLoading()
    {
        if(dialog !=null)
            dialog.close();
    }
    @Override
    public void initializeController() {

    }
}
