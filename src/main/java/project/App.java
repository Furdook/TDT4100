package project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("Movies"));

        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Cinema!");
        stage.show();
    }

    public static void changeScene(String file) throws IOException { // Call to change stage scene, useful for multipage applications (Boilerplate)
        scene.setRoot(loadFXML(file));
    } 

    private static Parent loadFXML(String file) throws IOException { // Seperate to allow changing scenes with a call (Boilerplate)
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(file + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }
}