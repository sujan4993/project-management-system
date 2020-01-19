/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sujan.web.project.controller;

import com.sujan.web.client.ClientRepository;
import com.sujan.web.project.entity.Project;
import com.sujan.web.core.controller.CRUDController;
import com.sujan.web.employee.Employee;
import com.sujan.web.employee.EmployeeRepository;
import com.sujan.web.project.entity.ProjectEmployee;
import com.sujan.web.project.entity.ProjectStatus;
import com.sujan.web.project.repository.ProjectClientRepository;
import com.sujan.web.project.repository.ProjectEmployeeRepository;
import com.sujan.web.project.repository.ProjectRepository;
import com.sujan.web.project.repository.ProjectStatusRepository;
import com.sujan.web.project.repository.TasksRepository;
import com.sujan.web.status.StatusRepository;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author sujan
 */
@Controller
@RequestMapping(value = "/projects")
public class ProjectController extends CRUDController<Project, Integer> {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ProjectEmployeeRepository projectEmployeeRepository;
    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private StatusRepository statusRepository;

    @Autowired
    private ProjectClientRepository projectClientRepository;
    
     @Autowired
    private ProjectStatusRepository projectStatusRepository;
     @Autowired
     private TasksRepository tasksRepository;

    @Autowired
    private ClientRepository clientRepository;
    public ProjectController() {
        pageTitle = "Project";
        uri = "projects";
        viewPath = "project";
    }

    @GetMapping(value = "/detail/{id}")
    public String detail(@PathVariable("id") int id, Model model) {
        model.addAttribute("pageTitle", "Project Detail");
        model.addAttribute("employees", employeeRepository.findAll());
        model.addAttribute("projects", projectRepository.findById(id).get());
        model.addAttribute("projectemployee", projectEmployeeRepository.findByProjectId(id));
        return "project/detail";
    }

    @GetMapping(value = "/conversation/{id}")
    public String conversation(@PathVariable("id") int id, Model model) {
        model.addAttribute("pageTitle", "Conversation");
        return "project/conversation";
    }

    @Override
    public String index(Model model) {
        model.addAttribute("employee", employeeRepository.findAll());
        model.addAttribute("status", statusRepository.findAll());
        model.addAttribute("client",clientRepository.findAll());
        model.addAttribute("tasks",tasksRepository.findAll());
        return super.index(model); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String create(Model model) {
        model.addAttribute("employees", employeeRepository.findAll());
        model.addAttribute("projectstatus",statusRepository.findAll());
        model.addAttribute("projectclient",clientRepository.findAll());
        return super.create(model); //To change body of generated methods, choose Tools | Templates.
    }

    @GetMapping(value = "/employees/{id}")
    @ResponseBody
    public List<ProjectEmployee> employees(@PathVariable("id") int projectId) {
        return projectEmployeeRepository.findByProjectId(projectId);
    }

    @GetMapping(value = "/employees")
    @ResponseBody
    public List<ProjectEmployee> findAll() {
        return projectEmployeeRepository.findAll();
    }

    @PostMapping(value = "/employees/add")
    @ResponseBody
    @Transactional
    public String addEmployee(@RequestParam("projectId") int projectId,
            @RequestParam("employeeList") List<Employee> employees) {
        Project project = repository.findById(projectId).get();
        List<ProjectEmployee> projectEmployees = new ArrayList<>();
        for (Employee employee : employees) {
            ProjectEmployee pe = new ProjectEmployee();
            pe.setEmployee(employee);
            pe.setProject(project);
            projectEmployees.add(pe);
        }
        projectEmployeeRepository.saveAll(projectEmployees);
        return "success";
    }    
    
    @PostMapping(value = "/update-status")
    @Transactional
    @ResponseBody
    public String updateStatus(ProjectStatus status){
         projectStatusRepository.save(status);
        return "success";
    }
     
}
