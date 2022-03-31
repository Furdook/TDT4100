package project.modules;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Cinema {

    private static String[] stringArray;

    public static void Go() throws FileNotFoundException { // reads .txt file to create objects
        try {
            Scanner cinema = new Scanner(new File("/Users/timonselnes/Desktop/TDT4100-Project/src/main/resources/textfiles/cinema.txt"));
            cinema.useDelimiter("\n");

            while (cinema.hasNext()) {
               String string = cinema.next();
               stringArray = string.split(";");
               createObjects(stringArray);
            }
            cinema.close();
        } catch (Exception e) { e.printStackTrace(); }
        Ticket2.loadTickets();
    }

    public static void createObjects(String[] string) { // creates objects used in app
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

    public static String getTitle(String string) { 
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

    public static boolean check(String cont) { // checks type of object to be created
        if (stringArray[0].contains(cont)) return true;
        else return false;
    }
}

