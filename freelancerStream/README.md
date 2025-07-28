# 📊 Freelancer Project Tracker – Java Streams Mastery Project

## 🧭 Context

FreelancerHub is an online platform where companies post freelance gigs, and professionals from various domains—such as Design, Development, and Writing—complete projects for clients.

Each **Freelancer** has worked on multiple **Projects**, and the platform now wants to analyze performance data to:
- Recommend top freelancers to clients
- Understand client and project patterns
- Identify talent trends within categories

This project gives you an opportunity to **practice Java Streams, `Comparable`, `Comparator`**, and advanced data manipulation tasks using realistic data and goals.

---

## 📦 Project Structure

### 👤 Freelancer
```java
int id;
String name;
String category;
List<Project> projects;
````

### 📁 Project

```java
String projectId;
String client;
int durationInDays;
int budget;
int rating; // Out of 100
```

---

## 🚀 Goal

Implement stream-based solutions to analyze and transform this dataset. Each requirement below is designed to reinforce a specific concept or usage pattern in Java Streams or sorting.

---

## ✅ Functional Requirements

### 🔹 PART 1: Sorting & Comparison

1. **Define Max Rating Constant**

   * Use `final int MAX_RATING = 100;` in your `Main` class.

2. **Freelancer Comparable**

   * Sort freelancers by **average project rating (descending)**.
   * If there's a tie, break it by **name (ascending)**.

3. **Category-Based Sorting Comparator**

   * Sort freelancers by **category (ascending)**, then by **ID (ascending)**.

---

### 🔹 PART 2: Stream Essentials

4. **Top N Freelancers by Rating**

   * Return names of the top `N` freelancers based on **average rating**.

5. **List Unique Clients Alphabetically**

   * Collect a sorted list of **distinct client names** from all projects.

6. **Category-Wise Average Rating**

   * Return a map: `category → average rating` across freelancers in that category.

7. **Normalized Project Budgets (0–100 scale)**

   * Normalize all project budgets using the **highest budget** and output a flat list of normalized values.

8. **Group Freelancers by Category**

   * Return a map: `category → list of freelancers`.

---

### 🔹 PART 3: Advanced Stream Patterns

9. **Freelancers With More Than X Projects**

   * Return names of freelancers who have completed more than `X` projects.

10. **Projects With Perfect Ratings**

    * Return project IDs of all projects rated exactly `100`.

11. **Freelancers Who Never Scored Below 50**

    * List freelancers whose **every project rating** is `>= 50`.

12. **Client(s) with Most Projects**

    * Identify the client(s) with the highest number of projects assigned across all freelancers.

13. **Top 3 Freelancers by Total Revenue**

    * Revenue = sum of all project budgets per freelancer.

14. **Rating Distribution**

    * Return a rating band breakdown:

      ```
      "0–49"     → count
      "50–69"    → count
      "70–89"    → count
      "90–100"   → count
      ```

15. **Project Duration Statistics**

    * Use `IntSummaryStatistics` to get:

      * Total count
      * Minimum
      * Maximum
      * Average
      * Sum

---

## 🌟 Bonus Challenges (Optional)

These are more complex but provide high learning value:

* **Multi-Level Grouping**

  * Map of `category → client → list of projects`.

* **Detect Inactive Freelancers**

  * If `Project` had a field like `LocalDate endDate`, find freelancers with no projects in the last 6 months.

* **Top Client per Category**

  * For each category, find the client who gave the highest average rating to freelancers.

---

## 📌 Input Constraints

* At least **10 freelancers**
* Across **3 or more categories** (e.g., Design, Development, Writing)
* Each freelancer must have **3+ projects**
* Project Budgets: ₹5,000 to ₹2,00,000
* Ratings: 0 to 100
* Project durations: 5 to 90 days