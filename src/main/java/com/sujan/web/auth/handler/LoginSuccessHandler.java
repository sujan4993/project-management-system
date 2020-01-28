/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sujan.web.auth.handler;

import com.sujan.web.auth.entity.User;
import com.sujan.web.auth.entity.UserLog;
import com.sujan.web.auth.repository.UserLogRepository;
import com.sujan.web.auth.repository.UserRepository;
import com.sujan.web.auth.service.AuthUserDetails;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

/**
 *
 * @author sujan
 */
@Component
public class LoginSuccessHandler extends 
        SavedRequestAwareAuthenticationSuccessHandler{

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private HttpSession session;
    @Autowired
    private UserLogRepository userLogRepository;
    @Transactional
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, 
            HttpServletResponse response, 
            Authentication auth) throws ServletException, IOException {
        if(auth.isAuthenticated()){
            UserLog log = new UserLog();
            String ipAddress=request.getRemoteAddr();
            log.setIpAddress(ipAddress);
            
            AuthUserDetails authDetail=(AuthUserDetails)
                    auth.getPrincipal();
            User user=authDetail.getUser();
            log.setUser(user);
            session.setAttribute("loggedUser", user);
            userLogRepository.save(log);
            userRepository.setLastLogin(ipAddress, user.getId());
        }
        
        super.onAuthenticationSuccess(request, response, auth); 
    }
  
}
