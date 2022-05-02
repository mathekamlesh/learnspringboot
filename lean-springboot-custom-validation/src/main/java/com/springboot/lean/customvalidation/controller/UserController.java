package com.springboot.lean.customvalidation.controller;

import com.springboot.lean.customvalidation.dto.UserRequest;
import com.springboot.lean.customvalidation.entity.User;
import com.springboot.lean.customvalidation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value ="/users")
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping("/signup")
    public ResponseEntity<User> saveUser(@RequestBody @Valid UserRequest userRequest){
        return new ResponseEntity<>(service.saveUser(userRequest), HttpStatus.CREATED);
    }

    @GetMapping("/fetchAll")
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(service.getAllUsers());
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable int id){
        return ResponseEntity.ok(service.getUser(id));
    }
}
