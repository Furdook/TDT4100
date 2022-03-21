package project.modules;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Movie {
    private int length;
    private String title;
    private String language;
    private static List<Movie> movies = new ArrayList<>();
    private List<Screening> screenings = new ArrayList<>();

    public Movie(String title, String language, int length) {
        if (title != null && !title.equals("")) this.title = title;
        else throw new IllegalArgumentException("Title can not be null");

        if (language != null && !language.equals("")) this.language = language;
        else throw new IllegalArgumentException("Language can not be null");

        if (length > 0) this.length = length;
        else throw new IllegalArgumentException("Length can not be less than zero");

        movies.add(this);
    }

    public static Movie getMovie(String input) {
        Optional<Movie> tmp = movies.stream().filter(p -> p.getTitle().equals(input)).findFirst();
        Movie test = tmp.get();
        return test;
    }

    public static List<Movie> getMovies() {
        return movies;
    }

    public String getTitle() {
        return this.title;
    }

    public String getLanguage() {
        return this.language;
    }

    public int getLength() {
        return this.length;
    }

    public void setScreenings(Screening screening) {
        screenings.add(screening);
    }

    public List<Screening> getScreenings() {
        return this.screenings;
    }

    @Override
    public String toString() {
        return getTitle();
    }
}
