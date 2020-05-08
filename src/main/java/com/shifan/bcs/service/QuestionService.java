/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shifan.bcs.service;

import com.shifan.bcs.models.Question;
import java.util.List;

/**
 *
 * @author dimiksonkha
 */
public interface QuestionService {
    
    public List<Question> getQuestions();
}
