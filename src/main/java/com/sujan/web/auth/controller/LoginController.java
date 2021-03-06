/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sujan.web.auth.controller;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author sujan
 */
@Controller
@RequestMapping(value="/login")
public class LoginController {
    
    @GetMapping
    public String index(){
        return "auth/login/index";
    }
    
    @GetMapping(value = "/logout")
    public String logout(HttpSession Session){
        Session.invalidate();
        return "redirect:/login";
    }
    
}
