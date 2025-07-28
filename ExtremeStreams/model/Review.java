package model;

import java.time.LocalDateTime;

public class Review {
    private int rating;
    private String reviewer;
    private LocalDateTime timestamp;

    public Review(int rating, String reviewer, LocalDateTime timestamp) {
        this.rating = rating;
        this.reviewer = reviewer;
        this.timestamp = timestamp;
    }

    public int getRating() {
        return rating;
    }

    public String getReviewer() {
        return reviewer;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return reviewer + " (" + rating + "★ at " + timestamp + ")";
    }
}
