package com.codewithSpring.Fullstack_backend.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long id){
        super("User Not found with given id " + id);
    }
}
