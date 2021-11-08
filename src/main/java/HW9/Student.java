package HW9;

import java.util.List;

public class Student {
    private String name;
    private List <Course> allCourses;
    public Student  (String name,List <Course> allCourses) {
        this.name = name;
        this.allCourses = allCourses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Course> getAllCourses() {
        return allCourses;
    }

    public void setAllCourses(List<Course> allCourses) {
        this.allCourses = allCourses;
    }
    @Override
    public String toString() {
        return "Student{"+
                "name='" + name + '\''+
                ", allCourses=" + allCourses+
                '}';
    }
}
