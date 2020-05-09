/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shifan.bcs.service;

import com.shifan.bcs.dao.QuestionDAO;
import com.shifan.bcs.models.Question;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author dimiksonkha
 */
@Service 
public class QuestionServiceImpl implements QuestionService{

    @Autowired
    private QuestionDAO questionDAO;
    
    @Override
    @Transactional
    public List<Question> getQuestions() {
            
        return questionDAO.getQuestions();
                
    }

    @Override
    @Transactional
    public void saveQuestion(Question question) {
       questionDAO.saveQuestion(question);
    }

    @Override
    @Transactional
    public Question getQuestion(int id) {
        return questionDAO.getQuestion(id);
    }

    @Override
    @Transactional
    public void deleteQuestion(int id) {
        questionDAO.deleteQuestion(id);
    }
    
}
