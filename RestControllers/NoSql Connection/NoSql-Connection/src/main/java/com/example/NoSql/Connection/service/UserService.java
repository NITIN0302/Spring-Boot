package com.example.NoSql.Connection.service;
import com.example.NoSql.Connection.entity.User;
import com.example.NoSql.Connection.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public class UserService {
    @Autowired
    private UserRepo userRepository;

    public void saveEntry(User user) {
        userRepository.save(user);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public Optional<User> getDataById(Long Id) {
        Optional<User> result = userRepository.findById(Id);
        return result;
    }

    public void deleteData(Long id) {
        userRepository.deleteById(id);
    }

    public User findByUserName(String name){
        return userRepository.findByUserName(name);
    }
}
