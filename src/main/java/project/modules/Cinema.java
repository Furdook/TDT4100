package project.modules;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


// Will be replaces by text file
public class Cinema {

    private static String[] test2;
    private static int OPEN = 800; // change to 15 minute increments later

    public static int getOPEN() {
        return OPEN;
    }

    public static void main(String[] args) throws FileNotFoundException {

        try {
            Scanner test = new Scanner(new File("/Users/timonselnes/Desktop/TDT4100-Project/src/main/resources/textfiles/cinema.txt"));
            test.useDelimiter("\n");

            while (test.hasNext()) {
               String string = test.next();
               test2 = string.split(";");
               createObjects(test2);
            }
            test.close();
        } catch (Exception e) { e.printStackTrace(); }
    }

    public static void createObjects(String[] string) {
        if (check("theatre")) {
            new Theatre(string[1], Integer.parseInt(string[2]));
        }
        else if (check("movie")) {
            new Movie(string[1], string[2], Integer.parseInt(string[3]));
        }
        else if (check("screening")) {
            new Screening(Movie.getMovie(getTitle(string[1])), Integer.parseInt(string[2]), Theatre.getTheatre(getTheatreTitle(string[3])));
        }
    }

    public static String getTheatreTitle(String string) {
        switch (string) {
            case "theatre1":
                return "Sal 1";
            case "theatre2":
                return "Sal 2";
            case "theatre3":
                return "Sal 3";
            case "theatre4":
                return "Sal 4";
            default:
                return null;
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

    public static boolean check(String cont) {
        if (test2[0].contains(cont)) return true;
        else return false;
    }
}

