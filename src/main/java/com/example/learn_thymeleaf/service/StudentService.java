package com.example.learn_thymeleaf.service;

import com.example.learn_thymeleaf.entity.Student;
import com.example.learn_thymeleaf.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    public Student getStudentById(long id) {
        Optional<Student> optional = studentRepository.findById(id);

        if (optional.isPresent()) {
            return optional.get();
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found Student");
    }

    public Student updateStudent(long id, Student newStudent) {
        Student student = getStudentById(id);
        student.setFirstName(newStudent.getFirstName());
        student.setLastName(newStudent.getLastName());
        student.setEmail(newStudent.getEmail());
        return studentRepository.save(student);
    }

    public void deleteStudentById(long id) {
        studentRepository.deleteById(id);
    }
}
