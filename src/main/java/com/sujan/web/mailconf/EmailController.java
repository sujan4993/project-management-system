/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sujan.web.mailconf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sujan
 */
@RestController
@RequestMapping(value = "/email")
public class EmailController {
    
    @Autowired
    private EmailService emailService;
    
    @GetMapping(value = "/sendmail")
    public String sendmail(){
        System.out.println("Hello");
        emailService.sendMail("sujanadhikari4993@gmail.com","Spring Boot Application", "This is the mail from mail sender Again");
         return "success";
    }
    
}
