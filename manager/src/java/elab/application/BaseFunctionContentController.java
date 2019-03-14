package elab.application;

import elab.serialization.module.Function;
import elab.util.Utilities;

public class BaseFunctionContentController extends BaseViewController {

    public Function Func;
    public BaseModulePageController ParentModuleController;

    public void popupMessage(String message, long time) {
        Utilities.popMessage(message, ParentModuleController.container, time);
    }

    public void finishLoading() {
        IsDataInitialized = true;
        ParentModuleController.finishLoading();
    }

    public void beginLoading() {ParentModuleController.beginLoading();}

    @Override
    public void initializeController() {   }
}
