package com.springboot.lean.customvalidation.service;

import com.springboot.lean.customvalidation.dto.UserRequest;
import com.springboot.lean.customvalidation.entity.User;
import com.springboot.lean.customvalidation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public User saveUser(UserRequest userRequest){
        User user = User.build(0,
                userRequest.getName(),
                userRequest.getEmail(),userRequest.getMobile(),
                userRequest.getGender(),userRequest.getAge(),
                userRequest.getNationality());
        return repository.save(user);
    }
    public List<User> getAllUsers(){
        return repository.findAll();
    }
    public User getUser(int id){
        return repository.findByUserId(id);
    }
}
