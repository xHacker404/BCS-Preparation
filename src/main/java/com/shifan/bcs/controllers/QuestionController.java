/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shifan.bcs.controllers;

import com.shifan.bcs.models.Answer;
import com.shifan.bcs.models.Question;
import com.shifan.bcs.service.QuestionService;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author dimiksonkha
 */
@Controller
@RequestMapping("/question")
public class QuestionController {
    
    @Autowired
    private QuestionService questionSerivce;
   
  
    @RequestMapping("/addQues")
    public String addQuestion(Model model) throws SQLException, ClassNotFoundException{
        
        SessionFactory factory = new Configuration()
                                 .configure("hibernate.cfg.xml")
                                 .addAnnotatedClass(Question.class)
                                 .addAnnotatedClass(Answer.class)
                                 .buildSessionFactory();
        
        Session session = factory.getCurrentSession();
    
        try {
        
        Question q1= new Question("What is the name of our national poet?");
        List<Answer> answer= new ArrayList();
        Answer a1= new Answer();
        a1.setContent("Kazi Nazrul Islam");
        a1.setExplanation("Kazi nazrul islam is the national poet of Bangladesh");
        a1.setIsRightAnswer(true);
        q1.addAnswer(a1);
        
        Answer a2= new Answer();
        a2.setContent("Kazi Ariful Islam");
        a2.setExplanation("Incorrect:Kazi nazrul islam is the national poet of Bangladesh");
        q1.addAnswer(a2);
        
        Answer a3= new Answer();
        a3.setContent("Kabi Al Mahmud");
        a3.setExplanation("Incorrect:Kazi nazrul islam is the national poet of Bangladesh");
        q1.addAnswer(a3);
        
        Answer a4= new Answer();
        a4.setContent("Samsur Rahman");
        a4.setExplanation("Incorrect:Kazi nazrul islam is the national poet of Bangladesh");
        q1.addAnswer(a4);
        
        
        session.beginTransaction();
        
        session.save(a1);
        session.save(a2);
        session.save(a3);
        session.save(a4);
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
                                 .addAnnotatedClass(Answer.class)
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
    
    @RequestMapping("/updateAllQuestion")
    public String updateAllQuestion(Model model) throws SQLException, ClassNotFoundException{
        
        SessionFactory factory = new Configuration()
                                 .configure("hibernate.cfg.xml")
                                 .addAnnotatedClass(Question.class)
                                 .buildSessionFactory();
        
        Session session = factory.getCurrentSession();
    
       
        try {
        
        
        
        session.beginTransaction();
        
        session.createQuery("Update Question set content='What is the age of your pet?'").executeUpdate();
        
        
        session.getTransaction().commit();
            
        } catch (Exception e) {
            
            
        }finally{
           factory.close();
        }
        
       
        
        model.addAttribute("message", "Question updated  Successfully!!!");
        return "update";
    }
    
    @RequestMapping("/deleteQues")
    public String deleteQuestion(Model model) throws SQLException, ClassNotFoundException{
        
        SessionFactory factory = new Configuration()
                                 .configure("hibernate.cfg.xml")
                                 .addAnnotatedClass(Question.class)
                                 .buildSessionFactory();
        
        Session session = factory.getCurrentSession();
    
        int questionId = 1;
        try {
        
        
        
        session.beginTransaction();
        
        Question q1= session.get(Question.class, questionId);
        session.delete(q1);
        
        session.getTransaction().commit();
            
        } catch (Exception e) {
            
            
        }finally{
           factory.close();
        }
        
       
        
        model.addAttribute("message", "Question deleted  Successfully!!!");
        return "update";
    }
    
     @RequestMapping("/deleteAllQuestion")
    public String deleteAllQuestion(Model model) throws SQLException, ClassNotFoundException{
        
        SessionFactory factory = new Configuration()
                                 .configure("hibernate.cfg.xml")
                                 .addAnnotatedClass(Question.class)
                                 .buildSessionFactory();
        
        Session session = factory.getCurrentSession();
    
       
        try {
        
        
        
        session.beginTransaction();
        
        session.createQuery("Delete Question where id='4'").executeUpdate();
        
        
        session.getTransaction().commit();
            
        } catch (Exception e) {
            
            
        }finally{
           factory.close();
        }
        
       
        
        model.addAttribute("message", "Question deleted  Successfully!!!");
        return "update";
    }
    
    @GetMapping("/list")
    public String listQuestions(Model model){
        
        List<Question> questions = questionSerivce.getQuestions();
        
        model.addAttribute("questions", questions);
        
        return "list-questions";
    }
//    
//    @GetMapping("/list")
//   
//    public @ResponseBody List listQuestions(){
//        
//        List<Question> questions = questionSerivce.getQuestions();
//       
//        return questions;
//    }
    
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){
        Question theQuestion = new Question();
        
        model.addAttribute("question", theQuestion);
        
        return "question-form";
    }
    
//    @PostMapping("/saveQuestion")
//    public String saveQuestion(@ModelAttribute("question") Question question){
//    questionSerivce.saveQuestion(question);
//    return "redirect:/question/list";
//    }
    
    @PostMapping(value="/saveQuestion",produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public Question saveQuestion(HttpServletRequest request){    
    
    String content = request.getParameter("content");
 
    Question question = new Question();
    question.setContent(content);
    questionSerivce.saveQuestion(question);
    return question;
    }
    
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("questionId") int id, Model model){
        
        Question theQuestion = questionSerivce.getQuestion(id);
        
        model.addAttribute("question", theQuestion);
        return "question-form";
    }
    
    @GetMapping("/delete")
    public String deleteQuestion(@RequestParam("questionId") int id, Model model){
        
        questionSerivce.deleteQuestion(id);
       
        
        return "redirect:/question/list";
    }
    
    @GetMapping("/ajax")
    
    public String handleAjax(Model model){
        
       
      
        
        return "ajax";
    }
    
    
}
