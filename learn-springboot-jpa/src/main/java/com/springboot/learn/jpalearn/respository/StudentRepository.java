package com.springboot.learn.jpalearn.respository;

import com.springboot.learn.jpalearn.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

}
