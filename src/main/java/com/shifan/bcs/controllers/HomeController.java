/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shifan.bcs.controllers;

import com.shifan.bcs.models.Answer;
import com.shifan.bcs.models.Question;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author dimiksonkha
 */
@Controller
public class HomeController {
    
    private List<Question> questions; 
    
    private void populateQuestionAndAnswer(){
        
        SessionFactory factory = new Configuration()
                                 .configure("hibernate.cfg.xml")
                                 .addAnnotatedClass(Question.class)
                                 .addAnnotatedClass(Answer.class)
                                 .buildSessionFactory();
        
        Session session = factory.getCurrentSession();
        
              
        try {
        
        session.beginTransaction();
        
        questions = session.createQuery("from Question")
                         .getResultList();
        
        for(Question q: questions){
            int question_id=q.getId();
            List<Answer> answers = session.createQuery("from Answer where question_id="+question_id+"").getResultList();
            q.setAnswer(answers);
           
            
        }
            
        
        session.getTransaction().commit();
            
        }catch (Exception e) {
            
            
        }finally{
           factory.close();
        }
        

    
               
            
        }
    
    @RequestMapping("/")
    public String showHomePage(Model model){
       populateQuestionAndAnswer();
            
        model.addAttribute("questions", questions);
        return "index";
    }
    
    
    }

   
    
   
    
   
    
