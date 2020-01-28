/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sujan.web.auth.repository;

import com.sujan.web.auth.entity.UserRole;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sujan
 */
@Repository
public interface UserRoleRepository extends 
        JpaRepository<UserRole, Integer>{
    
    List<UserRole> findByUserUserName(String username);
}
