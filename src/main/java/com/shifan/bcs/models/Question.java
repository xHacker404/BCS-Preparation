/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shifan.bcs.models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 *
 * @author dimiksonkha
 */
@Entity
@Table(name="Question")
public class Question {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name="id")
    private int id;
    
    @Column(name="content")
    private String content;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="question")
    private List answer;
    
    
    public Question(){
    
    }
    
    public void addAnswer(Answer ans){
        answer = new ArrayList();
        
        ans.setQuestion(this);
        answer.add(ans);
     
    }
    
    @Override
    public String toString() {
        return "Question{" + "id=" + id + ", content=" + content  + '}';
    }

    public Question(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List getAnswer() {
        return answer;
    }

    public void setAnswer(List answer) {
        this.answer = answer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    
}
