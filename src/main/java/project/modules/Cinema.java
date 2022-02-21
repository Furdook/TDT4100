package project.modules;

import javafx.fxml.FXML;

public class Cinema {
    private static int OPEN = 840; // Open from 12:00 to 02:00, 840 minutes.

    public static void main(String[] args) {
        Theatre sal1 = new Theatre("Sal 1", 90);
        Theatre sal2 = new Theatre("Sal 2", 80);
        Theatre sal3 = new Theatre("Sal 3", 110);
        Theatre sal4 = new Theatre("Sal 4", 50);

        Movie movie1 = new Movie("The Imitation Game", "Engelsk", 114);
        Movie movie2 = new Movie("Snowden", "Engelsk", 134);
        Movie movie3 = new Movie("Ex Machina", "Engelsk", 108);
        Movie movie4 = new Movie("The Imitation Game", "Engelsk", 114);

        Screening screening1 = new Screening(movie1, 0, sal1);
        Screening screening2 = new Screening(movie1, 0, sal2);
        Screening screening3 = new Screening(movie1, 0, sal3);
        Screening screening4 = new Screening(movie1, 0, sal4);

        Screening screening5 = new Screening(movie2, 0, sal1);
        Screening screening6 = new Screening(movie2, 0, sal2);
        Screening screening7 = new Screening(movie2, 0, sal3);
        Screening screening8 = new Screening(movie2, 0, sal4);

        Screening screening9 = new Screening(movie3, 0, sal1);
        Screening screening10 = new Screening(movie3, 0, sal2);
        Screening screening11 = new Screening(movie3, 0, sal3);
        Screening screening12 = new Screening(movie3, 0, sal4);

        Screening screening13 = new Screening(movie4, 0, sal1);
        Screening screening14 = new Screening(movie4, 0, sal2);
        Screening screening15 = new Screening(movie4, 0, sal3);
        Screening screening16 = new Screening(movie4, 0, sal4);

        

    }
}

