package core;

import java.util.HashSet;
import java.util.Set;

public class Student {
    private String name;
    private Set<Course> enrolledCourses = new HashSet<>();
    
    public Student(String name) {
        this.name = name;
    }

    public void enrollCourse(Course course) {
        if(!enrolledCourses.add(course)) {
            System.out.println("Alredy enrolled in course");
        }
        System.out.println("Successfully enrolled in" + course.getTitle());
    }

    public Double getAvgScore() {
        return enrolledCourses.stream()
        .flatMap(course -> course.getModuleList().stream())
        .flatMap(module -> module.getQuizList().stream())
        .mapToDouble(Quiz::getScore)
        .average()
        .orElse(0.0);
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Set<Course> getEnrolledCourses() {
        return enrolledCourses;
    }
    public void setEnrolledCourses(Set<Course> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
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
        Student other = (Student) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }
    
}