package elab.application;

import elab.business.log_in_window.LoginWindowController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.Properties;

public class ElabManagerApplication extends Application {

    public final Logger logger = Logger.getLogger(ElabManagerApplication.class);

    public static Properties properties;
    public static Stage primaryStage;


    @Override
    public void stop() throws Exception {
        flushProperty();
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        loadPropertyFile();

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

    public void loadPropertyFile() {
        try {
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
            stream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String strWidth = properties.getProperty("WINDOW_WIDTH");
        String strHeight = properties.getProperty("WINDOW_HEIGHT");

    }

    public void flushProperty() {
        try {
            File propertyFile = new File("settings.property");
            FileOutputStream out = new FileOutputStream(propertyFile);
            properties.store(out, "AUTO_LOG");
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        launch(args);
    }
}
