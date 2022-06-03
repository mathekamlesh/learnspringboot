package com.springboot.learn.jpalearn.respository;

import com.springboot.learn.jpalearn.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    private  StudentRepository studentRepository;
    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .emailId("kamleshmathe@gmail.com")
                .firstName("Kamlesh")
                .lastName("Mathe")
                .guardianName("Suresh")
                .guardianEmail("chepleen@gmail.com")
                .guardianMobile("1234567890")
                .build();
        studentRepository.save(student);
    }
    @Test
    public void printAllStudnet(){
        List<Student> students = studentRepository.findAll();
        System.out.println("List of students = "+students);
    }
}