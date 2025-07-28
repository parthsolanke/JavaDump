package model;

import java.util.List;

public class Book {
    private String title;
    private String genre;
    private int pages;
    private List<Review> reviews;

    public Book(String title, String genre, int pages, List<Review> reviews) {
        this.title = title;
        this.genre = genre;
        this.pages = pages;
        this.reviews = reviews;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public int getPages() {
        return pages;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public double getAvgRating() {
        return reviews.stream()
                .mapToInt(Review::getRating)
                .average()
                .orElse(0.0);
    }

    @Override
    public String toString() {
        return "\"" + title + "\" (" + genre + ", " + pages + " pages)";
    }
}
