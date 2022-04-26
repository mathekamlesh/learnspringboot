package com.learn.springboot.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentService;

    @Autowired
    public StudentService(StudentRepository studentService) {
        this.studentService = studentService;
    }

    public List<Student> getStudents(){
        return  studentService.findAll();
    }
}
