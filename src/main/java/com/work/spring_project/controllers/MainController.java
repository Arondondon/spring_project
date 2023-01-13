package com.work.spring_project.controllers;

import com.work.spring_project.models.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("title", "Home (all)");
        return "main";
    }
}
