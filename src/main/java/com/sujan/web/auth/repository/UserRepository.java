/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sujan.web.auth.repository;

import com.sujan.web.auth.entity.User;
import java.util.Date;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sujan
 */
@Repository
public interface UserRepository 
        extends JpaRepository<User, Integer> {
    
    User findByUserName(String username);
    
    @Modifying
    @Query(nativeQuery = true,value = "update tbl_users set last_login=CURRENT_TIMESTAMP,last_ipaddress=? where id=?")
    void setLastLogin(String ipAddress,int id);
    
}
