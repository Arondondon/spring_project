package com.work.spring_project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ManagerRegistController {

    @GetMapping("/manager_registration")
    public String about(Model model) {
        model.addAttribute("title", "Manager Registration");
        return "manager_registration";
    }
}
