package com.Quiz.QuizService.services;

import com.Quiz.QuizService.Entity.Quiz;

import java.util.List;

public interface QuizService {
    Quiz add(Quiz quiz);

    List<Quiz> getall();

    Quiz get(Long id);

}
