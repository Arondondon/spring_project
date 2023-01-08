package com.work.spring_project.controllers;

import com.work.spring_project.models.Car;
import com.work.spring_project.models.repositories.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CarParkController {

    @Autowired
    private CarRepo carRepo;

    @GetMapping("/car_park")
    public String main(Model model) {
        Iterable<Car> cars = carRepo.findAll();
        model.addAttribute("cars", cars);
        return "car_park";
    }

    @GetMapping("/car_park/add_car")
    public String add(Model model) {
        return "add_car";
    }

    @PostMapping("/car_park/add_car")
    public String addFromForm(@RequestParam String name, @RequestParam String description, @RequestParam int max_length, @RequestParam int min_price, Model model) {
        Car car = new Car(name, description, max_length, min_price);
        carRepo.save(car);
        return "redirect:/car_park";
    }
}
