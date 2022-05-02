package com.springboot.lean.customvalidation.repository;

import com.springboot.lean.customvalidation.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    public User findByUserId(int id);
}
