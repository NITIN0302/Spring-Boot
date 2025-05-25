package com.Question.QuestionService.services;

import com.Question.QuestionService.Entity.Questions;
import org.springframework.stereotype.Service;

import java.util.List;


public interface QuesService {

    Questions add(Questions questions);

    List<Questions> getAll();

    Questions get(Long id);

    List<Questions> getAllQuesByQuiz(Long id);
}
