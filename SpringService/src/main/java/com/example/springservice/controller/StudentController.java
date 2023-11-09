package com.example.springservice.controller;

import com.example.springservice.model.Student;
import com.example.springservice.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@AllArgsConstructor
public class StudentController {

    private final StudentService studentService;
    @GetMapping
    public List<Student> getAllStudents() {
        //TODO
       return studentService.getAllStudents();
    }
    @PostMapping("/save_student")
    public String saveStudent(@RequestBody Student student) {
        studentService.saveStudent(student);
        return "Saved Successfully";
    }
    @GetMapping("/{email}")///api/v1/students/email student
    public Student findStudentEmail(@PathVariable("email") String email) {
        return studentService.findByEmail(email);
    }
    @PutMapping("/update_student")
    public Student updateStudent(@RequestBody Student student) {
        return studentService.updateStudent(student);
    }
    @DeleteMapping("/delete_student/{email}")
    public void deleteStudent(@PathVariable("email") String email) {
        studentService.deleteStudent(email);
    }
}
