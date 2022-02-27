package project.modules;

import java.util.List;

public class Ticket {
    private String firstName;
    private String lastName;
    private List<String> seating;
    private Screening screening;
    
    public Ticket() {}

    public void setName(boolean a, String name) {
        if (name != null && !name.equals("")) {
            if (a) this.firstName = name;
            else this.lastName = name;
        }
        else throw new IllegalArgumentException("Name can not be null");
    }

    public void setSeating(int amount) {
        for (int i = 0; i < amount; i++) {
            
        }
    }

    public void setScreening(Screening screening) {
        if (screening != null) {
            this.screening = screening;
        }
        else throw new IllegalArgumentException("Screening can not be null");
    }

    public String getName() {
        return this.firstName + " " + this.lastName;
    }

    public List<String> getSeats() {
        return this.seating;
    }

    public String getScreening() {
        return this.screening.toString();
    }
}
