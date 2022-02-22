package project.modules;

import java.util.ArrayList;
import java.util.List;

public class Screening { // Remember to remove screening when theatre is full !!!
    public List<Seats> seating = new ArrayList<>();
    private Movie movie;
    private Theatre theatre;

    public Screening(Movie movie, int start, Theatre theatre) {
        for (Seats seat : theatre.getSeatList()) {
            this.seating.add(seat);
        }

        theatre.setTaken(start, movie.getLength());

        this.theatre = theatre;
        this.movie = movie;
    }

    public void removeSeat(int amount) {
        for (int i = 0; i < amount; i++) {
            this.seating.remove(i);
        }
    }

    public Movie getMovie() {
        return this.movie;
    }

    public List<Seats> getSeats() { 
        return this.seating;
    }

    @Override
    public String toString() {
        return this.movie.getTitle() + " , in theatre " + this.theatre.getName();
    }
}
