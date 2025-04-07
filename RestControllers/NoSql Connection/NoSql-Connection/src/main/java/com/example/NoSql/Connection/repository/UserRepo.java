package com.example.NoSql.Connection.repository;

import com.example.NoSql.Connection.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<User,Long> {
    User findByUserName(String userName);
}
