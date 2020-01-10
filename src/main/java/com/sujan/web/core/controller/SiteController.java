/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sujan.web.core.controller;

import org.springframework.web.bind.annotation.ModelAttribute;

/**
 *
 * @author sujan
 */
public abstract class SiteController {

    protected String pageTitle;

    @ModelAttribute(value = "pageTitle")
    public String getPageTitle() {
        return pageTitle;
    }
}
