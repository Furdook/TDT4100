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
import project.modules.Ticket;

public class Controller implements Initializable {
    @FXML
    private Button screening1, screening2, screening3, screening4;

    @FXML
    private Button film1, film2, film3, film4;

    @FXML
    private Text title;

    // For the variable user interface 
    @FXML
    private static String movie, screening, screeningButton;

    @FXML
    private void swapPage(ActionEvent e) throws IOException {
        Button button = (Button) e.getSource();
        App.changeScene(button.getId());
    }

    @FXML
    private void pickMovie(ActionEvent e) throws IOException {
        Button button = (Button) e.getSource();
        movie = button.getText();
        App.changeScene("Screenings");
    }

    @FXML
    private void pickScreening(ActionEvent e) throws IOException {
        Button button = (Button) e.getSource();
        screening = button.getText();
        screeningButton = button.getId();
        App.changeScene("Seating");
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) { // Controls variable button names etc.
        switch (App.getScene()) {
            case "Movies":
                List<Movie> movies = Movie.getMovies();
                film1.setText(movies.get(0).getTitle());
                film2.setText(movies.get(1).getTitle());
                film3.setText(movies.get(2).getTitle());
                film4.setText(movies.get(3).getTitle());
                break;
            case "Screenings":
                List<Screening> screenings = Movie.getMovie(movie).getScreenings();
                title.setText(movie);
                screening1.setText(screenings.get(0).toString()); 
                screening2.setText(screenings.get(1).toString());
                screening3.setText(screenings.get(2).toString());
                screening4.setText(screenings.get(3).toString());
                break;
            case "Seating":
                title.setText(movie);
                break;
            case "Ticket":
                Movie tmp = Movie.getMovie(movie);

                new Ticket("Name", tmp, tmp.getScreenings().get(Integer.parseInt(screeningButton.split("(?<=\\D)(?=\\d)")[1].toString())-1), 46);
        }
    }
}
