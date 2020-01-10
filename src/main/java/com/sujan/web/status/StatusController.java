/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sujan.web.status;

import com.sujan.web.core.controller.CRUDController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author sujan
 */
@Controller
@RequestMapping("/status")
public class StatusController extends CRUDController<Status, Integer>{

    public StatusController() {
        pageTitle="Project Status";
        uri="status";
        viewPath="status";        
    }
    
    
    
}
