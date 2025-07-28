package model;

import java.util.List;

public class Book implements Comparable<Book> {
    private final String title;
    private int rank;
    private List<Review> reviews;

    public Book(String title) {
        this.title = title;
    }

    public double getAvgRating() {
        return reviews.stream()
                .mapToDouble(Review::getRating)
                .average()
                .orElse(0.0);
    }

    public String getTitle() {
        return title;
    }

    public int getRank() {
        return rank;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public List<String> getAllComments() {
        return reviews.stream()
                .map(Review::getComment)
                .toList();
    }

    public void addReview(String comment, double rating, Member ratedBy, Book book) {
        reviews.add(new Review(rating, comment, ratedBy, this));
    }

    @Override
    public int compareTo(Book o) {
        return this.title.compareTo(o.title);
    }
}