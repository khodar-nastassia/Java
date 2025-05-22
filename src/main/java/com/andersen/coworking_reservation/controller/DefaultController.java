package com.andersen.coworking_reservation.controller;
import com.andersen.coworking_reservation.model.User;
import com.andersen.coworking_reservation.security.CustomUserDetails;
import com.andersen.coworking_reservation.security.SecurityUser;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DefaultController {
    @GetMapping("/default")
    public String defaultAfterLogin(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user != null && "ADMIN".equalsIgnoreCase(user.getRole())) {
            return "redirect:/admin";
        }
        return "redirect:/customer";
    }
}
