Each `Book` object has:

```java
int id;
String title;
String author;
String genre;
int pages;
List<Integer> ratings;
```

---

## 🔢 Task List (Organized by Difficulty Level)

---

### 🟢 **Level 1: Beginner – Stream Fundamentals**

1. **List all unique authors alphabetically.**
2. **List all book titles longer than 15 characters.**
3. **Filter books with more than 300 pages.**
4. **Compute the average number of pages across all books.**
5. **Find all books with an average rating > 4.0.**
6. **List all genres used in the book list (no duplicates).**
7. **Count total number of books in the dataset.**
8. **Get the list of all book titles in uppercase.**
9. **Flatten all ratings into a single list (List<Integer>).**
10. **Find the maximum rating across all books.**

---

### 🟡 **Level 2: Intermediate – Grouping & Aggregation**

11. **Group books by genre and list the count in each genre.**
    → `Map<String, Long>`

12. **Compute average pages per genre.**
    → `Map<String, Double>`

13. **Get the book with the highest average rating in each genre.**
    → `Map<String, Optional<Book>>`

14. **Group books by author and list all their titles.**
    → `Map<String, List<String>>`

15. **Find the author who wrote the most books.**

16. **Count how many books have at least one 5-star rating.**

17. **Partition books into two groups: those with average rating >= 4.5 and the rest.**
    → `Map<Boolean, List<Book>>`

18. **Sort books by average rating (descending), then by title.**

---

### 🔴 **Level 3: Advanced – Custom Collectors, Nested Streams, Complex Grouping**

19. **Find the top 3 highest-rated books (by average rating).**

20. **Normalize all ratings on a 0–100 scale based on max rating found.**

21. **Generate a map of genres to the list of titles sorted by decreasing average rating.**

22. **For each genre, find the average of average ratings of books.**
    → Double average of average per genre

23. **Get a list of authors who have written books in more than one genre.**

24. **Group books by genre and then by author.**
    → `Map<String, Map<String, List<Book>>>`

25. **List authors with books that have received only 5-star ratings.**

26. **For each genre, print the title of the longest book (by pages).**

27. **Generate a flat list of all ratings > 3, sorted descending.**

28. **Create a map of genre → average number of ratings per book in that genre.**
