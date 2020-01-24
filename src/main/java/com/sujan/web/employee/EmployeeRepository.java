/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sujan.web.employee;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author sujan
 */
public interface EmployeeRepository 
        extends JpaRepository<Employee, Integer> {
    
    List<Employee> findByIsDeletedTrue();
    
    @Query(value = "select * from tbl_employees where id not in (select employee_id from project_employee"
            + " where project_id=?)",nativeQuery = true)
    List<Employee> findEmployeeNotIn(int projectId);
    
    
}
