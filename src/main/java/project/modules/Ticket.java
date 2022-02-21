package project.modules;

import java.util.List;

public class Ticket {
    private String firstName;
    private String lastName;
    private List<Seats> seats;
    private String seating;
    private Screening screening;
    
    public Ticket(String firstName, String lastName, int seats, Screening screening) {

    }

    public Ticket() {}

    public void setName(boolean a, String name) {
        if (name != null && !name.equals("")) name = a ? this.firstName : this.lastName; 
        else throw new IllegalArgumentException("Name can not be null");
    }

    public void setSeating(int from, int to) {

    }

    public void setScreening(Screening screening) {
        if (screening != null) this.screening = screening;
        else throw new IllegalArgumentException("Screening can not be null");
    }

    public String getName() {
        return this.firstName + " " + this.lastName;
    }

    public String getSeats() {
        for (Seats seat : seats) 
            seating += seat.getID() + ". ";
        return seating;
    }

    public String getScreening() {
        return this.screening.toString();
    }
}
