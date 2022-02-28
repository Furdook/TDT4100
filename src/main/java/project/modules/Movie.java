package project.modules;

public class Movie {
    private int length;
    private String title;
    private String language;

    public Movie(String title, String language, int length) {
        if (title != null && !title.equals("")) this.title = title;
        else throw new IllegalArgumentException("Title can not be null");

        if (language != null && !language.equals("")) this.language = language;
        else throw new IllegalArgumentException("Language can not be null");

        if (length > 0) this.length = length;
        else throw new IllegalArgumentException("Length can not be less than zero");
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
}
