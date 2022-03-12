package project;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class Controller implements Initializable {
    @FXML
    private Button screening1, screening2, screening3, screening4;

    // For the variable user interface 
    @FXML
    private String movie, screening;

    @FXML
    private void swapPage(ActionEvent e) throws IOException {
        Button button = (Button) e.getSource();
        App.changeScene(button.getId());
    }

    @FXML
    private void pickMovie(ActionEvent e) throws IOException {
        Button button = (Button) e.getSource();
        movie = button.getId();
        App.changeScene("Screenings");
    }

    @FXML
    private void pickScreening(ActionEvent e) throws IOException {
        Button button = (Button) e.getSource();
        screening = button.getId();
        App.changeScene("Seating");
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) { // Controls variable button names etc.
        switch (App.getScene()) {
            case "Movies":
                break;
            case "Screenings":
                screening1.setText("Screening 1"); //Adding getscreenings from chosen movie later
                screening2.setText("Screening 2");
                screening3.setText("Screening 3");
                screening4.setText("Screening 4");
                break;
        }
    }
}
