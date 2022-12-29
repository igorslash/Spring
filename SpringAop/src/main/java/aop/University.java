package aop;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class University {
    private List<Student>students = new ArrayList<>();

    public void addStudents() {
        Student s1 = new Student("igor", 2, 5.2);
        Student s2 = new Student("Maxim", 1, 4.5);
        Student s3 = new Student("Denis", 1, 5.8);
        students.add(s1);
        students.add(s2);
        students.add(s3);
    }

    public List<Student> getStudents() {
        System.out.println("information students");
        System.out.println(students.get(3));
        System.out.println(students);
        return students;
    }
}
