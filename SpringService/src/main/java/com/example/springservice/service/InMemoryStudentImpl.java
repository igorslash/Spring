package com.example.springservice.service;

import com.example.springservice.model.Student;
import com.example.springservice.repository.InMemoryStudentsDAO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class InMemoryStudentImpl implements StudentService {
    private final InMemoryStudentsDAO inMemoryStudentsDAO;
    @Override
    public List<Student> getAllStudents() {
        return inMemoryStudentsDAO.getAllStudents();
    }

    @Override
    public Student saveStudent(Student student) {
        return inMemoryStudentsDAO.saveStudent(student);
    }

    @Override
    public Student findByEmail(String email) {
        return inMemoryStudentsDAO.findByEmail(email);
    }

    @Override
    public Student updateStudent(Student student) {
        return inMemoryStudentsDAO.updateStudent(student);
    }

    @Override
    public void deleteStudent(String email) {
        inMemoryStudentsDAO.deleteStudent(email);
    }
}
