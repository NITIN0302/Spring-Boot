package com.Question.QuestionService.repository;

import com.Question.QuestionService.Entity.Questions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuesRepository extends JpaRepository<Questions,Long> {
    public List<Questions> findByQuizId(Long id);
}
