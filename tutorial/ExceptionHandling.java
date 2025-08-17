package tutorial;

// Custom Checked Exception
class CourseFullException extends Exception {
    public CourseFullException(String message) {
        super(message);
    }
}

// Custom Unchecked Exception
class InvalidCourseCodeException extends RuntimeException {
    public InvalidCourseCodeException(String message) {
        super(message);
    }
}

class Course {
    private String code;
    private int capacity;
    private int enrolled;

    public Course(String code, int capacity) {
        if (code == null || code.length() < 3) {
            // runtime exception (unchecked)
            throw new InvalidCourseCodeException("Course code must be at least 3 characters long.");
        }
        this.code = code;
        this.capacity = capacity;
        this.enrolled = 0;
    }

    // Method that throws a checked exception
    public void registerStudent(String studentName) throws CourseFullException {
        if (enrolled >= capacity) {
            throw new CourseFullException("Course " + code + " is already full!");
        }
        enrolled++;
        System.out.println(studentName + " registered for " + code);
    }

    public void printStatus() {
        System.out.println("Course " + code + ": " + enrolled + "/" + capacity + " students enrolled.");
    }
}

public class ExceptionHandling {
    public static void main(String[] args) {
        try {
            Course java101 = new Course("CS1", 2);

            // checked exception must be handled
            try {
                java101.registerStudent("Alice");
                java101.registerStudent("Bob");
                java101.registerStudent("Charlie");  // will throw CourseFullException
            } catch (CourseFullException e) {
                System.out.println("⚠ " + e.getMessage());
            }

            // runtime exception (unchecked) → no compiler enforcement
            Course badCourse = new Course("AB", 10);

            // finally block always runs
            finallyExample();

            // try-with-resources (AutoCloseable)
            tryWithResourcesExample();

        } catch (InvalidCourseCodeException e) {
            System.out.println("❌ Invalid course code: " + e.getMessage());
        } finally {
            System.out.println("🎓 End of course registration process.");
        }
    }

    static void finallyExample() {
        try {
            System.out.println("Doing something risky...");
            int x = 10 / 0;  // will throw ArithmeticException
        } catch (ArithmeticException e) {
            System.out.println("Caught arithmetic error: " + e.getMessage());
        } finally {
            System.out.println("✅ finally block always executes (cleanup code here).");
        }
    }

    static void tryWithResourcesExample() {
        // AutoCloseable resource (Scanner in this case)
        try (java.util.Scanner sc = new java.util.Scanner("Alice\nBob")) {
            while (sc.hasNextLine()) {
                System.out.println("Reading student: " + sc.nextLine());
            }
        } // sc.close() is called automatically
    }
}
