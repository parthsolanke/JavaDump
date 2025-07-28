import java.util.Arrays;
import java.util.List;

public class DataProvider {

    public static List<Freelancer> getSampleFreelancers() {
        return Arrays.asList(
            new Freelancer(1, "Alice", "Design", Arrays.asList(
                new Project("P1", "Acme Corp", 30, 50000, 85),
                new Project("P2", "Globex", 20, 40000, 90)
            )),
            new Freelancer(2, "Bob", "Development", Arrays.asList(
                new Project("P4", "Acme Corp", 35, 80000, 95),
                new Project("P5", "Umbrella", 50, 120000, 100),
                new Project("P6", "Cyberdyne", 45, 100000, 88)
            )),
            new Freelancer(3, "Charlie", "Writing", Arrays.asList(
                new Project("P7", "Initech", 25, 30000, 55),
                new Project("P8", "Soylent", 20, 25000, 60),
                new Project("P9", "Hooli", 15, 20000, 45)
            )),
            new Freelancer(4, "Diana", "Development", Arrays.asList(
                new Project("P10", "Acme Corp", 30, 85000, 92),
                new Project("P11", "Globex", 33, 92000, 91),
                new Project("P12", "WayneTech", 40, 110000, 89)
            )),
            new Freelancer(5, "Eve", "Design", Arrays.asList(
                new Project("P13", "Oscorp", 20, 45000, 77),
                new Project("P14", "LexCorp", 25, 48000, 69),
                new Project("P15", "Hooli", 15, 40000, 85)
            ))
        );
    }
}
