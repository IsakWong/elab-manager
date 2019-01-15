package elab.util;

import com.jfoenix.controls.JFXSnackbar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class MessageShower {

    public static void popMessage(String message, AnchorPane container) {
        JFXSnackbar bar = new JFXSnackbar(container);
        JFXSnackbar.SnackbarEvent event = new JFXSnackbar.SnackbarEvent(message);
        bar.enqueue(event);
    }

    public static void popMessage(String message, VBox container) {
        JFXSnackbar bar = new JFXSnackbar(container);
        JFXSnackbar.SnackbarEvent event = new JFXSnackbar.SnackbarEvent(message);
        bar.enqueue(event);
    }
}
