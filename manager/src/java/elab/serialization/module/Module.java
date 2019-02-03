package elab.serialization.module;

import com.google.gson.annotations.SerializedName;
import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;

import java.util.ArrayList;
import java.util.List;

public class Module {
    @SerializedName("module_name")
    public String ModuleName;
    @SerializedName("functions")
    public Function[] Functions;

    public transient Parent Root = null;
    public transient ArrayList<ScrollPane> scrollPanes = new ArrayList<>();
}
