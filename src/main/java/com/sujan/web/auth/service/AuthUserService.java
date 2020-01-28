/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sujan.web.auth.service;

import com.sujan.web.auth.entity.Role;
import com.sujan.web.auth.entity.User;
import com.sujan.web.auth.entity.UserRole;
import com.sujan.web.auth.repository.UserRepository;
import com.sujan.web.auth.repository.UserRoleRepository;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author sujan
 */
@Service
public class AuthUserService implements UserDetailsService{

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username);
        if(user==null){
            throw new UsernameNotFoundException(username+" does not exist");
        }
        AuthUserDetails userDetails = 
                new AuthUserDetails(
                    username, user.getPassword(), 
                            getAuthorities(username));
        userDetails.setUser(user);
        return userDetails;
    }
    
    private Collection<? extends GrantedAuthority> getAuthorities(String username){
        List<UserRole> roles=userRoleRepository.findByUserUserName(username);
        List<GrantedAuthority> authorities = new ArrayList<>();
        for(UserRole role:roles){
            authorities.add(new SimpleGrantedAuthority(role.getRole().getName()));
        }
        return authorities;
    }
}
