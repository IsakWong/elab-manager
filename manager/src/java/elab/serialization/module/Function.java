package elab.serialization.module;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import elab.application.BaseViewController;
import javafx.scene.Parent;

public class Function {
    @SerializedName("function_name")
    public String FunctionName;
    @SerializedName("function_fxml")
    public String FunctionFXML;

    public transient Module ParentModule;
    public transient Parent Root = null;
    public transient boolean IsInit = false;
}
