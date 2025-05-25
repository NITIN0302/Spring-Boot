package com.example.JWTAuth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    DataSource dataSource;
    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/createUser")
    public ResponseEntity<?> createUser(@RequestBody UserInfo userinfo){
        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);

        if(userDetailsManager.userExists(userinfo.getUsername())){
            return new ResponseEntity<>("User Already Exists",HttpStatus.OK);
        }

        UserDetails user = User.withUsername(userinfo.getUsername())
                .password(passwordEncoder.encode(userinfo.getPassword()))
                .roles(userinfo.getRole())
                .build();
        userDetailsManager.createUser(user);

        return new ResponseEntity<>("User Created Succesfully",HttpStatus.OK);
    }



}
