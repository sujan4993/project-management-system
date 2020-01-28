/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sujan.web.auth.controller;

import com.sujan.web.auth.entity.Role;
import com.sujan.web.core.controller.CRUDController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author sujan
 */
@Controller
@RequestMapping(value = "/roles")
public class RoleController extends CRUDController<Role, Integer>{

    public RoleController() {
        pageTitle="Role";
        uri="roles";
        viewPath="auth/roles";
        activeMenu="auth";
    }
    
    
}
