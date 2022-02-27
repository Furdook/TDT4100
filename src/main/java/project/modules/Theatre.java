package project.modules;

import java.util.ArrayList;
import java.util.List;

public class Theatre {
    private String theatreName;
    private List<String> seats = new ArrayList<>();
    private List<Integer> time = new ArrayList<>();
    private char[] seatChar = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K'};

    public Theatre(String name, int size) {
        if (name != null) this.theatreName = name;
        else throw new IllegalArgumentException("Theatre name can not be null");

        if (size > 0 && size <= 110) { // Adds the set amount of seats to current theatre max 110
            for (int i = 0; i < size/10; i++) { // Picks letter from seatChar
                for (int j = 0; j < 10; j++) { // 1-10
                    this.seats.add(seatChar[i] + "-" + (j + 1)); // A-1...K-9 etc
                }
            }
        }
        else throw new IllegalArgumentException("Theatre can not have zero or fewer seats, and no more than 110");

        for (int i = 0; i < 50; i++) { // Sets time the cinema would be open 1 = 15 minutes
            this.time.add(i); // Creates timeArray used for timing screenings in said theatre
        }
    }

    public void setTaken(int start, int length) {
        if (getAvailability(start, length)) {
            this.time.subList(this.time.indexOf(start), this.time.indexOf(start+length)).clear();
        } // Removes time slots from the time List in 15 minute increments
        else throw new IllegalArgumentException("Theatre is not available");
    }

    private boolean getAvailability(int start, int length) { // Cheacks if timeslots are taken
        if (this.time.contains(start) && this.time.contains(start+length)) {
            return true;
        }
        else return false;
    }

    public List<String> getSeatList() { 
        return this.seats;
    }

    public String getName() {
        return this.theatreName;
    }

    public static void main(String[] args) {
        Theatre test = new Theatre("test", 110);
        System.out.println(test.getSeatList());
    }
}
