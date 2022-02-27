package project.modules;

import java.util.ArrayList;
import java.util.List;

public class Screening { // Remember to remove screening when theatre is full !!!
    public List<String> seating = new ArrayList<>();
    private Movie movie;
    private Theatre theatre;

    public Screening(Movie movie, int start, Theatre theatre) {
        this.seating = theatre.getSeatList();

        theatre.setTaken(start, movie.getLength());

        this.theatre = theatre;
        this.movie = movie;
    }

    public void removeSeat(int amount) {
        for (int i = 0; i < amount; i++) {
            this.seating.remove(i);
        }
    }

    public List<String> getSeats() { 
        return this.seating;
    }

    public Movie getMovie() {
        return this.movie;
    }

    @Override
    public String toString() {
        return this.movie.getTitle() + " , in theatre " + this.theatre.getName();
    }
}
