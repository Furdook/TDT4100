package project;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class Controller implements Initializable {
    @FXML
    private Button screening1, screening2, screening3, screening4;

    @FXML
    private Button film1, film2, film3, film4;

    @FXML
    private Text title;

    // For the variable user interface 
    @FXML
    private static String movie, screening;

    @FXML
    private void swapPage(ActionEvent e) throws IOException {
        Button button = (Button) e.getSource();
        App.changeScene(button.getId());
    }

    @FXML
    private void pickMovie(ActionEvent e) throws IOException {
        Button button = (Button) e.getSource();
        movie = button.getId();
        System.out.println("TEST" + movie);
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
                film1.setText("Test 1");
                film2.setText("Test 2");
                film3.setText("Test 3");
                film4.setText("Test 4");
                break;
            case "Screenings":
                title.setText("TEST");
                screening1.setText(movie); //Adding getscreenings from chosen movie later
                screening2.setText(movie);
                screening3.setText(movie);
                screening4.setText(movie);
                break;
            case "Seating":
                title.setText("TEST");
                break;
        }
    }
}
