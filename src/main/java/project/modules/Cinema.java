package project.modules;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Scanner;

public class Cinema {

    private static String[] test2;

    public static void Go() throws FileNotFoundException {
        try {
            Scanner cinema = new Scanner(new File("/Users/timonselnes/Desktop/TDT4100-Project/src/main/resources/textfiles/cinema.txt"));
            cinema.useDelimiter("\n");

            while (cinema.hasNext()) {
               String string = cinema.next();
               test2 = string.split(";");
               createObjects(test2);
            }
            cinema.close();
        } catch (Exception e) { e.printStackTrace(); }
        Ticket2.loadTickets();
    }

    public static void createObjects(String[] string) {
        if (check("theatre")) {
            new Theatre(string[1], Integer.parseInt(string[2]));
        }
        else if (check("movie")) {
            new Movie(string[1], string[2], Integer.parseInt(string[3]));
        }
        else if (check("screening")) {
            new Screening(Movie.getMovie(getTitle(string[1])), Integer.parseInt(string[2]), Theatre.getTheatre(string[3]));
        }
    }

    public static String getTitle(String string) { // For simplicity's sake in .txt file, no repeating the title
        switch (string) {
            case "movie1":
                return "The Imitation Game";
            case "movie2":
                return "Snowden";
            case "movie3":
                return "Ex Machina";
            case "movie4":
                return "I, Robot";
            default:
                return null;
        }
    }

    public static boolean check(String cont) { 
        if (test2[0].contains(cont)) return true;
        else return false;
    }

    public static boolean hasTicket() {
        return true;
    }

    public static Screening findScreening(Movie movie, String screening) throws NoSuchElementException {
        Optional<Screening> tmp = movie.getScreenings().stream().filter(p -> p.toString().equals(screening)).findFirst();
        Screening temp = tmp.get();
        return temp;
    }
}

