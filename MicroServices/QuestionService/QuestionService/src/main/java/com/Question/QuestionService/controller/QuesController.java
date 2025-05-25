package com.Question.QuestionService.controller;

import com.Question.QuestionService.Entity.Questions;
import com.Question.QuestionService.services.QuesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/ques")
public class QuesController
{
    public QuesService quesService;
    public QuesController(QuesService quesService) {
        this.quesService = quesService;
    }

    @PostMapping("/add")
    public void addQues(@RequestBody Questions question){
        quesService.add(question);
    }

    @GetMapping("/getQues")
    public List<Questions> getQues(){
        return quesService.getAll();
    }

    @GetMapping("/getQues/{id}")
    public Questions get(@PathVariable Long id){
        return quesService.get(id);
    }

    @GetMapping("/getQuesQuiz/{id}")
    public List<Questions> getQuesByQuiz(@PathVariable Long id){
        return quesService.getAllQuesByQuiz(id);
    }

}
