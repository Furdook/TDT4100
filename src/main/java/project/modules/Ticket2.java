package project.modules;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Ticket2 {
    private String movie;
    private Screening screening;
    private List<String> seating = new ArrayList<>();
    private static String[] stringArray;
    private static List<Ticket2> tickets = new ArrayList<>();
    
    public Ticket2(Movie movie, Screening screening, int seats, boolean exists) throws IOException {
        if (checkTicket(screening.toString(), movie.getTitle())) {

            setScreening(screening);
            setSeating(seats);
            this.movie = movie.getTitle();
            
            if(!exists) {
                try (BufferedWriter txt = new BufferedWriter(new FileWriter("/Users/timonselnes/Desktop/TDT4100-Project/src/main/resources/textfiles/tickets.txt", true))) {
                    txt.write(movie.getTitle()+";"+screening.getTime()+";"+getSeats()+"/");
               } catch (FileNotFoundException e) { e.printStackTrace(); }
            }

            tickets.add(this);
        }
        else throw new IllegalArgumentException("Ticket already exists");
    }

    public static Boolean checkTicket(String input, String movie) {
        if (!tickets.stream().anyMatch(p -> p.getScreening().equals(input) && p.getMovie().equals(movie))) return true;
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

    public static void loadTickets() {
        try {
            Scanner cinema = new Scanner(new File("/Users/timonselnes/Desktop/TDT4100-Project/src/main/resources/textfiles/tickets.txt"));
            cinema.useDelimiter("/");

            while (cinema.hasNext()) {
                String string = cinema.next();
                stringArray = string.split(";");

                if (stringArray.length > 2) { // required to prevent out of bounds error on Array 
                    Movie movie = Movie.getMovie(stringArray[0]);
                    List<String> seats = new ArrayList<>(Arrays.asList(stringArray[2].split(",")));
                    new Ticket2(movie, Screening.findScreening(movie, stringArray[1]), seats.size(), true);
                }
            }
            cinema.close();
        } catch (Exception e) { e.printStackTrace(); }
    }

    public static List<Ticket2> getTickets() {
        return tickets;
    }

    @Override
    public String toString() { // a mess
        String tmp = (this.screening.getMovie().getTitle() + "\n" + this.screening.getTheatre() + ": " + getScreening() + "\n" + getSeats() + "\n\n").replaceAll("\\[", "").replaceAll("\\]", "");
        return tmp.replaceAll("\\]", "").replaceAll("\\[", "");
    }
}
