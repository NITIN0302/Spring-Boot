package com.Quiz.QuizService.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Quiz {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Transient
    private List<Questions> question;

    public List<Questions> getQuestion() {
        return question;
    }

    public void setQuestion(List<Questions> question) {
        this.question = question;
    }

    public Quiz(){}


    public Quiz(Long id, String title) {
        this.id = id;
        this.title = title;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
