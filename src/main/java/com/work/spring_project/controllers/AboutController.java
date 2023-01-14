package com.work.spring_project.controllers;

import com.work.spring_project.models.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutController {

    @GetMapping("/about")
    public String about(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("user",user);
        model.addAttribute("title", "About");
        return "about";
    }
}
