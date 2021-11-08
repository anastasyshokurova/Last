package HW9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Ivan",
                Arrays.asList(new Course("Biology"),
                                 new Course("Mathematics"))));
        studentList.add(new Student("Mike",
                Arrays.asList(new Course("Biology"),
                              new Course("History"),
                              new Course("Design"),
                              new Course("French"))));
        studentList.add(new Student("Nicolas",
                Arrays.asList(new Course("English"),
                                 new Course("History"),
                                 new Course("Mathematics"))));
        studentList.add(new Student("Angelina",
                Arrays.asList(new Course("French"),
                                 new Course("Design"),
                                 new Course ("Literature"))));
        System.out.println(studentList.stream()
                .map(s-> s.getAllCourses())
                .flatMap(c-> c.stream())
                .map(n-> n.getName())
                .distinct()
                .collect(Collectors.toList())
        );

        System.out.println(studentList.stream()
                .sorted((c1,c2) -> c2.getAllCourses().size() - c1.getAllCourses().size())
                .limit(3)
                .map(s-> s.getName())
                .collect(Collectors.toList())
        );

        System.out.println(studentList.stream()
                .filter(s-> s.getAllCourses().contains(new Course("Biology")))
                .map(s->s.getName())
                .collect(Collectors.toList())
        );

    }
}
