package com.example.Challange;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Challenge
{
    @Id
    @GeneratedValue
    private Long id;

    private String month;
    private String description;
    public Challenge(){}

    public Challenge(Long id, String month, String desc) {
        this.id = id;
        this.month = month;
        this.description = desc;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDesc() {
        return description;
    }

    public void setDesc(String description) {
        this.description = description;
    }


}
