package com.basic.CRUD_project.repository;

import com.basic.CRUD_project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
