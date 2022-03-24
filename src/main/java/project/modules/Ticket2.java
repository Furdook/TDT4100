package project.modules;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ticket2 {
    private String firstName;
    private String lastName;
    private Screening screening;
    private List<String> seating = new ArrayList<>();
    private static String[] test2;
    private static List<String> screenings = new ArrayList<>();
    
    public Ticket2(Movie movie, Screening screening, int seats) {
        
        setScreening(screening);
        setSeating(seats);

        System.out.println("Creating Ticket");

        try (PrintWriter txt = new PrintWriter("/Users/timonselnes/Desktop/TDT4100-Project/src/main/resources/textfiles/tickets.txt")) {
            txt.println(movie+";"+screening.getTime()+";"+getSeats()+"\n");
        } catch (FileNotFoundException e) { e.printStackTrace(); }

        screenings.add(this.toString());
    }

    public void setScreening(Screening screening) {
        if (screening != null) this.screening = screening;
        else throw new IllegalArgumentException("Screening can not be null");
    }

    public void setSeating(int a) {
        if (this.screening.getSeats().size() > a) this.seating = this.screening.setSeats(a);
        else throw new IllegalArgumentException("Cannot get more seats than there available");

        System.out.println(this.screening.getSeats());
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
        System.out.println("Loading Tickets");
        try {
            Scanner cinema = new Scanner(new File("/Users/timonselnes/Desktop/TDT4100-Project/src/main/resources/textfiles/tickets.txt"));
            cinema.useDelimiter("\n");

            while (cinema.hasNext()) {
                String string = cinema.next();
                test2 = string.split(";");
                System.out.println(test2.toString());
                Movie movie = Movie.getMovie(test2[1]);
                new Ticket2(movie, Cinema.findScreening(movie, test2[2]), test2[3].length());
            }
            cinema.close();
        } catch (Exception e) { e.printStackTrace(); }
    }

    public static String getTickets() {
        return screenings.toString();
    }

    @Override
    public String toString() {
        return this.screening.getMovie() + " at " + getScreening() + ", Seats: " + getSeats();
    }
}
