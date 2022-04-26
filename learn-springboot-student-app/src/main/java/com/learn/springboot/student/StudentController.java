package com.learn.springboot.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.aspectj.weaver.tools.cache.SimpleCacheFactory.path;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    private final StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents(){
        return studentService.getStudents();
    }
    @PostMapping
    public void  registerNewStudent(@RequestBody Student student){
        studentService.addNewStudent(student);
    }
    @DeleteMapping(path="{student_id}")
    public void deleteStudent(@PathVariable("student_id") Long studentId ){
        studentService.deleteStudent(studentId);
    }

    @PutMapping("{student_id}")
    public void updateStudent(@PathVariable Long student_id,@RequestParam Student updateInfo){
        studentService.updateStudent(student_id,updateInfo);
    }
}
