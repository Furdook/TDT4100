package project;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Controller {

    @FXML
    private void swapPage(ActionEvent e) throws IOException {
        Button button = (Button) e.getSource();
        App.changeScene(button.getId());
    }

    @FXML
    private void pickMovie(ActionEvent e) throws IOException {
        Button button = (Button) e.getSource();
        switch (button.getId()) {
            case "film1":
                break;
            case "film2":
                break;
            case "film3":
                break;
            case "film4":
                break;
        }
        App.changeScene("Screenings");
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
}
