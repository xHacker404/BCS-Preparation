/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shifan.bcs.dao;

import com.shifan.bcs.models.Question;
import java.util.List;

/**
 *
 * @author dimiksonkha
 */
public interface QuestionDAO {
    
    public List<Question> getQuestions();

    public void saveQuestion(Question question);

    public Question getQuestion(int id);

    public void deleteQuestion(int id);
    
}
