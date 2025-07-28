package core;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



public class Course {
    private String title;
    private Difficulty difficulty;
    private Set<Student> enrolledStudents = new HashSet<>();
    private List<Module> moduleList = new ArrayList<>();
    
    public Course(String title, Difficulty difficulty, Set<Student> enrolledStudents, List<Module> moduleList) {
        this.title = title;
        this.difficulty = difficulty;
        this.enrolledStudents = enrolledStudents;
        this.moduleList = moduleList;
    }

    public double getAvgQuizScore() {
        int ct = 0;
        double total = 0;

        for (Module module: moduleList) {
            for (Quiz quiz: module.getQuizList()) {
                total += quiz.getScore();
                ct++;
            }
        }

        return ct == 0 ? 0.0 : total / ct;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public Set<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public void setEnrolledStudents(Set<Student> enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
    }

    public List<Module> getModuleList() {
        return moduleList;
    }

    public void setModuleList(List<Module> moduleList) {
        this.moduleList = moduleList;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        result = prime * result + ((moduleList == null) ? 0 : moduleList.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Course other = (Course) obj;
        if (title == null) {
            if (other.title != null)
                return false;
        } else if (!title.equals(other.title))
            return false;
        if (moduleList == null) {
            if (other.moduleList != null)
                return false;
        } else if (!moduleList.equals(other.moduleList))
            return false;
        return true;
    }
}