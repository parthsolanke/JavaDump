package core.Report;

public class ReportGen implements ReportGenInterface{

    @Override
    public void getReport(String subjNameString, String studentNameString, String subjTypeString, double score){
        System.out.println("Subject: " + subjNameString + " Score: " + score);
        System.out.println(subjTypeString + " - " + subjNameString + " for " + studentNameString + ": Score = " + score);
        
        String result = score >= 50 ? "Pass" : "Fail";
        System.out.println("Result: " + result);
    }
}
