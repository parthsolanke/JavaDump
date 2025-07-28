package core.Subject;

public class SubjLab extends SubjImpl implements SubjectInterface {
    private double score;

    public SubjLab(String studentNameString, String subjNameString, double score, String subjTypeString) {
        super(studentNameString, subjNameString, subjTypeString);
        this.score = score;
    }

    @Override
    public double computeScore() {
        return score;
    }
    
}
