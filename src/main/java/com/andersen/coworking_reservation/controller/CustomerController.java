package com.andersen.coworking_reservation.controller;

import com.andersen.coworking_reservation.model.Reservation;
import com.andersen.coworking_reservation.model.User;
import com.andersen.coworking_reservation.model.Workplace;
import com.andersen.coworking_reservation.service.ReservationService;
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

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private final ReservationService reservationService;
    private final WorkplaceService workplaceService;

    @Autowired
    public CustomerController(WorkplaceService workplaceService, ReservationService reservationService){
        this.workplaceService = workplaceService;
        this.reservationService = reservationService;
    }
    @GetMapping
    public String customerHome(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        if (user == null) return "redirect:/login";

        model.addAttribute("user", user);
        return "customer";
    }

    @GetMapping("/available-workplaces")
    public String viewAvailableWorkplaces(Model model) {
        List<Workplace> available = workplaceService.getAvailableWorkplaces();
        model.addAttribute("availableWorkplaces", available);
        return "available-workplaces";
    }

    @GetMapping("/make-reservation")
    public String showReservationForm(Model model) {
        model.addAttribute("reservation", new Reservation());
        model.addAttribute("availableWorkplaces", workplaceService.getAvailableWorkplaces());
        return "make-reservation";
    }


    @PostMapping("/make-reservation")
    public String makeReservation(@ModelAttribute Reservation reservation, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) return "redirect:/login";

        reservation.setCustomerName(user.getName());
        reservationService.reserve(reservation);
        return "redirect:/customer";
    }

    // 3. Показать бронирования клиента
    @GetMapping("/my-reservations")
    public String viewMyReservations(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        if (user == null) return "redirect:/login";

        List<Reservation> reservations = reservationService.getByCustomerName(user.getName());
        model.addAttribute("myReservations", reservations);
        return "my-reservations";
    }

    // 4. Показать форму отмены бронирования
    @GetMapping("/cancel-reservation")
    public String showCancelReservationForm(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        if (user == null) return "redirect:/login";

        List<Reservation> reservations = reservationService.getByCustomerName(user.getName());
        model.addAttribute("myReservations", reservations);
        return "cancel-reservation";
    }

    // 4. Обработка отмены бронирования
    @PostMapping("/cancel-reservation")
    public String cancelReservation(@RequestParam("id") int reservationId) {
        reservationService.cancel(reservationId);
        return "redirect:/customer/my-reservations";
    }


}
