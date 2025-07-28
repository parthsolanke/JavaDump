import java.util.HashSet;
import java.util.List;
import java.util.Map;

import core.Course;
import core.EduVault;
import core.Instructor;
import core.Lesson;
import core.Quiz;
import core.Student;
import core.Module;
import core.Difficulty;

public class Main {
    public static void main(String[] args) {
        // === Setup platform, instructor, student, course ===
        EduVault platform = new EduVault();
        Instructor instructor = new Instructor("Alice");
        platform.addInstructor(instructor);

        // Create students
        Student bob = new Student("Bob");
        Student alice = new Student("Alice");
        Student rahul = new Student("Rahul Mehta");

        // Create courses
        Course javaBasics = createCourse("Java Basics", Difficulty.BEGINNER, 25, 83.2);
        Course springBoot = createCourse("Spring Boot", Difficulty.INTERMEDIATE, 18, 79.5);

        // Register courses
        platform.createCourse(instructor, javaBasics);
        platform.createCourse(instructor, springBoot);

        // Enroll students
        for (int i = 0; i < 25; i++) {
            Student temp = new Student("Student" + i);
            platform.enrollCourse(temp, javaBasics);
        }

        for (int i = 0; i < 18; i++) {
            Student temp = new Student("User" + i);
            platform.enrollCourse(temp, springBoot);
        }

        // Enroll real students and set scores
        platform.enrollCourse(rahul, javaBasics); // Top performer
        platform.enrollCourse(alice, springBoot);
        platform.enrollCourse(bob, javaBasics);

        // Print Analytics
        System.out.println("\n=============== EDUVAULT COURSE ANALYTICS =================");

        // Total courses
        System.out.println("📘 Total Courses: " + platform.getAvailablCourses().size());

        // Enrollments
        System.out.println("👨‍🎓 Enrollments:");
        platform.getenrollments().forEach((title, count) ->
            System.out.println("  - " + title + ": " + count + " students")
        );

        // Average Quiz Score for a specific course (Java Basics)
        System.out.printf("\n📊 Avg Quiz Score (%s): %.1f\n", javaBasics.getTitle(), javaBasics.getAvgQuizScore());

        // Top Performer
        platform.getTopPerformer().forEach((name, score) ->
            System.out.printf("🥇 Top Performer: %s — Avg Score: %.1f\n", name, score)
        );

        // Most Popular Difficulty Level
        System.out.println("🔥 Most Popular Difficulty Level: " + platform.getPopularDifficulty());

        System.out.println("===========================================================\n");
    }

    // Helper to create a course with fake quiz scores
    private static Course createCourse(String title, Difficulty difficulty, int numStudents, double avgScore) {
        // Create dummy quizzes
        Quiz quiz = new Quiz("Final Quiz", Map.of("Q1", "A"), avgScore);

        // Module with one lesson and one quiz
        Lesson lesson = new Lesson("Lesson 1", "Content...");
        Module module = new Module(List.of(lesson), List.of(quiz));

        // Course with that module
        return new Course(title, difficulty, new HashSet<>(), List.of(module));
    }
}
