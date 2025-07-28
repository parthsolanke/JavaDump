package core;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class EduVault {
    private Set<Course> availablCourses = new HashSet<>();
    private Set<Student> students = new HashSet<>();
    private Set<Instructor> instructors = new HashSet<>();

    public void addInstructor(Instructor instructor) {
        if(!instructors.add(instructor)) {
            System.out.println("Instructor alredy exists!");
        }
        instructors.add(instructor);
    }

    public Map<String, Integer> getenrollments() {
        Map<String, Integer> enrollments = new HashMap<>();
        for(Course course: availablCourses) {
            enrollments.put(course.getTitle(), course.getEnrolledStudents().size());
        }
        return enrollments;
    }

    private Map<Difficulty, Integer> getDifficultyLevelPopularutyMap() {
        Map<Difficulty, Integer> diffMap = new HashMap<>();
        for(Course course: availablCourses) {
            Difficulty difficulty = course.getDifficulty();
            diffMap.put(difficulty, diffMap.getOrDefault(difficulty, 0) + course.getEnrolledStudents().size());
        }

        return diffMap;
    }
    
    public Difficulty getPopularDifficulty() {
        Map<Difficulty, Integer> diffcount = getDifficultyLevelPopularutyMap();
        Difficulty popular = null;
        int max = 0;

        for(Map.Entry<Difficulty, Integer> entry: diffcount.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                popular = entry.getKey();
            }
        }

        return popular;
    }

    public Map<String, Double> getStudentAvgScoreMap() {
        return students.stream()
        .collect(Collectors.toMap(student -> student.getName(), student -> student.getAvgScore()));
    }

    public Map<String, Double> getTopPerformer() {
        return getStudentAvgScoreMap()
        .entrySet()
        .stream()
        .max(Map.Entry.comparingByValue())
        .map(entry -> Map.of(entry.getKey(), entry.getValue()))
        .orElse(Map.of());
    }

    public void enrollCourse(Student student, Course course) {
        if (availablCourses.contains(course)) {
            student.enrollCourse(course);
            students.add(student);
            System.out.println(student.getName() + "successfully enrolled into: " + course.getTitle());
        }
        System.out.println("Course unavailable!");
    }

    public void createCourse(Instructor instructor, Course course) {
        if(this.instructors.contains(instructor)) {
            availablCourses.add(course);
            instructor.createCourse(course);
        }
        System.out.println("Instructor dosent exist!");
    }

    public Set<Course> getAvailablCourses() {
        return availablCourses;
    }

    public void setAvailablCourses(Set<Course> availablCourses) {
        this.availablCourses = availablCourses;
    }

    public Set<Instructor> getInstructors() {
        return instructors;
    }

    public void setInstructors(Set<Instructor> instructors) {
        this.instructors = instructors;
    }

}
