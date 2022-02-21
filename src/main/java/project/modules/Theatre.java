package project.modules;

import java.util.ArrayList;
import java.util.List;

public class Theatre {
    private List<Seats> seats = new ArrayList<>();
    private String theatreName;

    public Theatre(String name, int size) {
        if (name != null) this.theatreName = name;
        else throw new IllegalArgumentException("Theatre name can not be null");

        if (size > 0) 
            for (int i = 0; i < size; i++) 
                this.seats.add(new Seats(i));
        else throw new IllegalArgumentException("Theatre can not have zero or fewer seats");
    }

    public String getName() {
        return this.theatreName;
    }

    public int getSize() {
        return seats.size();
    }

    public List<Seats> getSeatList() { 
        return this.seats;
    }

    public boolean getAvailability(int start, int length) { // if theatre is not in use return true
        return true;
    }
}
