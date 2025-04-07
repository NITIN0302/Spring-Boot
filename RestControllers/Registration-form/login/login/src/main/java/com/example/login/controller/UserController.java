package com.example.login.controller;

import com.example.login.model.User;
import com.example.login.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("getUser/{id}")
    User existingUser(@PathVariable Long id){
        return userRepository.findById(id).orElseThrow();
    }

    @PostMapping("/signin")
    User createUser(@RequestBody User newUser) {
        return userRepository.save(newUser);
    }

}
