package project.modules;
// Will be replaces by text file
public class Cinema {
    private static int OPEN = 800; // change to 15 minute increments later

    private static Theatre sal1 = new Theatre("Sal 1", 90);
    private static Movie movie1 = new Movie("The Imitation Game", "Engelsk", 8);
    
    public static Screening screening1 = new Screening(movie1, 0, sal1);

    public static int getOPEN() {
        return OPEN;
    }

    public static void main(String[] args) {
        //Theatre sal1 = new Theatre("Sal 1", 90);
        Theatre sal2 = new Theatre("Sal 2", 80);
        Theatre sal3 = new Theatre("Sal 3", 110);
        Theatre sal4 = new Theatre("Sal 4", 50);

       // Movie movie1 = new Movie("The Imitation Game", "Engelsk", 114);
        Movie movie2 = new Movie("Snowden", "Engelsk", 9);
        Movie movie3 = new Movie("Ex Machina", "Engelsk", 8);
        Movie movie4 = new Movie("I, Robot", "Engelsk", 8);

       // Screening screening1 = new Screening(movie1, 0, sal1);
        Screening screening2 = new Screening(movie1, 35, sal2);
        Screening screening3 = new Screening(movie1, 20, sal3);
        Screening screening4 = new Screening(movie1, 15, sal4); 

        Screening screening5 = new Screening(movie2, 10, sal1);
        Screening screening6 = new Screening(movie2, 0, sal2);
        Screening screening7 = new Screening(movie2, 35, sal3);
        Screening screening8 = new Screening(movie2, 30, sal4);

        Screening screening9 = new Screening(movie3, 20, sal1);
        Screening screening10 = new Screening(movie3, 10, sal2);
        Screening screening11 = new Screening(movie3, 0, sal3);
        Screening screening12 = new Screening(movie3, 40, sal4);

        Screening screening13 = new Screening(movie4, 40, sal1);
        Screening screening14 = new Screening(movie4, 25, sal2);
        Screening screening15 = new Screening(movie4, 10, sal3);
        Screening screening16 = new Screening(movie4, 0, sal4);
    }
}

