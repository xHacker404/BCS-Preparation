/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shifan.bcs.controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author dimiksonkha
 */
@Controller
public class TestJDBC {
  
    @RequestMapping("/test")
    public String testConnection(Model model) throws SQLException, ClassNotFoundException{
        
        Class.forName("com.mysql.jdbc.Driver"); 
        String jdbcUrl = "jdbc:mysql://localhost:3306/bcs_questions?useSSL=false&serverTimezone=UTC";  
        String user="root";
        String pass="Root.12345";
        
        Connection con = DriverManager.getConnection(jdbcUrl, user,pass);
        
        model.addAttribute("message", "Driver Connection Successful!!!");
        return "test";
    }
}
