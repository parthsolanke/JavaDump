# 📄 Requirements Document: Student Performance Tracking System

---

## 1. **Overview**

This system is intended to track and evaluate student performance across multiple academic subjects using object-oriented principles. The system must support various types of subjects, each with unique score computation logic, and provide summarized reports for each subject undertaken by a student.

---

## 2. **Key Functional Requirements**

### 2.1. **Subject Tracking**

* The system must support **tracking multiple subjects** taken by a student.
* Each subject instance must maintain:

  * The **name of the student** taking the subject.
  * The **name of the subject** itself.
* The system must be capable of calculating a **performance score** for each subject.

### 2.2. **Subject Types**

* The system must include **at least two different types of subjects**:

  * **Theory-based Subject**
  * **Lab-based Subject**
* Each type of subject must define **its own logic** for computing the student's performance score.

### 2.3. **Score Calculation and Result Evaluation**

* Each subject must compute a **score** specific to the logic defined by its subject type.
* Based on the computed score, the system must determine whether the student has **passed or failed** the subject.

  * The exact passing criteria are not defined in the problem statement and must be determined as part of implementation logic (i.e., to be defined by the designer).

### 2.4. **Reporting**

* For each subject:

  * The system must output the **subject name**.
  * The **student’s score** in that subject.
  * A **result message** indicating either `"Pass"` or `"Fail"`.
  * The output must specify the subject type (e.g., "Theory - Mathematics", "Lab - Physics Lab").
  * The output must indicate which student took the subject.

* A **report** must be generated displaying this information for each subject instance.

### 2.5. **Subject Object Count**

* The system must track and display the **total number of subject objects created**.

  * This count must be printed **both before** and **after** subject instances are created.
  * The counter must increment for **every subject instance**, regardless of type.

---

## 3. **Non-Functional Requirements**

### 3.1. **Object-Oriented Design Compliance**

The system must incorporate and reflect key object-oriented programming (OOP) concepts, including:

* **Encapsulation**
* **Inheritance**
* **Interfaces** or **Abstract Classes** (for enforcing structure in subject types)
* **Polymorphism**
* **Modularity** (logically separated code in files, classes, or packages as applicable)

### 3.2. **Code Organization & Readability**

* Proper **naming conventions** must be followed (camelCase or PascalCase, consistently).
* Code must be **cleanly structured and modular**.
* Reusable components must be prioritized.

---

## 4. **User Interaction Requirements**

* Input or interaction mechanisms (if any) are not specified in the problem.
* The **output must clearly show**:

  * Subject name
  * Subject type (Theory/Lab)
  * Student name
  * Score
  * Result ("Pass"/"Fail")
  * Total subject count (before and after subject creation)

### 4.1. **Example Output Format**

```
Total subjects created: 0

Subject: Mathematics Score: 87.5  
Theory - Mathematics for Alice: Score = 87.5 Result: Pass

Subject: Physics Lab Score: 66.0  
Lab - Physics Lab for Alice: Score = 66.0 Result: Pass

Total subjects created: 2
```

> ✳️ The example above is a reference for output format and required data points only; actual scores and logic are to be determined in implementation.

---

## 5. **Constraints**

* At least **one theory-based** and **one lab-based** subject must be implemented.
* Subject types **must have differing logic** for score computation.
* Each subject object must include both **student name** and **subject name**.
* The total number of subjects must be counted and reported accurately.

---

## 6. **Out of Scope**

* User input handling (CLI, GUI, or form) is not specified and may be assumed unnecessary unless explicitly required.
* No external data storage (e.g., databases or files) is required or implied.
* No real-time or web-based functionality is required.
* There is no requirement to persist subject data across sessions.

---

## 7. **Assumptions**

* "Pass/Fail" criteria are to be defined based on score thresholds during implementation.
* One student may be taking multiple subjects, and the system should handle this without limitation.
* There is no requirement to handle invalid data, as no user input is described.
