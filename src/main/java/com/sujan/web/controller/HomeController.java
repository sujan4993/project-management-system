/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sujan.web.controller;

import com.sujan.web.core.controller.SecuredController;
import com.sujan.web.core.controller.SiteController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sujan
 */
@Controller
@RequestMapping(value = "/")
public class HomeController extends SecuredController {

    public HomeController(){
        this.pageTitle = "Main-Dashboard";
        activeMenu="dashboard";
    }
    
    @GetMapping()
    public String index(Model model) {
       return "index";
    }

}
