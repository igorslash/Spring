package aop;

import java.util.Objects;

public class Student {
    private String nameSurname;
    private int course;
    private double avgGrade;

    public Student(String nameSurname, int course, double avgGrade) {
        this.nameSurname = nameSurname;
        this.course = course;
        this.avgGrade = avgGrade;
    }

    public String getNameSurname() {
        return nameSurname;
    }

    public void setNameSurname(String nameSurname) {
        this.nameSurname = nameSurname;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public double getAvgGrade() {
        return avgGrade;
    }

    public void setAvgGrade(double avgGrade) {
        this.avgGrade = avgGrade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "nameSurname='" + nameSurname + '\'' +
                ", course=" + course +
                ", avgGrade=" + avgGrade +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return course == student.course && Double.compare(student.avgGrade, avgGrade) == 0
                && nameSurname.equals(student.nameSurname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameSurname, course, avgGrade);
    }
}
