package project;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import project.modules.Movie;
import project.modules.Screening;

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
        movie = button.getText();
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
        List<Movie> temp = Movie.getMovies();
        List<Screening> screenings = Movie.getScreenings();
        switch (App.getScene()) {
            case "Movies":
                film1.setText(temp.get(0).getTitle());
                film2.setText(temp.get(1).getTitle());
                film3.setText(temp.get(2).getTitle());
                film4.setText(temp.get(3).getTitle());
                break;
            case "Screenings":
                title.setText(movie);
                screening1.setText(screenings.get(0).toString()); 
                screening2.setText(screenings.get(1).toString());
                screening3.setText(screenings.get(2).toString());
                screening4.setText(screenings.get(3).toString());
                break;
            case "Seating":
                title.setText("TEST");
                break;
        }
    }
}
