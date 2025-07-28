package model;

import java.util.List;
import java.util.Map;

public class Employee {
    private static int idCounter;
    private int id;
    private String name;
    private String department;
    private List<String> skills;
    private Map<String, Integer> weeklyAvailabilityHours;

    public Employee(String name, String department, List<String> skills, Map<String, Integer> weeklyAvailabilityHours) {
        this.id = ++idCounter;
        this.name = name;
        this.department = department;
        this.skills = skills;
        this.weeklyAvailabilityHours = weeklyAvailabilityHours;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public List<String> getSkills() {
        return skills;
    }

    public Map<String, Integer> getWeeklyAvailabilityHours() {
        return weeklyAvailabilityHours;
    }

    @Override
    public String toString() {
        return name + " (" + id + ")";
    }
}
