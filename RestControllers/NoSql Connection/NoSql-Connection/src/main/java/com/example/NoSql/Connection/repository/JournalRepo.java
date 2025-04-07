package com.example.NoSql.Connection.repository;

import com.example.NoSql.Connection.entity.Journal;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JournalRepo extends MongoRepository<Journal,String> {
}
