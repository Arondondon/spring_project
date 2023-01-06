package com.work.spring_project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CarParkController {

    @GetMapping("/car_park")
    public String main(Model model) {
        model.addAttribute("title", "Car Park");
        return "car_park";
    }
}
