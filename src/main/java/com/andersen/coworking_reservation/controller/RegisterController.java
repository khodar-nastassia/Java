package com.andersen.coworking_reservation.controller;

import com.andersen.coworking_reservation.model.User;
import com.andersen.coworking_reservation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterController {
    private final UserService userService;

    @Autowired
    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public String register(@RequestParam("name") String name,
                           @RequestParam("email") String email,
                           @RequestParam("role") String role,
                        Model model) {


        if (userService.findByEmail(email) != null) {
            model.addAttribute("error", "An account already exists. Please login.");
            return "register-details-view";
        }
        User user = new User(name,email,role);
        userService.register(user);


        if ("ADMIN".equalsIgnoreCase(user.getRole())) {
            model.addAttribute("username", user.getName());
            return "admin-action-view";
        } else {
            model.addAttribute("username", user.getName());
            return "customer-action-view";
        }
    }
}
