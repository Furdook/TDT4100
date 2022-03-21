package project.modules;

import java.util.ArrayList;
import java.util.List;

public class Ticket {
    private String firstName;
    private String lastName;
    private Screening screening;
    private List<String> seating = new ArrayList<>();
    
    public Ticket(String name, Movie movie, Screening screening, int seats) {
        
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
        this.seating = this.screening.setSeats(a);
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
}
