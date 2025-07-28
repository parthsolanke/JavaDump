import java.util.*;

class Student {
    private String name;
    private String eventsAttended;
    private int[] feedbackRatings;
    private LinkedList<String> activityLog; // Each entry: "HH:mm|EventName"
    public Student(String name, String eventsAttended, int[] feedbackRatings, LinkedList<String> activityLog) {
        this.name = name;
        this.eventsAttended = eventsAttended;
        this.feedbackRatings = feedbackRatings;
        this.activityLog = activityLog;
    }

    public String getName() {
        return name;
    }

    public double getAvgFeedbackRatings() {
        return Arrays.stream(feedbackRatings).average().orElse(0.0);
    }

    public List<String> extractEventsList() {
        return Arrays.asList(eventsAttended.split(","));
    }

    public String getEventsAttended() {
        return eventsAttended;
    }

    public int[] getFeedbackRatings() {
        return feedbackRatings;
    }

    public LinkedList<String> getActivityLog() {
        return activityLog;
    }

    @Override
    public String toString() {
        return "Student{name='" + name + '\'' +
                ", eventsAttended=" + Arrays.asList(eventsAttended.split(",")) +
                ", feedbackRatings=" + Arrays.toString(feedbackRatings) +
                ", activityLog=" + activityLog +
                '}';
    }
}
