package core;

import java.util.HashMap;
import java.util.Map;

public class Quiz {
    private String title;
    private Map<String, String> mcq = new HashMap<>();
    private double score;

    public Quiz(String title, Map<String, String> mcq, double score) {
        this.title = title;
        this.mcq = mcq;
        this.score = score;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Map<String, String> getMcq() {
        return mcq;
    }

    public void setMcq(Map<String, String> mcq) {
        this.mcq = mcq;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

}