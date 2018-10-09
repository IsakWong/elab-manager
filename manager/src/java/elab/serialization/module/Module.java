package elab.serialization.module;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import javafx.scene.Parent;
import jdk.nashorn.internal.ir.annotations.Ignore;

public class Module {
    @SerializedName("module_name")
    public String ModuleName;
    @SerializedName("functions")
    public Function[] Functions;}
