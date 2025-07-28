package core;

import java.util.ArrayList;
import java.util.List;

public class Participant implements Comparable<Participant> {
    public static final int MAX_SCORE_PER_ROUND = 100; // 1.
    private static long idcounter;

    private long id;
    private String name;
    private String department;
    private List<Integer> scores = new ArrayList<>();

    public Participant(String name, String department, List<Integer> scores) throws Exception {
        if (scores.size() != 3) {
            throw new IllegalArgumentException("Each participant must have exactly 3 scores.");
        }
        this.id = ++idcounter;
        this.name = name;
        this.department = department;
        this.scores = scores;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public List<Integer> getScores() {
        return scores;
    }

    @Override
    public int compareTo(Participant o) {
        double thisAvg = this.scores.stream().mapToInt(Integer::intValue).average().orElse(0);
        double oAvg = o.scores.stream().mapToInt(Integer::intValue).average().orElse(0);

        int result = Double.compare(oAvg, thisAvg);
        return result == 0 ? this.name.compareTo(o.name) : result;
    }

    @Override
    public String toString() {
        return "Participant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", scores=" + scores +
                '}';
    }

}