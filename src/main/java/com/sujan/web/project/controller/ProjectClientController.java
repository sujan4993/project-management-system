/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sujan.web.project.controller;

import com.sujan.web.core.controller.CRUDController;
import com.sujan.web.project.entity.ProjectClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author sujan
 */
@Controller
@RequestMapping(value = "/project-client")
public class ProjectClientController 
        extends CRUDController<ProjectClient, Integer> {

    public ProjectClientController() {
        pageTitle="Project and Client";
        uri="project-client";
        viewPath="project/client";
    }
    
    
    
    
}
