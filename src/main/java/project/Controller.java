package project;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Controller {

    @FXML
    private Button screening1;

    @FXML
    private void swapPage(ActionEvent e) throws IOException {
        Button button = (Button) e.getSource();
        App.changeScene(button.getId());
    }

    @FXML
    private void pickMovie(ActionEvent e) throws IOException {
        App.changeScene("Screenings");
        Button button = (Button) e.getSource();
        selectScreening(button.getId());
    }

    @FXML
    private void pickScreening(ActionEvent e) throws IOException {
        Button button = (Button) e.getSource();
        switch (button.getId()) {
            case "screening1":
                break;
            case "screening2":
                break;
            case "screening3":
                break;
            case "screening4":
                break;
        }
        App.changeScene("Seating");
    }

    @FXML
    private void selectScreening(String a) {
        switch (a) {
            case "film1":
                screening1.setText("test");
                break;
            case "film2":
                
                break;
            case "film3":
                
                break;
            case "film4":
                
                break;
        }
    }
}
