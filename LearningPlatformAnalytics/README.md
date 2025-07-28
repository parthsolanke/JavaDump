# 🎓 Learning Platform Analytics

This Java project analyzes student engagement, course effectiveness, and review trends on an online learning platform (like Coursera/Udemy).

## 🧩 Context

Entities include:

- `Student`: studentId, name, country
- `Course`: courseId, title, category, duration
- `Enrollment`: enrollmentId, student, course, progress, review
- `Review`: rating, feedback

## ✅ Functional Requirements

### Engagement & Progress
1. Top N most engaged students (based on avg progress)
2. Avg completion rate per course
3. Country-wise average rating
4. Inactive students (progress < 20%)

### Course Insights
5. Category-wise course count + total duration
6. Most reviewed course per category
7. Courses with median completion rate

### Filtering & Exploration
8. Students who rated any course < 2.0
9. Courses where ≥75% students completed ≥50%
10. Course summary:
   - Total enrollments
   - Avg rating
   - % completion (100%)

## 🛠 Tech Stack
- Java 17
- Java Streams, Lambdas, Collectors
- Object-Oriented Design (OOP)

> Start in `PlatformAnalytics.java` under `com.example.analytics` package.
