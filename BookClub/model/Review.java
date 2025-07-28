package model;

public class Review {
    private String comment;
    private double rating;
    private Member ratedBy;
    private Book book;

    public Review(double rating, String comment, Member ratedBy, Book book) {
        this.rating = rating;
        this.comment = comment;
        this.ratedBy = ratedBy;
        this.book = book;
    }

    public String getComment() {
        return comment;
    }

    public double getRating() {
        return rating;
    }

    public Book getBook() {
        return book;
    }

    public Member getRatedBy() {
        return ratedBy;
    }

}