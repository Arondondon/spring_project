package com.work.spring_project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrdersController {

    @GetMapping("/orders")
    public String main(Model model) {
        model.addAttribute("title", "Orders");
        return "orders";
    }

}
