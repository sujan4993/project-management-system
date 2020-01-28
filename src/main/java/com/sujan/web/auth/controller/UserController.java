/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sujan.web.auth.controller;

import com.sujan.web.auth.entity.Role;
import com.sujan.web.auth.entity.User;
import com.sujan.web.auth.repository.RoleRepository;
import com.sujan.web.auth.repository.UserRepository;
import com.sujan.web.core.controller.CRUDController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author sujan
 */
@Controller
@RequestMapping(value = "/users")
public class UserController extends CRUDController<User, Integer> {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    public UserController() {
        pageTitle = "User";
        uri = "users";
        viewPath = "auth/users";
        activeMenu="auth";
    }

    @Override
    public String create(Model model) {
        model.addAttribute("roles", roleRepository.findAll());
        return super.create(model); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String edit(@PathVariable("id")Integer id, Model model) {
        model.addAttribute("roles", roleRepository.findAll());
        return super.edit(id, model); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String save(User model) {
        model.setPassword(passwordEncoder.encode(model.getPassword()));
        return super.save(model);
    }

}
