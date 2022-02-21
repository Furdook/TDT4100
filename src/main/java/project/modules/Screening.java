package project.modules;

import java.util.ArrayList;
import java.util.List;

public class Screening { // Remember to remove screening when theatre is full !!!
    public List<Seats> seating = new ArrayList<>();
    private Movie movie;
    private Theatre theatre;

    public Screening(Movie movie, int start, Theatre theatre) {
        for (Seats seats : theatre.getSeatList()) {
            this.seating.add(seats);
        }
        this.theatre = theatre;
        this.movie = movie;
    }

    public void removeSeat(int from, int to) {
        for (int i = from; i < to; i++) {
            this.seating.remove(i);
        }
    }

    public int getAvailableSeats() {
        return this.seating.size();
    }

    public Movie getMovie() {
        return this.movie;
    }

    @Override
    public String toString() {
        return this.movie.getTitle() + " shwowing for " + this.movie.getScreenTime() + " minutes, in theatre " + this.theatre.getName();
    }
}
