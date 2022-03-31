package project;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import project.modules.Movie;
import project.modules.Screening;
import project.modules.Ticket2;

public class Controller implements Initializable {

    @FXML
    private Button screening1, screening2, screening3, screening4, film1, film2, film3, film4, Ticket;

    @FXML
    private Text title;

    @FXML
    private TextArea ticketText;

    @FXML
    private TextField textInput;

    // For the variable user interface 
    @FXML
    private static String movie, screening, screeningButton, lastPage;

    @FXML
    private static Integer inti; // number of seats from seating.fxml

    @FXML
    private void swapPage(ActionEvent e) throws IOException {
        lastPage = App.getScene();
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
    public void initialize(URL arg0, ResourceBundle arg1) throws NumberFormatException { // Controls variable button names etc.
        switch (App.getScene()) {
            case "Movies":
                List<Movie> movies = Movie.getMovies();
                List<Button> btns = Arrays.asList(film1, film2, film3, film4);

                int i = 0;
                for (Button button : btns) {
                    button.setText(movies.get(i).getTitle());
                    i++;
                }
                break;

            case "Screenings":
                List<Screening> screenings = Movie.getMovie(movie).getScreenings();
                List<Button> btns2 = Arrays.asList(screening1, screening2, screening3, screening4);
                
                int j = 0;
                for (Button button : btns2) { // check if ticket already exists for each screening
                    if (!Ticket2.checkTicket(screenings.get(j).toString(), movie))
                        button.setDisable(true);
                    
                    button.setText(screenings.get(j).toString());
                    j++;
                }
                title.setText(movie);
                break;

            case "Seating":
                title.setText(movie);
                textInput.setOnAction(new EventHandler<ActionEvent>() { // on Enter pressed

                    @Override
                    public void handle(ActionEvent arg0) {
                        try {
                            if (!Double.isNaN(Integer.parseInt(textInput.getText()))) { // check if value is a number
                                if (getScreening().getSeats().size() > Integer.parseInt(textInput.getText())) { // check if there are enough seats
                                    Ticket.setDisable(false); // enables ticket page if it's feasible 
                                    inti = Integer.parseInt(textInput.getText());
                                    Ticket.setText("See ticket");
                                }
                                else {
                                    Ticket.setText("Not enough available seats");
                                    Ticket.setDisable(true);
                                }
                            }
                        }
                        catch (Exception e) { Ticket.setDisable(true); }
                    }
                });
                break;

            case "Ticket":
                if (!lastPage.equals("Movies")) {  // only create a new ticket if a new one is made, cheeky
                     try {
                        new Ticket2(Movie.getMovie(movie), getScreening(), inti, false);
                    } catch (IOException e) { e.printStackTrace(); }
                }
                ticketText.setText(Ticket2.getTickets().toString());
                break;
        }
    }

    private Screening getScreening() { // cleaner 
        return Movie.getMovie(movie).getScreenings()
                            .get(Integer
                            .parseInt(screeningButton
                            .split("(?<=\\D)(?=\\d)")[1]
                            .toString())-1);
    }
}
