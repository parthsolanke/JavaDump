import java.util.List;

public class Freelancer implements Comparable<Freelancer> {
    private int id;
    private String name;
    private String category;
    private List<Project> projects;

    public Freelancer(int id, String name, String category, List<Project> projects) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.projects = projects;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public double getAvgProjectRating() {
        return projects.stream()
        .mapToInt(Project::getRating)
        .average()
        .orElse(0.0);

    }

    @Override
    public int compareTo(Freelancer other) {
        int res = Double.compare(other.getAvgProjectRating(), this.getAvgProjectRating());
        return res == 0 ? this.getName().compareTo(other.getName()) : res;
    }

    @Override
    public String toString() {
        return id + " - " + name + " (" + category + ")";
    }
}
