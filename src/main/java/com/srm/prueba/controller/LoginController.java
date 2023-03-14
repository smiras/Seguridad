package com.srm.prueba.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class LoginController {

    @GetMapping("/login")
    public String login(){
        return "login.html";
    }

    @RequestMapping("/logout")
	public String logout() {
		SecurityContextHolder.getContext().setAuthentication(null);
		return "redirect:/login";
	}
    
    @RequestMapping("/admin")
    public String admin() {
    	return "admin.html";
    }
    
    @GetMapping("/error")
    public String error() {
    	return "Fucking error";
    }

    @GetMapping("/new")
    public String registro(){
        return "nuevo.html";
    }
}
