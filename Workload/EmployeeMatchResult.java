import model.Employee;

public class EmployeeMatchResult {
    private Employee employee;
    private int matchingSkillCount;
    private int availableHours;

    public EmployeeMatchResult(Employee employee, int matchingSkillCount, int availableHours) {
        this.employee = employee;
        this.matchingSkillCount = matchingSkillCount;
        this.availableHours = availableHours;
    }

    public Employee getEmployee() {
        return employee;
    }

    public int getMatchingSkillCount() {
        return matchingSkillCount;
    }

    public int getAvailableHours() {
        return availableHours;
    }

    @Override
    public String toString() {
        return employee.getName() + " - match: " + matchingSkillCount + ", available: " + availableHours;
    }
}
