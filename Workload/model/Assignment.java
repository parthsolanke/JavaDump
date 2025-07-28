package model;

import java.util.Map;

public class Assignment {
    private int employeeId;
    private int projectId;
    private Map<String, Integer> hoursPerWeek;

    public Assignment(int employeeId, int projectId, Map<String, Integer> hoursPerWeek) {
        this.employeeId = employeeId;
        this.projectId = projectId;
        this.hoursPerWeek = hoursPerWeek;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public int getProjectId() {
        return projectId;
    }

    public Map<String, Integer> getHoursPerWeek() {
        return hoursPerWeek;
    }
}
