package elab.serialization.module;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import javafx.scene.Parent;
import jdk.nashorn.internal.ir.annotations.Ignore;

public class Function {
    @SerializedName("function_name")
    public String FunctionName;
    @SerializedName("function_fxml")
    public String FunctionFXML;

    @Ignore
    Parent Root;
    @Ignore
    boolean IsInit = false;

}
