package elab.application;

public abstract class BaseViewController {

    public abstract void initializeController();
    //用来标记数据是否初始化，FXML界面初始化后，可能会从网络，本地硬盘拉取数据，
    //如果为false，会进入Loading提示界面，在拉取后记着标记为true
    public boolean IsDataInitialized = false;

}
