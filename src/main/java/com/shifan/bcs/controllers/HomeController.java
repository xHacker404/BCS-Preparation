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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author dimiksonkha
 */
@Controller
public class HomeController {
    
    private List questions = new ArrayList();
    
    private void populateQuestionAndAnswer(){
        for (int i = 0; i < 25; i++) {
            Question q1= new Question();
            String content = "What is the answer of question " + (i+1);
            q1.setContent(content);
            
            List answers = new ArrayList();
            for (int j = 0; j <4; j++) {
                Answer ans = new Answer();
                
                String answerContent = "Answer" + " "+(j+1);
                ans.setContent(answerContent);
                
                String ansExplanation = "Explanation" + j+1;
                ans.setExplanation(ansExplanation);
                
                if(j==3){
                   ans.setIsRightAnswer(true);
                }else{
                ans.setIsRightAnswer(false);
                
                }
                answers.add(ans);
           
                
            }
            q1.setAnswer(answers);
            questions.add(q1);    
            
        }
    }

    {
    populateQuestionAndAnswer();
    }

    
        
    
    
    @RequestMapping("/")
    public String showHomePage(Model model){
        
        
        
           
        model.addAttribute("questions", questions);
        return "index";
    }
    
}
