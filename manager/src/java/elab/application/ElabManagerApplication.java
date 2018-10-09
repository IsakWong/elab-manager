package elab.application;

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
    ;
    public static Properties properties;
    public static Stage primaryStage;


    @Override
    public void start(Stage primaryStage) throws Exception {
        checkPropertyFile();

        /*
        SqlSession session = factory.openSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        Student s = new Student();
        s.name = "123";
        mapper.addStudent(s);
        Student s2 = mapper.selectStudent(3);
        session.commit();
        */

        ElabManagerApplication.primaryStage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("/login_window.fxml"));
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

    }

    public static void main(String[] args) {
        launch(args);
    }
}
