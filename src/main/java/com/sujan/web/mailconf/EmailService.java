/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sujan.web.mailconf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

/**
 *
 * @author sujan
 */

@Service
public class EmailService {

   
//    private JavaMailSender javaMailSender;
//    
//    @Autowired
//    public EmailService(JavaMailSender javaMailSender){
//        this.javaMailSender=javaMailSender;
//    }

    public void sendMail(String toEmail, String subject, String message) {

        JavaMailSender javaMailSender =getMailSender();
        
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setTo(toEmail);
        mailMessage.setSubject(subject);
        mailMessage.setText(message);

        mailMessage.setFrom("mailtester4993@gmail.com");
        System.out.println(mailMessage);
        javaMailSender.send(mailMessage);

    }
     
    @Bean
    public JavaMailSender getMailSender(){
    return new JavaMailSenderImpl();
    }
}
