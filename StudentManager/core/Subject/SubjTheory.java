package core.Subject;

public class SubjTheory extends SubjImpl implements SubjectInterface {
    private double score;

    public SubjTheory(String studentNameString, String subjNameString, double score, String subjTypeString) {
		super(studentNameString, subjNameString, subjTypeString);
        this.score = score;
	}

	@Override
    public double computeScore() {
        return score;
    }

}
