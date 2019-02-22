package elab.serialization.module;

import com.google.gson.annotations.SerializedName;
import elab.application.BaseFunctionContentController;
import javafx.scene.Parent;

public class Function {
    @SerializedName("function_name")
    public String FunctionName;
    @SerializedName("function_fxml")
    public String FunctionFXML;

    public transient Module ParentModule;

    public transient Parent FxmlRoot = null;
    public transient BaseFunctionContentController Controller = null;
    public transient boolean IsFxmlInitialized = false;
}
