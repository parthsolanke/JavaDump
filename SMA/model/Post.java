package model;

import java.time.LocalDateTime;
import java.util.List;

public class Post {
    private int postId;
    private String content;
    private LocalDateTime timestamp;
    private List<Like> likes;
    private List<Comment> comments;
    private List<String> hashtags;

    public Post(int postId, String content, LocalDateTime timestamp, List<Like> likes, List<Comment> comments, List<String> hashtags) {
        this.postId = postId;
        this.content = content;
        this.timestamp = timestamp;
        this.likes = likes;
        this.comments = comments;
        this.hashtags = hashtags;
    }

    public int getPostId() { return postId; }

    public String getContent() { return content; }

    public LocalDateTime getTimestamp() { return timestamp; }

    public List<Like> getLikes() { return likes; }

    public List<Comment> getComments() { return comments; }

    public List<String> getHashtags() { return hashtags; }

    @Override
    public String toString() {
        return "Post{id=" + postId + ", content='" + content + "'}";
    }
}
