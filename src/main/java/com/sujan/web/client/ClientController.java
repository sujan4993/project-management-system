/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sujan.web.client;

import com.sujan.web.core.controller.CRUDController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author sujan
 */
@Controller
@RequestMapping(value = "/clients")
public class ClientController extends CRUDController<Client, Integer>{
    
    public ClientController() {
        pageTitle = "Client";
        uri = "clients";
        viewPath = "client";
    }
    
}
