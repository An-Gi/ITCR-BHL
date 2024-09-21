package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
        return args -> {
            Student student1 =  new Student(208630584,
                    "An-G",
                    "Canoas City",
                    19);
            Student student2 =  new Student(
                    "C-Bas",
                    "Cebadilla",
                    20);
            studentRepository.saveAll(
                    List.of(student1,student2)
            );
        };
    }
}