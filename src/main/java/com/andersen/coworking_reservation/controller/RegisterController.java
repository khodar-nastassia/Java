package com.andersen.coworking_reservation.controller;

import com.andersen.coworking_reservation.model.User;
import com.andersen.coworking_reservation.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class RegisterController {
    private final UserService userService;

    @Autowired
    public RegisterController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/register")
    public String showRegisterPage() {
        return "register";
    }
    @PostMapping("/register")
    public String registerForm(@RequestParam("name") String name,
                           @RequestParam("email") String email,
                           @RequestParam("role") String role,
                        Model model, HttpSession session) {
        Optional<User> optionalUser = userService.findByEmail(email);


        if (optionalUser != null) {
            model.addAttribute("error", "An account already exists. Please login.");
            return "redirect:/login";
        }

        User user = new User(name,email,role);
        userService.register(user);
        session.setAttribute("user", user);


        if ("ADMIN".equalsIgnoreCase(user.getRole())) {

            return "redirect:/admin";
        } else {
            return "redirect:/customer";
        }
    }
}
