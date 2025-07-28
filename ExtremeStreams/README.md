# 📄 **Java Streams Mastery Lab – Level 4+: Deep Dive with Authors & Reviews**

---

## 📘 Project Title:

**Litlytics: Advanced Book Analytics with Java Streams**

---

## 🧭 Overview

You are joining the backend analytics team of **Litlytics**, a SaaS platform that collects, tracks, and visualizes book reviews across genres and authors. Your mission is to build an **extensive analytics engine** using **Java Stream API** only — no loops, no mutation, no imperative logic.

The goal is to **master** complex stream transformations including **multi-level grouping**, **statistical summarization**, **review timeline processing**, and **author similarity metrics**, all using nested data.

---

## 🧱 Data Model

You will work with the following domain objects:

```java
class Author {
    String name;
    List<Book> books;
}

class Book {
    String title;
    String genre;
    int pages;
    List<Review> reviews;
}

class Review {
    int rating; // 1 to 5
    String reviewer;
    LocalDateTime timestamp;
}
```

---

## 🎯 Objectives

You are to implement a series of **data processing tasks** using pure Java Streams. Your focus is to:

* Build **nested stream pipelines**
* Handle **multi-level grouping**
* Use `Collectors.mapping`, `flatMap`, and custom reduction
* Handle **time-based analysis**
* Master `Optional`, `Map`, `Comparator`, and `Statistics` in streaming contexts

No UIs, DBs, or test frameworks are required. Your code should be functional, concise, and expressive.

---

## 🔴 Task List – **Expert-Level Java Stream Challenges**

---

### 🧩 1. **Genre → Top 2 Authors by Average Rating**

**Goal**: For each genre, identify the **top 2 authors** (by average book rating within that genre).

**Output**: `Map<String, List<Author>>`
**Tip**: Requires grouping by genre → flattening → averaging → sorting → limiting.

---

### 🧩 2. **Reviewer → Distinct Genres Reviewed**

**Goal**: For each reviewer, list all genres they’ve ever reviewed books in.

**Output**: `Map<String, Set<String>>`
**Challenge**: Traverse authors → books → reviews → reviewer → genre.

---

### 🧩 3. **Hourly Review Distribution**

**Goal**: Count how many **distinct books** got at least one review during each hour of the day.

**Output**: `Map<Integer, Long>` → hour (0–23) → count of books
**Note**: Use `review.timestamp.getHour()`

---

### 🧩 4. **Top-K Most Reviewed Books**

**Goal**: Return the top-K books based on the **number of reviews** they’ve received.

**Input**: `int k`
**Output**: `List<Book>`
**Tip**: Use `.sorted()` with comparator → `.limit(k)`

---

### 🧩 5. **Books with Non-Decreasing Ratings**

**Goal**: Find books where reviews are in **chronological order** and rating never decreases.

**Output**: `List<Book>`
**Hint**: Use sorted streams + reduction + compare previous/current.

---

### 🧩 6. **Genre → Average Time Gap Between Reviews**

**Goal**: For each genre, calculate average time gap (in minutes) between reviews (per book), aggregated per genre.

**Output**: `Map<String, Double>`
**Tip**: Sort timestamps, compute gaps → flatten all gaps → average.

---

### 🧩 7. **Reviewer Loyalty Score**

**Goal**: For each reviewer, compute:

```
loyalty = number of books reviewed / number of authors reviewed
```

**Output**: `Map<String, Double>`

---

### 🧩 8. **Authors Ranked by Total Review Count**

**Goal**: Sum total number of reviews across all books per author. Return sorted list of authors.

**Output**: `List<Author>` → most reviewed first.

---

### 🧩 9. **Most Polarizing Book**

**Goal**: Identify the book with **highest standard deviation** of ratings.

**Output**: `Optional<Book>`
**Challenge**: Implement custom `Collector` or reduction.

---

### 🧩 10. **Detect Review Spam**

**Goal**: Identify reviewers who posted **>3 reviews** across different books within **10 minutes** total.

**Output**: `List<String>` (reviewer names)

---

### 🧩 11. **Reviewer Time-Series Map**

**Goal**: For each reviewer, build a time-series map of:

```
LocalDate → Average rating on that date
```

**Output**: `Map<String, Map<LocalDate, Double>>`

---

### 🧩 12. **Author Similarity Map**

**Goal**: For each author, list other authors who share at least **3 genres** in common.

**Output**: `Map<Author, List<Author>>`

---

### 🧩 13. **Genre → Median Rating**

**Goal**: For each genre, compute the **median** rating from all its books’ reviews.

**Output**: `Map<String, Double>`
**Hint**: Collect to list, sort, compute middle element.

---

### 🧩 14. **Top Reviewers by Time-Weighted Score**

**Goal**: Weight recent reviews more. For each reviewer:

```
Score = sum of (rating × (1 / (days since review + 1)))
```

**Output**: Top 5 reviewers by weighted score.

---

### 🧩 15. **Review Count Histogram**

**Goal**: Generate a histogram of number of reviews per book:

**Output**: `Map<Integer, Long>`
e.g., `3 → 12` means 12 books have exactly 3 reviews.

---

## 🔶 Stream Algorithm Practice – Stateless Data

These tasks are not tied to the domain model and are excellent for sharpening raw Stream skills.

---

### 🧮 16. **Sliding Window Sums**

**Goal**: For a list of integers, return list of sum of every `k` consecutive values.

**Input**: `List<Integer>`, `int k`
**Output**: `List<Integer>`

---

### 🧮 17. **Longest Increasing Subsequence**

**Goal**: Return the longest **strictly increasing subsequence** from a list of integers using `Stream`.

---

### 🧮 18. **Detect Palindromes**

**Goal**: From a list of strings, return those that are palindromes.

**Output**: `List<String>`
**Constraint**: Case-insensitive, ignore non-alphanumeric.

---

### 🧮 19. **Group Numbers by Digit Count**

**Goal**: Group integers based on number of digits.

**Output**: `Map<Integer, List<Integer>>`
e.g., `3 → [123, 999, 101]`

---

### 🧮 20. **Topological Sort Using Streams (Optional)**

**Goal**: Given tasks with dependencies, return a valid execution order.

**Input**: `class Task { String id; List<String> dependencies; }`
**Challenge**: Implement DAG traversal via functional style.

---

## 🧠 Bonus Challenges

---

### 🎲 21. What’s wrong with this?

```java
.collect(Collectors.toMap(Book::getGenre, b -> 1))
```

**Answer**: Duplicate key exception. Use merge function:
`.toMap(key, val, (a, b) -> a + b)`

---

### 🧪 22. How does evaluation differ in this?

```java
list.stream().sorted().filter(...);
```

vs.

```java
list.stream().filter(...).sorted();
```

**Hint**: Lazy evaluation — filters early → better perf.

---

### 🧮 23. `takeWhile()` for Java 8

**Goal**: Implement `takeWhile` manually using stream (requires stateful custom collector or workaround)

---

## 🛠 Tools & Techniques Required

* `flatMap`, `map`, `filter`, `sorted`
* `Collectors.groupingBy`, `Collectors.mapping`, `Collectors.toMap`
* `Comparator.comparing`, `.reversed()`
* `Optional`, `OptionalDouble`
* `IntSummaryStatistics`, `DoubleSummaryStatistics`
* `reduce`, custom collectors
* `peek` for debugging