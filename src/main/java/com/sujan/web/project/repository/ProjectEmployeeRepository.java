/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sujan.web.project.repository;

import com.sujan.web.employee.Employee;
import com.sujan.web.project.entity.Project;
import com.sujan.web.project.entity.ProjectEmployee;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sujan
 */
@Repository
public interface ProjectEmployeeRepository 
        extends JpaRepository<ProjectEmployee, Integer> {
    List<ProjectEmployee> findByProjectId(int id);
    int deleteByProjectIdAndEmployeeId(int projectId,int employeeId);
      
}
