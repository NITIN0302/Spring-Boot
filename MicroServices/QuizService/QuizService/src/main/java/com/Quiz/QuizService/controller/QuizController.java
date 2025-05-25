package com.Quiz.QuizService.controller;

import com.Quiz.QuizService.Entity.Quiz;
import com.Quiz.QuizService.services.QuizService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quizService")
public class QuizController {

    private QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @PostMapping("/add")
    public void addData(@RequestBody Quiz quiz){
        quizService.add(quiz);
    }

    @GetMapping("/getQuiz")
    public List<Quiz> getQuizes(){
        return quizService.getall();
    }

    @GetMapping("/getQuiz/{id}")
    public Quiz getQuiz(@PathVariable Long id){
        return quizService.get(id);
    }
}
