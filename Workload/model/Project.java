package model;

import java.util.Map;
import java.util.Set;

public class Project {
    private int projectId;
    private String clientName;
    private int priority;
    private Set<String> requiredSkills;
    private Map<String, Integer> requiredHoursPerWeek;

    public Project(int projectId, String clientName, int priority, Set<String> requiredSkills, Map<String, Integer> requiredHoursPerWeek) {
        this.projectId = projectId;
        this.clientName = clientName;
        this.priority = priority;
        this.requiredSkills = requiredSkills;
        this.requiredHoursPerWeek = requiredHoursPerWeek;
    }

    public int getProjectId() {
        return projectId;
    }

    public String getClientName() {
        return clientName;
    }

    public int getPriority() {
        return priority;
    }

    public Set<String> getRequiredSkills() {
        return requiredSkills;
    }

    public Map<String, Integer> getRequiredHoursPerWeek() {
        return requiredHoursPerWeek;
    }

    @Override
    public String toString() {
        return clientName + " [P" + projectId + "]";
    }
}
