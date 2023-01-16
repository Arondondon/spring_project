package com.work.spring_project.controllers;

import com.work.spring_project.models.Order;
import com.work.spring_project.models.repositories.OrderRepo;
import com.work.spring_project.models.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class MailController {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private EmailService emailService;

    @GetMapping("/send/{id}")
    public String send(@PathVariable(name = "id") Long id) {
        Order order = orderRepo.findById(id).get();

        emailService.sendSimpleEmail(order.getUser().getEmail(), "Welcome",
                "This is a welcome email for you!");

        /*
        SimpleMailMessage msg = new SimpleMailMessage(this.templateMessage);
        msg.setTo(order.getUser().getEmail());
        msg.setText("");
        try{
            this.mailSender.send(msg);
        }
        catch(MailException ex) {
            // simply log it and go on...
            System.err.println(ex.getMessage());
        }

         */

        return "redirect:/";
    }

}
