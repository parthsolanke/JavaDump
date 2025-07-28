package model;

import java.time.LocalDateTime;

public class Comment {
    private int userId;
    private String text;
    private LocalDateTime timestamp;

    public Comment(int userId, String text, LocalDateTime timestamp) {
        this.userId = userId;
        this.text = text;
        this.timestamp = timestamp;
    }

    public int getUserId() { return userId; }

    public String getText() { return text; }

    public LocalDateTime getTimestamp() { return timestamp; }
}
