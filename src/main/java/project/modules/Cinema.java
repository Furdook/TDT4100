package project.modules;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

// Will be replaces by text file
public class Cinema {
    private static int OPEN = 800; // change to 15 minute increments later

    private static Theatre sal1 = new Theatre("Sal 1", 90);
    private static Movie movie1 = new Movie("The Imitation Game", "Engelsk", 8);
    
    public static Screening screening1 = new Screening(movie1, 0, sal1);

    public static int getOPEN() {
        return OPEN;
    }

    public static void main(String[] args) throws FileNotFoundException {

        List<Movie> movies = new ArrayList<>();
        System.out.println(movies);

        File file = new File("/Users/timonselnes/Desktop/TDT4100-Project/src/main/resources/textfiles/cinema.txt");
        InputStreamReader isr = new InputStreamReader(new FileInputStream(file));

        try (BufferedReader br = new BufferedReader(isr)) {
            while (br.ready()) {
                String line = br.readLine();
                System.out.println(line);
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }

        try {
            movies = Files.lines(Paths.get(file.toURI())).skip(1).map(s-> new Movie(file.lines().findFirst().get().split(";")).toList());
        } catch (Exception e) {
            //TODO: handle exception
        }

    }
}

