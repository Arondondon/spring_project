package com.work.spring_project.controllers;

import com.work.spring_project.models.Service;
import com.work.spring_project.models.User;
import com.work.spring_project.models.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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

    @GetMapping("/manager_registration")
    public String about(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("userForm", new User());
        model.addAttribute("user", user);
        model.addAttribute("title", "Manager Registration");
        return "manager_registration";
    }

    @PostMapping("/registration")
    public String addUser(@ModelAttribute("userForm")@Validated User userForm, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
            model.addAttribute("error", "Binding has errors!");
            return "registration";
        }
        if(!userForm.getPassword().equals(userForm.getPassConfirm())){
            model.addAttribute("error", "Passwords do not match!");
            return "registration";
        }
        if(!userService.saveUser(userForm, 1)){
            model.addAttribute("error", "User with the same name already exists!");
            return  "registration";
        }

        return "redirect:/login";
    }

    @PostMapping("/manager_registration")
    public String addManager(@ModelAttribute("userForm")@Validated User userForm, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
            model.addAttribute("error", "Binding has errors!");
            return "manager_registration";
        }
        if(!userForm.getPassword().equals(userForm.getPassConfirm())){
            model.addAttribute("error", "Passwords do not match!");
            return "manager_registration";
        }
        if(!userService.saveUser(userForm, 2)){
            model.addAttribute("error", "User with the same name already exists!");
            return  "manager_registration";
        }

        return "redirect:/";
    }

}
