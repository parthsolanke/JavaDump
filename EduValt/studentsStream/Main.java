import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        students.add(new Student(
            "Alice",
            "Coding,Dance,Debate",
            new int[]{85, 90, 78},
            new LinkedList<>(Arrays.asList("10:00|Coding", "11:30|Dance", "14:00|Debate"))
        ));

        students.add(new Student(
            "Bob",
            "Music,Dance,Drama",
            new int[]{88, 86, 87},
            new LinkedList<>(Arrays.asList("09:00|Music", "12:00|Dance", "13:30|Drama"))
        ));

        students.add(new Student(
            "Charlie",
            "Coding,Music,Quiz",
            new int[]{70, 85, 79},
            new LinkedList<>(Arrays.asList("08:00|Quiz", "10:30|Coding", "15:00|Music"))
        ));

        students.add(new Student(
            "Diana",
            "Drama,Debate,Quiz",
            new int[]{90, 91, 86},
            new LinkedList<>(Arrays.asList("11:00|Debate", "13:00|Drama", "16:00|Quiz"))
        ));

        students.add(new Student(
            "Eve",
            "Music,Coding,Dance",
            new int[]{60, 70, 65},
            new LinkedList<>(Arrays.asList("10:00|Music", "11:00|Dance", "14:30|Coding"))
        ));

        // 1.
        System.out.println("\nList of events: " + students.get(0).extractEventsList());

        // 2.
        System.out.println("\nAvg feedback score per student: " + students.stream()
        .collect(Collectors.toMap(Student::getName, Student::getAvgFeedbackRatings)));

        // 3.
        System.out.println("\nUnique events: " + students.stream()
        .flatMap(s -> s.extractEventsList().stream())
        .distinct()
        .toList());

        // 4.
        System.out.println("\nParticipation Timeline: ");

        students.stream()
            .sorted(Comparator.comparing(Student::getName))
            .flatMap(student -> student.getActivityLog().stream()
                .sorted(Comparator.comparing(entry -> entry.split("\\|")[0]))
                .map(entry -> {
                    String[] parts = entry.split("\\|");
                    return student.getName() + " - " + parts[0] + " - " + parts[1];
                })
            )
            .forEach(System.out::println);

        // 5.
        System.out.println("\nEvents map: " + students.stream()
        .flatMap(s -> s.extractEventsList().stream())
        .collect(Collectors.groupingBy(
            e -> e,
            Collectors.counting()
        )));

    }
}
