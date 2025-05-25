package com.Quiz.QuizService.repository;

import com.Quiz.QuizService.Entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz,Long> {

}
