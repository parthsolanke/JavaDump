# 📘 Participant Data Analysis - Project Specification

## 🔍 Problem Statement

You are given participant data from a competitive event. Each participant record includes:

* **ID**: An integer uniquely identifying the participant.
* **Name**: A string representing the participant’s name.
* **Department**: A string indicating the department to which the participant belongs.
* **Scores**: A list of integers, each representing the participant’s score in a round.

Your task is to perform a series of analytical operations on this dataset.

---

## 📂 Context & Requirements

This document outlines the operations and constraints to be implemented in code, along with best practice suggestions (e.g., use of `Streams`, `Comparable`, `Comparator`, `final`, etc.).

---

## ✅ Requirements & Rules

### 🔢 Requirement 1: Maximum Score Constant

* **Description**: Define a maximum possible score per round (e.g., 100).
* **Rule**: Use `final` to declare this constant.

---

### 📊 Requirement 2: Sort by Performance

* **Description**: Sort participants by their **average score in descending order**. If average scores are equal, sort by **name in ascending order**.
* **Rule**: Implement the `Comparable` interface to define this natural ordering.

---

### 🏢 Requirement 3: Sort by Department and ID

* **Description**: Sort participants first by **department (ascending)**, and then by **ID (ascending)**.
* **Rule**: Use a `Comparator` for this secondary sorting criteria.

---

### 🥇 Requirement 4: Get Top N Participants

* **Description**: Retrieve the **names** of the top N participants, sorted by average score (as defined in Requirement 2).
* **Rule**: Use Java `Streams` for filtering, sorting, and collecting the result.

---

### 📈 Requirement 5: Department-Wise Average Score

* **Description**: Compute the **average participant score for each department**.
* **Rule**: Use `Streams` to group by department and calculate the average.

---

### 📐 Requirement 6: Normalized Scores

* **Description**: Generate a **flat list** of all participant scores normalized to a 0–100 scale using the **maximum score in the dataset**.
* **Rule**: Use `Streams` to flatten the scores and normalize accordingly.

---

### 🔤 Requirement 7: List All Unique Participant Names Alphabetically

* **Description**: Produce a **sorted list of unique participant names** in **alphabetical order**.
* **Rule**: Use `Streams` to extract, deduplicate, and sort the names.

---

### 🗂 Requirement 8: Group Participants by Department

* **Description**: Group all participants into a **map** where:

  * **Key** = department
  * **Value** = list of participants in that department
* **Rule**: Use `Streams` and `Collectors.groupingBy`.

---

### ✅ Requirement 9: Find Participants Who Passed All Rounds

* **Description**: Return the **names** of participants who scored **at least 40 in all rounds**.
* **Rule**: Use `Streams` and `allMatch` to filter such participants.

---

### 🎯 Requirement 10: Find Participants With At Least One Perfect Score

* **Description**: Identify participants who scored **exactly the maximum score** (e.g., 100) in **at least one round**.
* **Rule**: Use `Streams` and `anyMatch` for filtering.

---

### 🚫 Requirement 11: Count of Failing Participants Per Department

* **Description**: A participant is considered **failing** if **any score** is **below 40**. Return a **map** of:

  * **Key** = department
  * **Value** = number of failing participants in that department
* **Rule**: Use `Streams` and appropriate collectors for grouping and counting.

---

## 💡 Notes

* Ensure immutability where applicable.
* Follow good object-oriented design principles.
* Use Java’s functional programming features (`Streams`, `Collectors`, `Optional`, etc.) effectively.
* Include unit tests for each requirement for validation and debugging.
