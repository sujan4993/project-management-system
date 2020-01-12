/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sujan.web.project.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sujan.web.client.Client;
import com.sujan.web.conversation.Conversation;
import com.sujan.web.employee.Employee;
import com.sujan.web.status.Status;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author sujan
 */
@Entity
@Table(name = "tbl_projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String projectName;

    @Column(name = "description")
    private String description;

    @Column(name = "deadline", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date deadline;

    @Column(name = "budget")
    private int budget;

    @JoinTable(
            name = "project_employee",
            joinColumns
            = @JoinColumn(name = "project_id"),
            inverseJoinColumns
            = {
                @JoinColumn(name = "employee_id")}
    )
    @ManyToMany()
    @JsonIgnore
    private List<Employee> employeeList = new ArrayList<>();

    @JoinTable(
            name = "tbl_project_task",
            joinColumns
            = @JoinColumn(name = "project_id"),
            inverseJoinColumns
            = {
                @JoinColumn(name = "task_id")}
    )
    @ManyToMany()
    @JsonIgnore
    private List<Tasks> tasks = new ArrayList<>();
    

    @JsonBackReference
    @ManyToOne()
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;
    
    @ManyToOne()
    @JsonIgnore
    @JoinColumn(name = "client_id",referencedColumnName = "id")
    private Client client;
    
    @OneToMany(mappedBy = "project")
    private List<Conversation> conversations = new ArrayList<>();

    public Project() {
    }

    public Project(int id, String projectName, String description, Date deadline, int budget) {
        this.id = id;
        this.projectName = projectName;
        this.description = description;
        this.deadline = deadline;
        this.budget = budget;
    }

    public List<Conversation> getConversations() {
        return conversations;
    }

    public void setConversations(List<Conversation> conversations) {
        this.conversations = conversations;
    }

    
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    
    

    public List<Tasks> getTasks() {
        return tasks;
    }

    public void setTasks(List<Tasks> tasks) {
        this.tasks = tasks;
    }

    
    
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employee) {
        this.employeeList = employee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }
    
}
