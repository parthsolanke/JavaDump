🧩 **Problem Statement**
A startup is building an analytics engine for a chain of restaurants. Every time a customer dines in, they leave a review. The company wants to mine these reviews to improve service, identify star performers, and spot emerging trends.

🧭 **Context**
Each review record consists of:

* **reviewerName**: `String`
* **restaurantName**: `String`
* **cuisineType**: `String` (e.g., “Italian”, “Sushi”, “Mexican”)
* **rating**: `double` (0.0–5.0)
* **tags**: `String` — comma‑separated keywords (e.g., “cozy, romantic, wine”)
* **visitTimestamp**: `LocalDateTime`

The analytics engine should process a `List<Review>` and produce multiple insights.

---

## ✅ Functional Requirements & Rules

### Requirement 1: Define Maximum Rating

**Objective:** Declare a `public static final double MAX_RATING = 5.0;`
**Rule:** Use a `final` constant in your `Review` class.

---

### Requirement 2: Parse Tags

**Objective:** Convert each review’s comma‑separated `tags` string into a `List<String>`.
**Rule:** Use `String.split()` + `Stream.of(...)` + `map(String::trim)`.

---

### Requirement 3: Compute Average Rating per Restaurant

**Objective:** Build a `Map<String, Double>` mapping each `restaurantName` to its average `rating`.
**Rule:** Use `Collectors.groupingBy()` + `Collectors.averagingDouble()`.

---

### Requirement 4: Top‐K Restaurants by Rating

**Objective:** Return a `List<String>` of the top K restaurants with highest average rating.
**Rule:** Use the map from Req 3, then stream entries, sort by value (desc), limit K, map to key.

---

### Requirement 5: Sort Reviews Chronologically

**Objective:** Produce a `List<Review>` sorted by `visitTimestamp` ascending.
**Rule:** Implement `Comparable<Review>` on timestamp, then `Collections.sort()` or `stream.sorted()`.

---

### Requirement 6: Sort Restaurants Alphabetically by Cuisine then Name

**Objective:** Return a sorted `List<String>` of unique restaurant names, first by `cuisineType` (asc), then by `restaurantName` (asc).
**Rule:** Create a `Comparator` and apply `stream.distinct().sorted(comparator)`.

---

### Requirement 7: Find All Unique Tags

**Objective:** Get a sorted `Set<String>` of every distinct tag across all reviews.
**Rule:** Use `flatMap()` + `collect(Collectors.toSet())` + `stream().sorted()`.

---

### Requirement 8: Find Reviewers Who Love “Cozy”

**Objective:** List reviewer names who included the tag “cozy” (case‑insensitive) in any of their reviews.
**Rule:** Filter reviews with `tags` containing “cozy” then map reviewerName and collect unique.

---

### Requirement 9: Cuisine‐Wise Review Counts

**Objective:** Produce a `Map<String, Long>` mapping each `cuisineType` to the number of reviews received.
**Rule:** Use `Collectors.groupingBy(Review::getCuisineType, Collectors.counting())`.

---

### Requirement 10: Peak Review Hour

**Objective:** Identify the hour of the day (0–23) during which the most visits occurred.
**Rule:** Extract `visitTimestamp.getHour()`, then `groupingBy(hour, counting())`, then find max.

---

### Requirement 11: Normalize Ratings

**Objective:** Generate a `List<Double>` of all ratings normalized to a 0–100 scale (i.e., rating/MAX\_RATING × 100).
**Rule:** Flatten ratings to a stream of doubles, map via normalization formula, collect.

---

### Requirement 12: Find One‐Star Reviews

**Objective:** Return a `List<Review>` with exactly `rating == 1.0`.
**Rule:** Filter stream on `rating == 1.0`, collect list.

