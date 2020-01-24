/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sujan.web.employee;

import com.sujan.web.core.controller.CRUDController;
import com.sujan.web.employee.Employee;
import com.sujan.web.employee.EmployeeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author sujan
 */
@Controller
@RequestMapping(value = "/employees")
public class EmployeeController extends CRUDController<Employee, Integer> {

    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeController() {
        pageTitle = "Employee";
        uri = "employees";
        viewPath = "employee";
    }

    @Override
    public String create(Model model) {
        model.addAttribute("gender",employeeRepository.findAll());
        return super.create(model);
    }
    
    @GetMapping(value = "/project-notassigned/{projectId}")
    @ResponseBody
    public List<Employee> getNotAssignedEmployees(@PathVariable("projectId")
    int projectId){
        return employeeRepository.findEmployeeNotIn(projectId);
    }
       
}
