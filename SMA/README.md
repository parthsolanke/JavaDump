# 📄 **Social Media Analytics – Java Streams Mastery Lab**

---

## 🧭 Overview

**Streamlytic** is a fictional social media analytics company that tracks and analyzes how users interact with content across the platform. This project simulates real-world problems involving **user-generated content, engagement metrics, hashtags, follower graphs, and user activity patterns**.

You will use **Java Stream API** to write expressive, readable, and performant solutions without using loops or manual iteration. This lab is designed to **strengthen your fluency with functional programming in Java**, with a focus on **Streams**, `Collectors`, `Comparator`, `flatMap`, `Optional`, and multi-level aggregation.

---

## 🔧 Tech Stack

* **Java 17+**
* **Pure Stream API** – no loops or imperative code
* **Lambdas, Optionals, Collectors, Comparator**

---

## 🧱 Data Models

These classes form the basis of the project. They should be placed in the `model` package.

### 👤 User

```java
public class User {
    int id;
    String name;
    String country;
    LocalDate joinedDate;
    List<Post> posts;
    List<Integer> followers; // user IDs
}
```

### 📝 Post

```java
public class Post {
    int postId;
    String content;
    LocalDateTime timestamp;
    List<Like> likes;
    List<Comment> comments;
    List<String> hashtags; // e.g. ["travel", "sunset"]
}
```

### ❤️ Like

```java
public class Like {
    int userId;
    LocalDateTime timestamp;
}
```

### 💬 Comment

```java
public class Comment {
    int userId;
    String text;
    LocalDateTime timestamp;
}
```

---

## 📁 Project Layout

```
src/
├── Main.java              # Main entry point for running tasks
├── DataStore.java         # Utility to provide mock data (Users, Posts, etc.)
└── model/
    ├── User.java
    ├── Post.java
    ├── Like.java
    └── Comment.java
```

---

## 🎯 Objectives

Master:

* Stream pipelines with nested lists and conditional filtering
* Grouping by multiple levels
* Aggregations and statistical summaries
* Stream sorting, partitioning, and flattening
* Real-world entity relationships (followers, posts, likes, comments)

---

# ✅ Tasks Breakdown

---

## 🟢 **Section 1: User & Follower Analytics**

1. **List unique countries where users are from**
   ➜ Return a sorted `List<String>` of unique countries.

2. **Average followers per user**
   ➜ Return a `double` representing average follower count.

3. **Top 5 users with most followers**
   ➜ Return a `List<User>` sorted by follower count descending.

4. **Users with zero followers**
   ➜ Return a list of names of users who aren’t followed by anyone.

5. **Country → User count map**
   ➜ `Map<String, Long>` showing number of users per country.

6. **Users joined in the last 6 months**
   ➜ Filter by `joinedDate`. Return a list of their names.

---

## 🟡 **Section 2: Content & Hashtag Analysis**

7. **Distinct hashtags used across posts**
   ➜ Return a sorted `Set<String>` of all unique hashtags used.

8. **Top 10 most used hashtags**
   ➜ Return `List<String>` of top hashtags by frequency.

9. **Hashtag frequency map**
   ➜ `Map<String, Long>` → hashtag to usage count.

10. **Most common hashtag per country**
    ➜ Return `Map<String, Optional<String>>`: country → most common hashtag (based on user posts).

11. **Longest post (by content length)**
    ➜ Return the `Post` with the longest content.

12. **Users who never posted**
    ➜ Return list of users where `posts.size() == 0`.

---

## 🟠 **Section 3: Post Engagement & Trends**

13. **Average likes per post**
    ➜ Return a `double` average.

14. **Post with the most comments**
    ➜ Return the `Post`.

15. **User → Average likes per post**
    ➜ Return `Map<User, Double>`.

16. **Top 3 posts with best like-to-comment ratio**
    ➜ Return `List<Post>` sorted by ratio descending.

17. **Partition posts into viral (likes > 100) and non-viral**
    ➜ Return `Map<Boolean, List<Post>>`.

18. **Like count per day**
    ➜ Return `Map<LocalDate, Long>` showing likes posted per day.

19. **Average comment length per user**
    ➜ `Map<User, Double>` of avg comment lengths made by user.

20. **Post count by month**
    ➜ Return `Map<Month, Long>`.

---

## 🔴 **Section 4: Advanced Grouping & Streams**

21. **Users who liked or commented on their own posts**
    ➜ Return names of such users.

22. **User → Set of other users who engaged with their posts**
    ➜ Return `Map<User, Set<User>>`.

23. **Hashtag → List of Post IDs**
    ➜ Flatten all hashtags to `Map<String, List<Integer>>`.

24. **Users with >10 unique hashtags used**
    ➜ Return list of names of such users.

25. **User stats: post length, likes/post, total comments**
    ➜ Create class `UserStats`, return `Map<User, UserStats>`.

```java
class UserStats {
    double avgPostLength;
    double avgLikesPerPost;
    long totalComments;
}
```

26. **Detect "fanboys" — users who like/comment on >90% of a specific user's posts**
    ➜ Return `Map<User, Set<User>>` (target → list of their fanboys).

27. **Top 5 most active commenters**
    ➜ Return users who wrote most comments (across all posts).

28. **Night Owls** (posting between 10PM–4AM)
    ➜ Return `List<User>` who posted primarily at night.

29. **UserId → Hashtag → Usage Count**
    ➜ Return `Map<Integer, Map<String, Integer>>`.

---

## 🟣 **Section 5: Expert Stream Challenges**

30. **Global activity timeline (likes, comments, posts)**
    ➜ Return a flat `List<Activity>` sorted by time.

```java
class Activity {
    String type; // "post", "like", or "comment"
    int userId;
    LocalDateTime timestamp;
}
```

31. **Activity heatmap: Day → Hour → Count**
    ➜ Return `Map<DayOfWeek, Map<Integer, Long>>`.

32. **Fastest commenter (time after post)**
    ➜ Return `Map<Post, Comment>` with the shortest delay after post.

33. **Sentiment grouping**
    ➜ Words like "love", "great", "awesome" → positive
    "bad", "hate", "worst" → negative
    ➜ Group posts into `Map<String, List<Post>>`.

34. **Top engaging follower per user**
    ➜ Return `Map<User, User>` showing most interactive follower (by likes + comments given to them).

35. **Trending hashtags per day**
    ➜ Return `Map<LocalDate, List<String>>` – top hashtags each day.

