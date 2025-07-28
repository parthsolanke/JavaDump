import java.util.*;

public class Task {
    private final String id;
    private final List<String> dependencies;

    public Task(String id, List<String> dependencies) {
        this.id = id;
        this.dependencies = dependencies;
    }

    public String getId() { return id; }
    public List<String> getDependencies() { return dependencies; }

    @Override
    public String toString() {
        return id + " -> " + dependencies;
    }
}
