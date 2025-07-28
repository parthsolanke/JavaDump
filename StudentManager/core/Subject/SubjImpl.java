package core.Subject;

public abstract class SubjImpl{
    private String studentName;
    private String subjectName;
    private String subjType;
    private static int objCount;

    protected SubjImpl(String studentNameString, String subjNameString, String subjTypeString) {
        this.studentName = studentNameString;
        this.subjectName = subjNameString;
        this.subjType = subjTypeString;
        SubjImpl.objCount++;
    }

    public static int getObjCount() {
        return SubjImpl.objCount;
    }
    
    public String getStudentName() {
        return this.studentName;
    }

    public String getSubjName() {
        return this.subjectName;
    }

    public String getSubjType() {
        return this.subjType;
    }
}
