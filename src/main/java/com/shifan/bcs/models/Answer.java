/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shifan.bcs.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author dimiksonkha
 */
@Entity
@Table(name="Answer")
public class Answer{
    
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY )
   @Column(name="id")
   private int id;
    
   @Column(name="content")
   private String content;
   
   @Column(name="explanation")
   private String explanation;
   
   @Column(name="is_right_answer")
   private boolean isRightAnswer;
   
   @ManyToOne(cascade = CascadeType.ALL)
   @JoinColumn(name="answer")
   private Question question;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public boolean isIsRightAnswer() {
        return isRightAnswer;
    }

    public void setIsRightAnswer(boolean isRightAnswer) {
        this.isRightAnswer = isRightAnswer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

   
   
   
    
}
