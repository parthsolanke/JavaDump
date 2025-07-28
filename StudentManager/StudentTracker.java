import core.Subject.*;
import core.Report.ReportGen;

public class StudentTracker {
    public static void main(String[] args) {
        System.out.println(SubjImpl.getObjCount());

        SubjTheory scienceTheory = new SubjTheory("Science", "Parth", 90.0, "Theory");
        SubjLab scienceLab = new SubjLab("Science", "Parth", 90.0, "Practical");

        ReportGen report = new ReportGen();

        report.getReport(scienceTheory.getSubjName(), scienceTheory.getStudentName(), scienceTheory.getSubjType(), scienceTheory.computeScore());
        report.getReport(scienceLab.getSubjName(), scienceLab.getStudentName(), scienceLab.getSubjType(), scienceLab.computeScore());

        System.out.println(SubjImpl.getObjCount());
    }
}
