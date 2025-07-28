package model;

import java.time.LocalDate;
import java.util.List;

public class User {
    private int id;
    private String name;
    private String country;
    private LocalDate joinedDate;
    private List<Post> posts;
    private List<Integer> followers;

    public User(int id, String name, String country, LocalDate joinedDate, List<Post> posts, List<Integer> followers) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.joinedDate = joinedDate;
        this.posts = posts;
        this.followers = followers;
    }

    public int getId() { return id; }

    public String getName() { return name; }

    public String getCountry() { return country; }

    public LocalDate getJoinedDate() { return joinedDate; }

    public List<Post> getPosts() { return posts; }

    public List<Integer> getFollowers() { return followers; }

    @Override
    public String toString() {
        return String.format("User{id=%d, name='%s'}", id, name);
    }
}
