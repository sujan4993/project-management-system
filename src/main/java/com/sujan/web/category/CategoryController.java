/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sujan.web.category;

import com.sujan.web.category.Category;
import com.sujan.web.core.controller.CRUDController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author sujan
 */
@Controller
@RequestMapping(value = "/categories")
public class CategoryController extends CRUDController<Category, Integer> {

    public CategoryController() {
        pageTitle = "Category";
        uri = "categories";
        viewPath = "categories";
    }

//    @GetMapping
//    public String index(Model model) {
//        model.addAttribute("records", repository.findAll());
//        return "categories/index";
//    }
//    @GetMapping(value = "/create")
//    public String create(Model model) {
//        return "categories/create";
//    }
//    @GetMapping(value = "/edit/{id}")
//    public String edit(@PathVariable("id") int id, Model model) {
//        model.addAttribute("category", repository.findById(id).get());
//        return "categories/edit";
//    }
//    @GetMapping(value = "/delete/{id}")
//    public String delete(@PathVariable("id") int id) {
//        repository.deleteById(id);
//        return "redirect:/categories";
//    }
//    @PostMapping
//    public String save(@ModelAttribute("Category") Category category) {
//        repository.save(category);
//        return "redirect:/categories?success";
//    }
//    @GetMapping(value = "/json")
//    @ResponseBody
//    public List<Category> json() {
//        return repository.findAll();
//    }
//
//    @GetMapping(value = "/json/{id}")
//    @ResponseBody
//    public Category jsonById(@PathVariable("id") int id) {
//        return repository.findById(id).get();
//    }
}
