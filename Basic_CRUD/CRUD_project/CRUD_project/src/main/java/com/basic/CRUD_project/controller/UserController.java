package com.basic.CRUD_project.controller;

import com.basic.CRUD_project.model.User;
import com.basic.CRUD_project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @PostMapping("/user")
    User newUser(@RequestBody User newUser){
        return userRepository.save(newUser);
    }

    @GetMapping("/user/{id}")
    Optional<User> getUser(@PathVariable Long id){
        return userRepository.findById(id);
    }

    @GetMapping("/users")
    List<User> getAllUser(@RequestBody User NewUser){
        return userRepository.findAll();
    }

}
