package com.andersen.coworking_reservation.controller;

import com.andersen.coworking_reservation.model.User;
import com.andersen.coworking_reservation.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private final UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public String login(@RequestParam("email") String email,
                        @RequestParam("name") String name,
                        HttpSession session) {
        User user = userService.findByEmail(email);

        if (user == null) {
            return "redirect:/register-details-view";
        }

        session.setAttribute("user", user);

        if ("ADMIN".equalsIgnoreCase(user.getRole())) {
            return "redirect:/admin";
        } else {
            return "redirect:/customer";
        }
    }
}
