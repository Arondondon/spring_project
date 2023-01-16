package com.work.spring_project.controllers;

import com.work.spring_project.models.Car;
import com.work.spring_project.models.Order;
import com.work.spring_project.models.Service;
import com.work.spring_project.models.User;
import com.work.spring_project.models.repositories.CarRepo;
import com.work.spring_project.models.repositories.OrderRepo;
import com.work.spring_project.models.repositories.ServiceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


/**
 * Service (choice)
 * Car (choice)
 * Customer (locked)
 * Telephone number (locked)
 * Email (locked)
 * Delivery from
 * Delivery to
 * Delivery out of town (check)
 * Oversized delivery (check)
 * Commentary
 * Total price (calculated)
 */

@Controller
public class OrderController {

    @Autowired
    private ServiceRepo serviceRepo;

    @Autowired
    private CarRepo carRepo;

    @Autowired
    private OrderRepo orderRepo;

    private Order curOrder;

    @GetMapping("/order")
    public String main(@AuthenticationPrincipal User user, Model model) {
        Iterable<Service> services = serviceRepo.findAll();
        Iterable<Car> cars = carRepo.findAll();
        model.addAttribute("services", services);
        model.addAttribute("cars", cars);
        model.addAttribute("user",user);
        return "order";
    }

    @PostMapping("/order")
    public String orderForm(@AuthenticationPrincipal User user, @RequestParam Car car, @RequestParam Service service,
                           @RequestParam String deliveryFrom, @RequestParam String deliveryTo,
                           @RequestParam(required = false) String outOfTown, @RequestParam(required = false) String oversized,
                           @RequestParam String commentary, Model model) {

        boolean delOutOfTown;
        if(outOfTown != null) {
            delOutOfTown = true;
        } else {
            delOutOfTown = false;
        }

        boolean oversizedDel;
        if(oversized != null) {
            oversizedDel = true;
        } else {
            oversizedDel = false;
        }

        Order order = new Order(user, service, car, deliveryTo, deliveryFrom, commentary, delOutOfTown, oversizedDel);
        order.setTotal_price(order.calculatePrice());
        curOrder = order;

        return "redirect:/order/confirm";
    }

    @GetMapping("/order/confirm")
    public String confirm(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("order", curOrder);

        return "confirm";
    }

    @PostMapping("/order/confirm")
    public String addOrder(Model model) {
        orderRepo.save(curOrder);

        //return "redirect:/send/" + curOrder.getId();
        return "redirect:/";
    }

}
