/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sujan.web.project.controller;

import com.sujan.web.project.entity.ProjectStatus;
import com.sujan.web.core.controller.CRUDController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author sujan
 */
@Controller
@RequestMapping(value="/projects/status")
public class ProjectStatusController 
        extends CRUDController<ProjectStatus, Integer>{

    public ProjectStatusController() {
        
    }
    
    
    
    
}
