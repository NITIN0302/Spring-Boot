package com.Quiz.QuizService.services;
import com.Quiz.QuizService.Entity.Questions;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(url="localhost:8080",value="Question-Client")
public interface QuestionClient {
    @GetMapping("/ques/getQuesQuiz/{id}")
    List<Questions> getQuesByQuiz(@PathVariable Long id);
}
