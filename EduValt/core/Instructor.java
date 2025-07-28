package core;

import java.util.HashSet;
import java.util.Set;

public class Instructor {
    private String name;
    private Set<Course> createdCourses = new HashSet<>();

    public Instructor(String name) {
        this.name = name;
    }

    public void createCourse(Course course) {
        if(!createdCourses.add(course)) {
            System.out.println("Course alredy exists!");
        }
        System.out.println("Created course" + course.getTitle() + "successfully!");
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
        Instructor other = (Instructor) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Course> getCreatedCourses() {
        return createdCourses;
    }

    public void setCreatedCourses(Set<Course> createdCourses) {
        this.createdCourses = createdCourses;
    }
}