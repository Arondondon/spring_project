package com.work.spring_project.controllers;

import com.work.spring_project.models.Order;
import com.work.spring_project.models.Service;
import com.work.spring_project.models.User;
import com.work.spring_project.models.repositories.OrderRepo;
import com.work.spring_project.models.repositories.ServiceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrdersController {

    @Autowired
    private OrderRepo orderRepo;

    @GetMapping("/orders")
    public String main(@AuthenticationPrincipal User user, Model model) {
        Iterable<Order> orders = orderRepo.findAll();
        model.addAttribute("user",user);
        model.addAttribute("orders", orders);
        return "orders";
    }

}
