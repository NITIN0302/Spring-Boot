package com.example.Authentication.Authorization.Controller;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.security.authorization.AuthorityReactiveAuthorizationManager.hasRole;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String Greeting(){
        return "HELLO";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/user")
    public String getuser(){
        return "User";
    }
}
