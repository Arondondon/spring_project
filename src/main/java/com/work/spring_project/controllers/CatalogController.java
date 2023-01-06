package com.work.spring_project.controllers;

import com.work.spring_project.models.Service;
import com.work.spring_project.models.repositories.ServiceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CatalogController {

    @Autowired
    private ServiceRepo serviceRepo;

    @GetMapping("/catalog")
    public String main(Model model) {
        Iterable<Service> services = serviceRepo.findAll();
        model.addAttribute("services", services);
        return "catalog";
    }

}
