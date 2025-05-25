package com.Quiz.QuizService.services.impl;

import com.Quiz.QuizService.Entity.Quiz;
import com.Quiz.QuizService.repository.QuizRepository;
import com.Quiz.QuizService.services.QuestionClient;
import com.Quiz.QuizService.services.QuizService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuizServiceImpl implements QuizService {

    private final QuizRepository quizRepository;
    private QuestionClient questionClient;
    public QuizServiceImpl(QuizRepository quizRepository, QuestionClient questionClient) {
        this.quizRepository = quizRepository;
        this.questionClient = questionClient;
    }

    @Override
    public Quiz add(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public List<Quiz> getall() {
        List<Quiz> quizzes = quizRepository.findAll();
        quizzes.forEach(quiz -> {
            quiz.setQuestion(questionClient.getQuesByQuiz(quiz.getId()));
        });
        return quizzes;
    }

    @Override
    public Quiz get(Long id) {
        Quiz quiz = quizRepository.findById(id).orElseThrow(()->new RuntimeException("No Quiz Found"));
        quiz.setQuestion(questionClient.getQuesByQuiz(id));
        return quiz;
    }
}
