# 📄 Requirement Document: Student Activity Tracker

## 🧩 Problem Statement

A university conducts a co-curricular program where students actively participate in various events. To measure student engagement and improve program effectiveness, the university wants to track participation, feedback, and event trends across students.

---

## 🧭 Context

Each student provides the following data:

* **Name**: `String`
* **Events Attended**: `String` — a comma-separated list of event names (e.g., `"Coding, Dance, Debate"`)
* **Feedback Ratings**: `int[]` — one rating per event
* **Activity Log**: `LinkedList<String>` — entries in the format `"HH:mm|EventName"` indicating participation with a timestamp

The university aims to analyze this data to derive insights about:

* Student-level involvement
* Event popularity
* Feedback quality

---

## ✅ Functional Requirements

### **Requirement 1: Parse Events List**

* **Objective**: Extract the list of individual event names from the student's comma-separated event string.
* **Input**: `"Coding, Dance, Debate"`
* **Output**: `["Coding", "Dance", "Debate"]`
* **Implementation Rule**: Use `String` manipulation only (no external libraries).

---

### **Requirement 2: Calculate Average Feedback Score**

* **Objective**: Compute the average feedback rating per student from their given `int[]` of scores.
* **Input**: `[80, 90, 83]`
* **Output**: `84.33`
* **Implementation Rule**: Use **Java Streams** for calculation.

---

### **Requirement 3: Identify Unique Events Across All Students**

* **Objective**: Get a single sorted list of **distinct event names** from all student records.
* **Input**: Event lists from all students
* **Output**: `["Coding", "Dance", "Debate", "Drama", "Music", "Quiz"]`
* **Implementation Rule**: Use **Streams** for flattening, deduplication, and sorting.

---

### **Requirement 4: Generate Participation Timeline per Student**

* **Objective**: Sort the participation logs by time and reformat them per student.
* **Input**: `["10:00|Coding", "11:30|Dance", "14:00|Debate"]` for Alice
* **Output**:

  ```
  Alice - 10:00 - Coding  
  Alice - 11:30 - Dance  
  Alice - 14:00 - Debate  
  ```
* **Implementation Rule**: Use **LinkedList traversal** and **Streams** for sorting and formatting.

---

### **Requirement 5: Determine Most Common Event (Overall)**

* **Objective**: Identify the event that occurs most frequently across all students.
* **Input**: All student event lists
* **Output**: `"Coding"` (if it's the most frequent)
* **Implementation Rule**: Use **Streams** + `Collections.frequency()` or a `Map<String, Integer>` for counting.

---

## 📌 Input Constraints

To ensure valid analytics:

* **Minimum Students**: 5
* **Per Student**:

  * ≥ 3 events
  * ≥ 3 feedback scores
  * ≥ 3 participation log entries

---

## 🧪 Sample Output

```plaintext
Parsed Events:
Alice: [Coding, Dance, Debate]
Bob: [Music, Dance, Drama]
Charlie: [Coding, Music, Quiz]
Diana: [Drama, Debate, Quiz]
Eve: [Music, Coding, Dance]

Average Feedback:
Alice: 84.33
Bob: 87.0
Charlie: 78.0
Diana: 89.0
Eve: 65.0

Unique Events:
[Coding, Dance, Debate, Drama, Music, Quiz]

Participation Timeline:
Alice - 10:00 - Coding
Alice - 11:30 - Dance
Alice - 14:00 - Debate
Bob - 09:00 - Music
Bob - 12:00 - Dance
Bob - 13:30 - Drama
Charlie - 08:00 - Quiz
Charlie - 10:30 - Coding
Charlie - 15:00 - Music
Diana - 11:00 - Debate
Diana - 13:00 - Drama
Diana - 16:00 - Quiz
Eve - 10:00 - Music
Eve - 11:00 - Dance
Eve - 14:30 - Coding

Most Common Event:
Coding
```