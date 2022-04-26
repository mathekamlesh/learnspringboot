package com.learn.springboot.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentService) {
        this.studentRepository = studentService;
    }

    public List<Student> getStudents(){
        return  studentRepository.findAll();
    }


    public void addNewStudent(Student student) {
        Optional<String> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
        if(studentOptional.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        studentRepository.save(student);
        System.out.println(student);
    }

    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if(!exists){
            throw new IllegalStateException("studnet with id "+ studentId+" does not exists");
        }
        studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long student_id, Student updateInfo) {
        Student student = studentRepository.getById(student_id);
        student.setName(updateInfo.getName());
        student.setEmail(updateInfo.getEmail());
    }
}
