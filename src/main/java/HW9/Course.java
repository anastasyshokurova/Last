package HW9;

import java.util.Objects;

public class Course {
    private String name;

    public Course (String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (!(o instanceof Course)) return false;
        Course course = (Course) o;
        return Objects.equals(getName(),course.getName());
    }

    @Override
    public String toString() {
        return "Course{" +
                "name'" + name+ '\''+
                '}';
    }
}
