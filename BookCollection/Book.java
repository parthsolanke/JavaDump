import java.util.*;

public class Book {
    private final int id;
    private final String title;
    private final String author;
    private final String genre;
    private final int pages;
    private final List<Integer> ratings;

    public Book(int id, String title, String author, String genre, int pages, List<Integer> ratings) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.pages = pages;
        this.ratings = ratings;
    }

    // Getters
    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getGenre() { return genre; }
    public int getPages() { return pages; }
    public List<Integer> getRatings() { return ratings; }
    public double getAvgRating() { return ratings.stream().mapToInt(Integer::intValue).average().orElse(0.0); }

    @Override
    public String toString() {
        return title + " by " + author + " [" + genre + "]";
    }
}
