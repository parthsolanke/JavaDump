
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PlatformAnalytics {
    public static void main(String[] args) {
        Student alice = new Student("S1", "Alice", "India");
        Student bob = new Student("S2", "Bob", "USA");
        Student charlie = new Student("S3", "Charlie", "UK");

        Course java = new Course("C1", "Java Programming", "Programming", 180);
        Course ux = new Course("C2", "UX Design", "Design", 120);
        Course sales = new Course("C3", "Sales Fundamentals", "Business", 90);

        List<Enrollment> enrollments = Arrays.asList(
            new Enrollment("E1", alice, java, LocalDateTime.of(2025, 7, 1, 10, 0), List.of(10, 40, 100), new Review(4.5, "Great!")),
            new Enrollment("E2", bob, java, LocalDateTime.of(2025, 7, 2, 9, 0), List.of(10, 25, 60), new Review(3.0, "Good but long")),
            new Enrollment("E3", bob, ux, LocalDateTime.of(2025, 7, 3, 12, 0), List.of(10, 20, 30), null),
            new Enrollment("E4", charlie, sales, LocalDateTime.of(2025, 7, 4, 14, 0), List.of(50, 70, 100), new Review(5.0, "Perfect!")),
            new Enrollment("E5", alice, ux, LocalDateTime.of(2025, 7, 5, 16, 0), List.of(10, 11, 12), null),
            new Enrollment("E6", charlie, java, LocalDateTime.of(2025, 7, 6, 17, 0), List.of(5, 10, 15), new Review(1.5, "Too basic"))
        );

        // TODO: Top N Most Engaged Students
        System.out.println("Top 3 most engaged students: " + enrollments.stream()
        .filter((enrollment) -> {
            return enrollment.getAvgProgress() > 20;
        })
        .sorted(Comparator.comparingDouble(Enrollment::getAvgProgress).reversed())
        .limit(3)
        .map((enrollment) -> {
            return enrollment.getStudent().getName() + "|" + enrollment.getAvgProgress();
        })
        .toList()
        );

        // TODO: Average Completion Rate per Course
        System.out.println("\nAvg completion rate per course: " + enrollments.stream()
        .collect(Collectors.groupingBy(
            e -> e.getCourse().getTitle(),
            Collectors.averagingDouble(Enrollment::getAvgProgress)
        ))
        );

        // TODO: Country-wise Average Rating
        System.out.println("\nAvg completion rate per country: " + enrollments.stream()
        .collect(Collectors.groupingBy(
            e -> e.getStudent().getCountry(),
            Collectors.averagingDouble(Enrollment::getAvgProgress)
        ))
        );

        // TODO: List Inactive Students
        System.out.println("\nList of Inactive students: " + enrollments.stream()
        .filter((enrollment) -> {
            return enrollment.getAvgProgress() < 20;
        })
        .map(e -> e.getStudent().getName())
        .toList()
        );

        // * TODO: Category-wise Course Count and Duration
        System.out.println("\nCategory wise count and duration: " + enrollments.stream()
        .collect(
            Collectors.groupingBy(
                e -> e.getCourse().getCategory(),
                Collectors.collectingAndThen(
                    Collectors.toList(),
                    l -> {
                        return l.stream().map(Enrollment::getCourse).distinct().count() + "|" + l.stream().map(e -> e.getCourse()).distinct().mapToInt(Course::getDurationMinutes).sum();
                    }
                )
            )
        ));

        // TODO: Most Reviewed Course per Category
        System.out.println("\nMost reviewed course per category: " + enrollments.stream()
        .filter(e -> e.getReview() != null)
        .collect(Collectors.groupingBy(
            e -> e.getCourse().getCategory(),
            Collectors.collectingAndThen(
                Collectors.groupingBy(
                    e -> e.getCourse().getTitle(),
                    Collectors.counting()
                ), 
                courseCountMap -> courseCountMap.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("N/A")
                )
        ))
        );

        // TODO: Courses with Median Completion Rate

        // TODO: Students Who Rated Below 2.0
        System.out.println("\nstudent rating any course below 2.0: " + enrollments.stream()
        .filter(e -> e.getReview() != null && e.getReview().getRating() < 2.0)
        .map((enrollment) -> {
            return enrollment.getStudent().getName();
        })
        .collect(Collectors.toList())
        .toString()
        );

        // TODO: Courses with >=50% Completion by >=75% Students

        // TODO: Summary per Course
    }
}