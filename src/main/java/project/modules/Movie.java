package project.modules;

public class Movie {
    private int length;
    private String title;
    private String language;

    public Movie(String title, String language, int length) {
        this.title = title;
        this.language = language;
        this.length = length;
    }

    public String getTitle() {
        return this.title;
    }

    public String getLanguage() {
        return this.language;
    }

    public int getScreenTime() {
        return this.length;
    }
}
