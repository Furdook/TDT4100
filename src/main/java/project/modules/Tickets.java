package project.modules;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Tickets {
    private String movie;
    private String name;
    private Screening screening;
    private List<String> seating = new ArrayList<>();
    private static List<Tickets> tickets = new ArrayList<>();
    
    public Tickets(Movie movie, Screening screening, int seats, boolean exist, String name) throws IOException {
        if (checkTicket(screening.toString(), movie.getTitle(), name)) {

            setScreening(screening);
            setSeating(seats);
            this.name = name;
            this.movie = movie.getTitle();

            if (!exist) // For existing tickets in tickets.txt on startup
                IO.callMe(this.movie+";"+screening.getTime()+";"+getSeats()+";"+name+"/");

            tickets.add(this);
        }
        else throw new IllegalArgumentException("Ticket already exists");
    }

    // Checks if ticket already exists in tickets array
    public static Boolean checkTicket(String input, String movie, String name) {
        if (!tickets.stream().anyMatch(p -> p.getScreening().equals(input) && p.getMovie().equals(movie) && p.name.equals(name))) return true;
        else return false;
    }

    public void setScreening(Screening screening) {
        if (screening != null) this.screening = screening;
        else throw new IllegalArgumentException("Screening can not be null");
    }

    public void setSeating(int a) {
        if (this.screening.getSeats().size() > a) this.seating = this.screening.setSeats(a);
        else throw new IllegalArgumentException("Cannot get more seats than there available");
    }

    public String getScreening() {
        return this.screening.toString();
    }

    private String getMovie() {
        return this.movie.toString();
    }

    public List<String> getSeats() {
        return this.seating;
    }

    public static List<Tickets> getTickets() {
        return tickets;
    }

    @Override
    public String toString() { // a mess
        String tmp = (this.name + ": " +this.screening.getMovie().getTitle() + "\n" + this.screening.getTheatre() + ": " + getScreening() + "\n" + getSeats() + "\n\n").replaceAll("\\[", "").replaceAll("\\]", "");
        return tmp.replaceAll("\\]", "").replaceAll("\\[", "");
    }
}
