/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sujan.web.expenses;

import com.sujan.web.core.controller.CRUDController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author sujan
 */
@Controller
@RequestMapping(value="/expenses")
public class ExpensesController extends CRUDController<Expenses, Integer>{

    public ExpensesController() {
        pageTitle="Expenses";
        uri="expenses";
        viewPath="expenses";
    }
    
    
    
}
