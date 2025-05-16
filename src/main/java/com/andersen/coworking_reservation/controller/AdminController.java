package com.andersen.coworking_reservation.controller;

import com.andersen.coworking_reservation.model.User;
import com.andersen.coworking_reservation.model.Workplace;
import com.andersen.coworking_reservation.service.WorkplaceService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final WorkplaceService workplaceService;

    @Autowired
    public AdminController(WorkplaceService workplaceService) {
        this.workplaceService = workplaceService;
    }

    @GetMapping
    public String adminHome(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/login-details-view";
        }
        model.addAttribute("user", user);
        return "admin-action-view";
    }

    @GetMapping("/add-workplace")
    public String addWorkplace() {
        return "admin-add-place-view";
    }

    @PostMapping("/add-workplace")
    public String addWorkplace(@RequestParam("type") String type,
                                @RequestParam("price") double price,
                               HttpSession session) {
        workplaceService.add(new Workplace(type,price));
        return "redirect:/admin";
    }

    @PostMapping("/remove-workplace")
    public String deleteSpace(@RequestParam int id) {
        workplaceService.delete(id);
        return "redirect:/admin/remove-space";
    }
}