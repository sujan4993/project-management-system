/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sujan.web.auth.service;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

/**
 *
 * @author sujan
 */
public class AuthUserDetails extends User {

    private com.sujan.web.auth.entity.User user;

    public AuthUserDetails(String username,
            String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public void setUser(com.sujan.web.auth.entity.User user) {
        this.user = user;
    }

    public com.sujan.web.auth.entity.User getUser() {
        return user;
    }
    
    
}
