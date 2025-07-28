package model;

import java.time.LocalDateTime;

public class Like {
    private int userId;
    private LocalDateTime timestamp;

    public Like(int userId, LocalDateTime timestamp) {
        this.userId = userId;
        this.timestamp = timestamp;
    }

    public int getUserId() { return userId; }

    public LocalDateTime getTimestamp() { return timestamp; }
}
