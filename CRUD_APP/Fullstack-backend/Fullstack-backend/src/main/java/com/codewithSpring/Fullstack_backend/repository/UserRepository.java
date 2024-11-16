package com.codewithSpring.Fullstack_backend.repository;

import com.codewithSpring.Fullstack_backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {


}
