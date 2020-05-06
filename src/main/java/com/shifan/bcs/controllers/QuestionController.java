/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shifan.bcs.controllers;

import com.shifan.bcs.models.Question;
import java.sql.SQLException;
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
public class QuestionController {
   
  
    @RequestMapping("/addQues")
    public String addQuestion(Model model) throws SQLException, ClassNotFoundException{
        
        SessionFactory factory = new Configuration()
                                 .configure("hibernate.cfg.xml")
                                 .addAnnotatedClass(Question.class)
                                 .buildSessionFactory();
        
        Session session = factory.getCurrentSession();
    
        try {
        
        Question q1= new Question("What is the name of our national poet?");
        
        session.beginTransaction();
        
        session.save(q1);
        
        session.getTransaction().commit();
            
        } catch (Exception e) {
            
            
        }finally{
           factory.close();
        }
        
       
        
        model.addAttribute("message", "Question saved  Successfully!!!");
        return "add";
    }
    
    @RequestMapping("/updateQues")
    public String updateQuestion(Model model) throws SQLException, ClassNotFoundException{
        
        SessionFactory factory = new Configuration()
                                 .configure("hibernate.cfg.xml")
                                 .addAnnotatedClass(Question.class)
                                 .buildSessionFactory();
        
        Session session = factory.getCurrentSession();
    
        int questionId = 1;
        try {
        
        
        
        session.beginTransaction();
        
        Question q1= session.get(Question.class, questionId);
        q1.setContent("What is the name of the virus of the year?");
        
        session.getTransaction().commit();
            
        } catch (Exception e) {
            
            
        }finally{
           factory.close();
        }
        
       
        
        model.addAttribute("message", "Question updated  Successfully!!!");
        return "update";
    }
}
