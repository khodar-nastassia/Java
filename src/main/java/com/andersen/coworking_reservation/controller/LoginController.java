package com.andersen.coworking_reservation.controller;

import com.andersen.coworking_reservation.model.User;
import com.andersen.coworking_reservation.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class LoginController {

    private final UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }
    @PostMapping("/login")
    public String loginForm(@RequestParam("email") String email,
                        @RequestParam("name") String name,
                        HttpSession session) {
        Optional<User> optionalUser = userService.findByEmail(email);

        if (optionalUser.isEmpty()) {
            return "redirect:/register";
        }

        User user = optionalUser.get();
        session.setAttribute("user", user);

        if ("ADMIN".equalsIgnoreCase(user.getRole())) {
            return "redirect:/admin";
        } else {
            return "redirect:/customer";
        }
    }
}
