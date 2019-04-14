package elab.serialization.module;

import com.google.gson.annotations.SerializedName;
import elab.application.BaseModulePageController;
import javafx.scene.Parent;

public class Module {
    @SerializedName("module_name")
    public String ModuleName;
    @SerializedName("module_fxml")
    public String ModuleFxml;
    @SerializedName("functions")
    public Function[] Functions;

    public transient Parent FxmlRoot = null;
    public transient BaseModulePageController Controller;
}
