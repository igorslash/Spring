package aop.aspects;

import aop.Student;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Aspect
public class AfterReturningThrowingUniversityLogin {
    @Before("execution(* getStudents())")
    public void beforeGetStudentsLoginAdvice() {
        System.out.println("login lists students перед методом getStudents");
    }
    @AfterReturning(pointcut = "execution(* getStudents())", returning = "students")
    public void afterReturningGetStudentsLoginAdvice(List<Student>students) {
        Student firstStudent = students.get(0);//получаем первого студента
        String nameSurname = firstStudent.getNameSurname();
        nameSurname = "Mr" + nameSurname;
        firstStudent.setNameSurname(nameSurname);
        double averageGrade = firstStudent.getAvgGrade();
        averageGrade = averageGrade + 1;
        firstStudent.setAvgGrade(averageGrade);
        System.out.println("afterReturningGetStudentsLoginAdvice" +
                "login lists students после работы  метода getStudents");
    }

    @AfterThrowing(pointcut = "execution(* getStudents())", throwing = "exeption")//обработка исключения
    public void afterThrowingGetStudentsLoginAdvice(Throwable exeption) {
        System.out.println("exeption" + exeption.getMessage());
    }

}
