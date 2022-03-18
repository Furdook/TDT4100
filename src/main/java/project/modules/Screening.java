package project.modules;

import java.util.ArrayList;
import java.util.List;

public class Screening { // Remember to remove screening when theatre is full !!!
    private List<String> seating = new ArrayList<>();
    private List<String> temp = new ArrayList<>();
    private String time;
    private Movie movie;
    private Theatre theatre;

    public Screening(Movie movie, int start, Theatre theatre) {
        this.seating = theatre.getSeatList();

        theatre.setTaken(start, movie.getLength());
        setTime(start, movie.getLength());

        this.theatre = theatre;
        this.movie = movie;

        movie.setScreenings(this); // maybe
    }

    public void setTime(int start, int length) {
        start *= 15;
        int hour = (start/60)+12;
        int min = start%60;

        length *= 15;
        length = start+length;
        int hour2 = (length/60)+12;
        int min2 = length%60;

        this.time = String.format("%d:%02d", hour, min) + " - " + String.format("%d:%02d", hour2, min2);
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

    public Theatre getTheatre() {
        return this.theatre;
    }

    private String getTime() {
        return this.time;
    }

    @Override
    public String toString() {
        return getTime() + "\n i " + getTheatre().getName();
    }
}
