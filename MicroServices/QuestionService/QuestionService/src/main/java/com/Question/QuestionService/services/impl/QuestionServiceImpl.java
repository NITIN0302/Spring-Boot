package com.Question.QuestionService.services.impl;

import com.Question.QuestionService.Entity.Questions;
import com.Question.QuestionService.repository.QuesRepository;
import com.Question.QuestionService.services.QuesService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuesService {

    public QuesRepository quesRepository;

    public QuestionServiceImpl(QuesRepository quesRepository) {
        this.quesRepository = quesRepository;
    }

    @Override
    public Questions add(Questions questions) {
        return quesRepository.save(questions);
    }

    @Override
    public List<Questions> getAll() {
        return quesRepository.findAll();
    }

    @Override
    public Questions get(Long id) {
        return quesRepository.findById(id).orElseThrow(()->new RuntimeException("Not Found"));
    }

    @Override
    public List<Questions> getAllQuesByQuiz(Long id){
        return quesRepository.findByQuizId(id);
    }
}
