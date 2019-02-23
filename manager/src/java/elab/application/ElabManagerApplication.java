package elab.application;

import elab.business.log_in_window.LoginWindowController;
import elab.serialization.module.Module;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.Properties;

public class ElabManagerApplication extends Application {

    public final Logger logger = Logger.getLogger(ElabManagerApplication.class);

    public static Properties properties;
    public static Stage primaryStage;


    @Override
    public void start(Stage primaryStage) throws Exception {
        checkPropertyFile();

        ElabManagerApplication.primaryStage = primaryStage;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/business_pages/login_window.fxml"));
        Parent root = loader.load();
        LoginWindowController controller = loader.getController();
        controller.initializeController();

        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();

    }

    public void checkPropertyFile() throws Exception {

        File propertyFile = new File("settings.property");
        if (!propertyFile.exists()) {
            InputStream input = getClass().getResourceAsStream("/default_settings.properties");
            FileOutputStream out = new FileOutputStream(propertyFile);
            byte[] temp = new byte[input.available()];
            input.read(temp);
            out.write(temp);
            out.flush();
            out.close();
        }
        FileInputStream stream = new FileInputStream(propertyFile);
        properties = new Properties();
        properties.load(stream);
        String strWidth = properties.getProperty("WINDOW_WIDTH");
        String strHeight = properties.getProperty("WINDOW_HEIGHT");

    }

    public static void main(String[] args) {
        launch(args);
    }
}
