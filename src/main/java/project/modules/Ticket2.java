package project.modules;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Ticket2 {
    private String firstName;
    private String lastName;
    private Screening screening;
    private List<String> seating = new ArrayList<>();
    private static String[] test2;
    private static List<Ticket2> tickets = new ArrayList<>();
    
    public Ticket2(Movie movie, Screening screening, int seats, boolean exists) {
        if (checkTicket(screening.toString())) {

            setScreening(screening);
            setSeating(seats);
            
            try (PrintWriter txt = new PrintWriter("/Users/timonselnes/Desktop/TDT4100-Project/src/main/resources/textfiles/tickets.txt")) {
                txt.println(movie.getTitle()+";"+screening.getTime()+";"+getSeats());
            } catch (FileNotFoundException e) { e.printStackTrace(); }

            tickets.add(this);
        }
        else throw new IllegalArgumentException("Ticket already exists");
    }

    public static Boolean checkTicket(String input) {
        if (!tickets.stream().anyMatch(p -> p.getScreening().equals(input))) return true;
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

    public String getName() {
        return this.firstName + " " + this.lastName;
    }

    public String getScreening() {
        return this.screening.toString();
    }

    public List<String> getSeats() {
        return this.seating;
    }

    public static void loadTickets() {
        try {
            Scanner cinema = new Scanner(new File("/Users/timonselnes/Desktop/TDT4100-Project/src/main/resources/textfiles/tickets.txt"));
            cinema.useDelimiter("\n");

            while (cinema.hasNext()) {
                String string = cinema.next();
                test2 = string.split(";");

                if (test2.length > 2) { // required to prevent out of bounds error on Array
                    Movie movie = Movie.getMovie(test2[0]);
                    List<String> seats = new ArrayList<>(Arrays.asList(test2[2].split(",")));

                    new Ticket2(movie, Screening.findScreening(movie, test2[1]), seats.size(), true);
                }
            }
            cinema.close();
        } catch (Exception e) { e.printStackTrace(); }
    }

    public static List<Ticket2> getTickets() {
        return tickets;
    }

    @Override
    public String toString() {
        return (this.screening.getMovie().getTitle() + "\n" + getScreening() + "\n" + getSeats() + "\n\n").replaceAll("\\]\\[\\,", "");
    }
}
