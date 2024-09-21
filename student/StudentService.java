package com.example.demo.student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student){
        Optional<Student> StudentByAge = studentRepository.findStudentByAge(student.getAge());
        if (StudentByAge.isPresent()){
            System.out.println("Ya está :/");
        }
        else{studentRepository.save(student);}
    }
    public void deleteStudent(Integer id){
        boolean existsById = studentRepository.existsById(id);
        if(!existsById){
            System.out.println("No existe");
        }else{
            studentRepository.deleteById(id);
        }
    }
    @Transactional
    public void updateStudent(Integer id, String name){
        Student student = studentRepository.findById(id).orElseThrow(()->new IllegalStateException("No existe :'c"));
        student.setName(name);
    }
}
