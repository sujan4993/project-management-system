/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sujan.web.project.repository;

import com.sujan.web.project.entity.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author sujan
 */
public interface TasksRepository 
        extends JpaRepository<Tasks, Integer> {
    
}
