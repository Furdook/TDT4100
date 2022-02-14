package project;

import java.io.IOException;
import javafx.fxml.FXML;

public class Controller {
    
    @FXML
    private void click() throws IOException {
        App.changeScene("NEW SCENE");
    }
}
