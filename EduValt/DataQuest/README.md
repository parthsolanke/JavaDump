Absolutely! Below is a **detailed documentation-style file** you can use alongside your project. It includes the **context**, **objectives**, and **descriptions of all tasks**, organized by difficulty. This is structured like a proper internal lab specification or **developer onboarding doc** you might find in a real-world Java engineering team.

---

# 📄 **Java Streams Mastery Lab – Specification Document**

## 📘 Project Title:

**DataQuest Labs – Stream Odyssey**

---

## 🧩 Objective:

This lab is designed to help you **master Java Streams, functional-style programming**, and gain practical experience with **stream-based transformations, aggregation, sorting, grouping, filtering, and mapping** operations in Java. You'll work with various **data types** (numbers, strings, collections, nested collections, and POJOs) and explore the **full range of Stream API capabilities**.

The lab also introduces **Comparator/Comparable**, `Optional`, grouping with `Collectors`, and basic functional patterns.

---

## 🧱 Project Structure:

```
src/
├── Main.java              # Main runner file for trying your solutions
├── DataStore.java         # Prepopulated data store (no need to create test data)
├── model/
│   ├── Student.java       # Student(name, score)
│   ├── Person.java        # Person(name, age, city)
│   ├── Employee.java      # Employee(name, department, salary)
│   └── Task.java          # Task(id, dependencies)
```

---

## 🎯 Getting Started:

* Use `DataStore` to get pre-filled data for each task.
* Write all your Stream operations in `Main.java` or in your own helper class.
* No loops allowed. Use **pure Java Stream API only**.
* You are not expected to write tests, UIs, or advanced class designs. Just focus on **stream-based logic**.

---

## 🟢 **Beginner Tasks**

### 1. Sensor Average

**Goal**: Compute the average of a list of temperature readings (Double values).
**Data**: `DataStore.getTemperatureReadings()`
**Output**: `OptionalDouble` or `double`

---

### 2. Normalize Prices

**Goal**: Convert prices in cents (integers) to dollars (doubles).
**Input**: `List<Integer> prices = Arrays.asList(100, 250, 475);`
**Output**: `[1.0, 2.5, 4.75]`

---

### 3. Count Negatives

**Goal**: Count how many integers in a list are negative.
**Input**: `List<Integer> nums = Arrays.asList(1, -3, 0, -2, 4);`
**Output**: `2`

---

### 4. Length Filter

**Goal**: Return all words longer than 5 characters.
**Data**: `DataStore.getWords()`
**Output**: Filtered list

---

### 5. Total Characters

**Goal**: Compute total character count in a list of strings.
**Input**: `List<String> = Arrays.asList("hi", "hello", "world")`
**Output**: `13`

---

## 🟡 **Intermediate Tasks**

### 6. Top 3 Frequencies

**Goal**: Find top 3 most frequent words.
**Input**: `List<String> words`
**Output**: Sorted list of most common words.

---

### 7. Sensor Range Check

**Goal**: Filter a 2D matrix of integers to get values in a range.
**Input**: `List<List<Integer>>` or `int[][]`
**Output**: Flat list of matching integers

---

### 8. Group Words by First Letter

**Goal**: Return `Map<Character, List<String>>` grouping words by their first character.
**Data**: `DataStore.getWords()`

---

### 9. Extract Domain Names

**Goal**: From email addresses, extract domain names.
**Data**: `DataStore.getEmails()`
**Output**: `["gmail.com", "yahoo.com", ...]`

---

### 10. Reverse Sort With Nulls

**Goal**: Sort a list of strings in reverse order, keeping all nulls at the end.
**Input**: `List<String> = Arrays.asList("apple", null, "banana", "pear", null);`

---

## 🔴 **Advanced Tasks**

### 11. Flatten & Distinct

**Goal**: Flatten a list of lists of integers and return a distinct sorted list.
**Data**: `DataStore.getNestedNumbers()`
**Output**: `[1, 2, 3, 4, 5, 6, 7]`

---

### 12. Word Frequency Map

**Goal**: Return `Map<String, Long>` with word count.
**Input**: List of words

---

### 13. Multi-Level Sorting (Person)

**Goal**: Sort people by city (asc), age (desc), name (asc).
**Data**: `DataStore.getPeople()`
**Use**: `Comparator.comparing(...)`

---

### 14. Merge Score Maps

**Goal**: Merge quiz and assignment maps to produce total scores.
**Data**:

* `DataStore.getQuizScores()`
* `DataStore.getAssignmentScores()`

---

### 15. Max By Group

**Goal**: Find the highest-paid employee in each department.
**Data**: `DataStore.getEmployees()`
**Output**: `Map<String, Optional<Employee>>`

---

## 🟣 **Expert Tasks**

### 16. Anagram Grouping

**Goal**: Group words that are anagrams using their sorted character signature.
**Input**: `["eat", "tea", "tan", "ate", "nat", "bat"]`
**Output**: `Map<String, List<String>>`

---

### 17. Sliding Window Sums

**Goal**: Return list of sliding window sums of size 3.
**Input**: `List<Integer> = Arrays.asList(1, 2, 3, 4, 5)`
**Output**: `[6, 9, 12]`

---

### 18. Dependency Resolver

**Goal**: Sort tasks topologically by resolving their dependencies.
**Data**: `DataStore.getTasks()`
**Hint**: Use `flatMap`, map lookup, and recursion carefully.

---

### 19. Build Histogram

**Goal**: Return a histogram: `Map<Integer, Long>` from integers to frequency count.
**Input**: List of integers

---

### 20. Employee Chain Builder

**Goal**: Build a reporting chain per employee.
**Input**: `Employee(name, Optional<Manager>)` – not implemented yet, optional challenge

---

## 🧩 Bonus Challenges

### 21. Prime Filter

**Goal**: Return all prime numbers in a list. Use a helper `isPrime(int)`.

---

### 22. Most Common Word Length

**Goal**: Determine which word length occurs most frequently.

---

### 23. Digit Sum Grouping

**Goal**: Group numbers by digit sum: 123 → 6
**Output**: `Map<Integer, List<Integer>>`

---

### 24. Top N by Custom Comparator

**Goal**: Get top N elements using a given comparator without sorting the full list.

---

### 25. Join Unique Sorted

**Goal**: Return a comma-separated string of all unique, sorted strings.

---

## 🔧 Helper Tips

* Use `Collectors.groupingBy`, `Collectors.mapping`, `Collectors.toMap`, `Comparator`, `flatMap`, `distinct()`, `sorted()`, `limit()`, `skip()`, etc.
* For optional fields or nulls, use `Optional`, `Comparator.nullsLast(...)`
* All data is ready. Just **import**, **stream**, and **solve**.

