package com.example.learn_thymeleaf;


import com.example.learn_thymeleaf.entity.Student;
import com.example.learn_thymeleaf.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;


public class BeanConfig implements CommandLineRunner{

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void run(String... args) throws Exception {
        Student hai = Student.builder()
                .firstName("Hai")
                .lastName("Nguyen")
                .email("Bb5@gmail.com")
                .build();

        Student cuong = Student.builder()
                .firstName("Cuong")
                .lastName("Nguyen")
                .email("gasasdff@gmail.com")
                .build();

        Student lam = Student.builder()
                .firstName("Lam")
                .lastName("Tran")
                .email("zxcqwgas@gmail.com")
                .build();

        studentRepository.saveAll(Arrays.asList(hai, cuong, lam));
    }
}
