package project.modules;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Ticket {
    private String firstName;
    private String lastName;
    private Screening screening;
    private List<String> seating = new ArrayList<>();
    
    public Ticket(String name, Movie movie, Screening screening, int seats) {
        
        setScreening(screening);
        setSeating(seats);

        try (PrintWriter txt = new PrintWriter("/Users/timonselnes/Desktop/TDT4100-Project/src/main/resources/textfiles/tickets.txt")) {
            txt.println(name+";"+movie+";"+screening.getTime()+";"+getSeats());
        } catch (FileNotFoundException e) { e.printStackTrace(); }
    }

    public void setName(boolean a, String name) {
        if (name != null && !name.equals("")) {
            if (a) this.firstName = name;
            else this.lastName = name;
        }
        else throw new IllegalArgumentException("Name can not be null");
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

    @Override
    public String toString() {
        return "Ticket: "  + this.screening.getMovie() + " at " + getScreening() + ", Seats: " + getSeats();
    }
}
