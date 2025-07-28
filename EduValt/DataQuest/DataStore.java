import java.util.*;

public class DataStore {

    public static List<Student> getStudents() {
        return Arrays.asList(
            new Student("Alice", 88),
            new Student("Bob", 95),
            new Student("Charlie", 88),
            new Student("Diana", 76)
        );
    }

    public static List<Person> getPeople() {
        return Arrays.asList(
            new Person("Alice", 25, "New York"),
            new Person("Bob", 30, "Los Angeles"),
            new Person("Charlie", 25, "New York"),
            new Person("Diana", 35, "Chicago"),
            new Person("Eve", 30, "Chicago")
        );
    }

    public static List<Employee> getEmployees() {
        return Arrays.asList(
            new Employee("Alice", "Engineering", 85000),
            new Employee("Bob", "Engineering", 92000),
            new Employee("Charlie", "HR", 67000),
            new Employee("Diana", "HR", 78000),
            new Employee("Eve", "Marketing", 88000)
        );
    }

    public static List<Task> getTasks() {
        return Arrays.asList(
            new Task("T1", Arrays.asList()),
            new Task("T2", Arrays.asList("T1")),
            new Task("T3", Arrays.asList("T1")),
            new Task("T4", Arrays.asList("T2", "T3"))
        );
    }

    public static List<Double> getTemperatureReadings() {
        return Arrays.asList(23.5, 25.2, 21.8, 26.0, 24.3);
    }

    public static List<String> getWords() {
        return Arrays.asList("apple", "banana", "pear", "kiwi", "apricot", "avocado");
    }

    public static List<String> getDuplicateWords() {
        return Arrays.asList("apple", "banana", "pear", "kiwi", "apricot", "avocado", "apple", "apple", "banana", "kiwi");
    }

    public static List<List<Integer>> getNestedNumbers() {
        return Arrays.asList(
            Arrays.asList(1, 2, 3),
            Arrays.asList(3, 4),
            Arrays.asList(5, 6, 7)
        );
    }

    public static List<String> getEmails() {
        return Arrays.asList("alice@gmail.com", "bob@yahoo.com", "charlie@gmail.com", "diana@outlook.com");
    }

    public static Map<String, Integer> getQuizScores() {
        Map<String, Integer> map = new HashMap<>();
        map.put("Alice", 80);
        map.put("Bob", 85);
        map.put("Charlie", 90);
        return map;
    }

    public static Map<String, Integer> getAssignmentScores() {
        Map<String, Integer> map = new HashMap<>();
        map.put("Alice", 70);
        map.put("Bob", 95);
        map.put("Diana", 88);
        return map;
    }
}
