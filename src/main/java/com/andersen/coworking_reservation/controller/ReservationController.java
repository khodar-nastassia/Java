package com.andersen.coworking_reservation.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservations")
@RequiredArgsConstructor
public class ReservationController {
    private final ReservationRepository reservationRepo;
    private final UserRepository userRepo;
    private final WorkplaceRepository workplaceRepo;

    @PostMapping
    public ResponseEntity<Reservation> create(@RequestBody ReservationRequest request) {
        User user = userRepo.findById(request.getUserId()).orElseThrow();
        Workplace workplace = workplaceRepo.findById(request.getWorkplaceId()).orElseThrow();

        Reservation reservation = new Reservation(
                null,
                user,
                workplace,
                request.getDate(),
                request.getStartTime(),
                request.getEndTime()
        );

        return ResponseEntity.ok(reservationRepo.save(reservation));
    }
}
