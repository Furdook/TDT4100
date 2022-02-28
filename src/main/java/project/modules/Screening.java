package project.modules;

import java.util.ArrayList;
import java.util.List;

public class Screening { // Remember to remove screening when theatre is full !!!
    private List<String> seating = new ArrayList<>();
    private List<String> temp = new ArrayList<>();
    private Movie movie;
    private Theatre theatre;

    public Screening(Movie movie, int start, Theatre theatre) {
        this.seating = theatre.getSeatList();

        theatre.setTaken(start, movie.getLength());

        this.theatre = theatre;
        this.movie = movie;
    }

    public List<String> setSeats(int a) {
        this.temp.addAll(this.seating.subList(0, a));
        this.seating.subList(0, a).clear();
        return this.temp;
    }

    public List<String> getSeats() { 
        return this.seating;
    }

    public Movie getMovie() {
        return this.movie;
    }

    @Override
    public String toString() {
        return this.movie.getTitle() + ", in theatre " + this.theatre.getName();
    }
}
