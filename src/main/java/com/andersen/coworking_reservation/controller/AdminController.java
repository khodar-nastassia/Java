package com.andersen.coworking_reservation.controller;

import com.andersen.coworking_reservation.model.User;
import com.andersen.coworking_reservation.model.Workplace;
import com.andersen.coworking_reservation.service.WorkplaceService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
            return "redirect:/login";
        }
        model.addAttribute("user", user);
        return "admin";
    }

    @GetMapping("/add-workplace")
    public String addWorkplaceForm(Model model) {
        model.addAttribute("workplace", new Workplace());
        return "add-workplace";
    }

    @PostMapping("/add-workplace")
    public String addWorkplace(@ModelAttribute Workplace workplace) {
        workplace.setIsAvailable(true);
        workplaceService.addWorkplace(workplace);
        return "redirect:/admin";
    }
    @GetMapping("/remove-workplace")
    public String removeWorkplaceForm(Model model) {
        model.addAttribute("workplaces", workplaceService.getAllWorkplaces());
        return "remove-workplace";
    }

    @PostMapping("/remove-workplace")
    public String deleteWorkplace(@RequestParam("id") int id) {
        workplaceService.deleteWorkplace(id);
        return "redirect:/admin/remove-workplace";
    }
}