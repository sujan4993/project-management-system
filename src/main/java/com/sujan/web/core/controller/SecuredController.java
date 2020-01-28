/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sujan.web.core.controller;

import com.sujan.web.auth.entity.User;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 *
 * @author sujan
 */
public abstract class SecuredController 
        extends SiteController{
    
    @Autowired
    protected HttpSession session;
    
    @ModelAttribute(value = "currentUser")
    public User getLoggedUser(){
        return (User)session.getAttribute("loggedUser");
    }
}
