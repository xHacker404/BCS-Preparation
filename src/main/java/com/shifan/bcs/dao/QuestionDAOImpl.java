/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shifan.bcs.dao;

import com.shifan.bcs.models.Question;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author dimiksonkha
 */
@Repository
public class QuestionDAOImpl implements QuestionDAO{
    
    @Autowired
    SessionFactory sessionFactory;
    
    
    @Override
    public List<Question> getQuestions() {
        
        Session currentSession = sessionFactory.getCurrentSession();
        
        Query<Question> theQuery = currentSession.createQuery("from Question",Question.class);
        
        List<Question> questions = theQuery.getResultList();
        
        return questions;
    }

    @Override
    public void saveQuestion(Question question) {
        
        Session currentSession = sessionFactory.getCurrentSession();
        
        currentSession.saveOrUpdate(question);
    }

    @Override
    public Question getQuestion(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Question question = currentSession.get(Question.class, id);
        
        return question;
    }

    @Override
    public void deleteQuestion(int id) {

        Session currentSession = sessionFactory.getCurrentSession();

        
        Query theQuery = 
                        currentSession.createQuery("delete from Question where id=:questionId");
        theQuery.setParameter("questionId", id);

        theQuery.executeUpdate();
    }
    
}
