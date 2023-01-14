package com.work.spring_project.controllers;

import com.work.spring_project.models.Service;
import com.work.spring_project.models.User;
import com.work.spring_project.models.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistController {

    @Autowired
    UserService userService;

    @GetMapping("/registration")
    public String regist(Model model) {
        model.addAttribute("userForm", new User());
        return "registration";
    }

    @PostMapping("/registration")
    public String addFromForm(@ModelAttribute("userForm")@Validated User userForm, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
            model.addAttribute("Error", "Binding has errors!");
            return "registration";
        }
        if(!userForm.getPassword().equals(userForm.getPassConfirm())){
            model.addAttribute("Error", "Passwords do not match!");
            return "registration";
        }
        if(!userService.saveUser(userForm)){
            model.addAttribute("Error", "User with the same name already exists!");
            return  "registration";
        }

        return "redirect:/login";
    }

}
