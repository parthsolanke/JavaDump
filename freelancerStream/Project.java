public class Project {
    private String projectId;
    private String client;
    private int durationInDays;
    private int budget;
    private int rating;

    public Project(String projectId, String client, int durationInDays, int budget, int rating) {
        this.projectId = projectId;
        this.client = client;
        this.durationInDays = durationInDays;
        this.budget = budget;
        this.rating = rating;
    }

    // Getters
    public String getProjectId() {
        return projectId;
    }

    public String getClient() {
        return client;
    }

    public int getDurationInDays() {
        return durationInDays;
    }

    public int getBudget() {
        return budget;
    }

    public int getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return projectId + " (" + client + ", " + rating + ")";
    }
}
