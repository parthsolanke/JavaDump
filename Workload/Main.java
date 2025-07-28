import model.*;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static List<EmployeeMatchResult> recommendEmployeesForProject(Project project, List<Employee> employees, String week) {
        return employees.stream()
                .filter(e -> e.getWeeklyAvailabilityHours().getOrDefault(week, 0) >= 10)
                .filter(e -> e.getDepartment().equalsIgnoreCase("Backend"))
                .map(
                        employee -> {
                            Set<String> reqSkills = project.getRequiredSkills();
                            int matches = (int) employee.getSkills().stream()
                                    .filter(reqSkills::contains)
                                    .count();
                            int available = employee.getWeeklyAvailabilityHours().getOrDefault(week, 0);
                            return new EmployeeMatchResult(employee, matches, available);
                        }
                )
                .filter(emr -> emr.getAvailableHours() >= 10)
                .sorted(Comparator.comparing(EmployeeMatchResult::getMatchingSkillCount).reversed()
                        .thenComparing(EmployeeMatchResult::getAvailableHours).reversed())
                .limit(3)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("Alice", "Backend", List.of("Java", "SQL", "Docker"),
                        Map.of("2025-W30", 30, "2025-W31", 25)),
                new Employee("Bob", "Frontend", List.of("React", "JavaScript"),
                        Map.of("2025-W30", 40, "2025-W31", 40)),
                new Employee("Charlie", "DevOps", List.of("AWS", "Terraform", "Docker"),
                        Map.of("2025-W30", 20, "2025-W31", 35)),
                new Employee("Diana", "Backend", List.of("Java", "Spring", "Kafka"),
                        Map.of("2025-W30", 15, "2025-W31", 10))
        );

        List<Project> projects = List.of(
                new Project(101, "ClientA", 1, Set.of("Java", "SQL"),
                        Map.of("2025-W30", 60, "2025-W31", 50)),
                new Project(102, "ClientB", 2, Set.of("React", "JavaScript"),
                        Map.of("2025-W30", 40, "2025-W31", 40)),
                new Project(103, "ClientC", 3, Set.of("AWS", "Docker"),
                        Map.of("2025-W30", 30, "2025-W31", 30))
        );

        List<Assignment> assignments = List.of(
                new Assignment(1, 101, Map.of("2025-W30", 20, "2025-W31", 20)),
                new Assignment(2, 102, Map.of("2025-W30", 30, "2025-W31", 30)),
                new Assignment(3, 103, Map.of("2025-W30", 25, "2025-W31", 25)),
                new Assignment(4, 101, Map.of("2025-W30", 15, "2025-W31", 10))
        );

        // 1.
        System.out.println(recommendEmployeesForProject(projects.get(0), employees, "2025-W30").toString());

        // 2.
        Map<String, Integer> totalProjectHoursPerWeek = projects.stream()
                .flatMap(p -> p.getRequiredHoursPerWeek().entrySet().stream())
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey,
                        Collectors.summingInt(Map.Entry::getValue)
                ));
        System.out.println(totalProjectHoursPerWeek.toString());

        Map<Integer, Integer> employeeHoursPerWeek = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getId,
                        Collectors.summingInt(e -> e.getWeeklyAvailabilityHours().entrySet().stream().mapToInt(Map.Entry::getValue).sum())
                ));
        System.out.println(employeeHoursPerWeek.toString());

        // 3.
        Map<String, Set<String>> skillsPerDepartment = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.flatMapping(
                                e -> e.getSkills().stream(),
                                Collectors.toSet()
                        )
                ));
        System.out.println(skillsPerDepartment);


    }
}
