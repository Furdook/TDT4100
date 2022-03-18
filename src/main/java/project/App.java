package project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import project.modules.Cinema;

import java.io.IOException;

public class App extends Application {

    private static Scene scene;
    private static String sceneName;

    @Override
    public void start(Stage stage) throws IOException {
        Cinema.Go(); // Runs to create objects used in app

        scene = new Scene(loadFXML("Movies"));

        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Cinema Tickets");
        stage.show();
    }

    public static void changeScene(String file) throws IOException { // Call to change stage scene, useful for multipage applications (Boilerplate)
        scene.setRoot(loadFXML(file));
    } 

    private static Parent loadFXML(String file) throws IOException { // Seperate to allow changing scenes with a call (Boilerplate)
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(file + ".fxml"));
        sceneName = file;
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

    public static String getScene() {
        if (sceneName != null) return sceneName;
        else return "Null";
    }
}