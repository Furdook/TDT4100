package project.modules;

import java.util.ArrayList;
import java.util.List;

public class Theatre {
    private List<Seats> seats = new ArrayList<>();
    private List<Integer> time = new ArrayList<>();
    private String theatreName;

    public Theatre(String name, int size) {
        if (name != null) this.theatreName = name;
        else throw new IllegalArgumentException("Theatre name can not be null");

        if (size > 0) // Adds the set amount of seats to current theatre
            for (int i = 0; i < size; i++) 
                this.seats.add(new Seats(i));
        else throw new IllegalArgumentException("Theatre can not have zero or fewer seats");
        for (int i = 0; i < Cinema.getOPEN(); i++) this.time.add(i); // Creates timeArray used for timing screenings in said theatre
    }

    public void setTaken(int start, int length) {
        if (getAvailability(start, length))
            this.time.subList(this.time.indexOf(start), this.time.indexOf(start+length)).clear();
        else throw new IllegalArgumentException("Theatre is not available");
    }

    public String getName() {
        return this.theatreName;
    }
    
    public List<Seats> getSeatList() { 
        return this.seats;
    }

    private boolean getAvailability(int start, int length) { 
        if (this.time.contains(start) && this.time.contains(start+length)) return true;
        else return false;
    }
}
