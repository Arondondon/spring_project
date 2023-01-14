package com.work.spring_project.controllers;

import com.work.spring_project.models.Service;
import com.work.spring_project.models.User;
import com.work.spring_project.models.repositories.ServiceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CatalogController {

    @Autowired
    private ServiceRepo serviceRepo;

    @GetMapping("/catalog")
    public String main(@AuthenticationPrincipal User user, Model model) {
        Iterable<Service> services = serviceRepo.findAll();
        model.addAttribute("user",user);
        model.addAttribute("services", services);
        return "catalog";
    }

    @GetMapping("/catalog/add_service")
    public String add(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("user",user);
        return "add_service";
    }

    @PostMapping("/catalog/add_service")
    public String addFromForm(@RequestParam String name, @RequestParam String description, @RequestParam int min_price, Model model) {
        Service service = new Service(name, description, min_price);
        serviceRepo.save(service);
        return "redirect:/catalog";
    }
}
