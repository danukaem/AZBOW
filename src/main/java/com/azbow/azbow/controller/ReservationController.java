package com.azbow.azbow.controller;

import com.azbow.azbow.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    @PostMapping
    public Map<String, Object> createReservation(@RequestBody Map<String, Object> reservation) {
        return reservationService.saveReservation(reservation);
    }


    @PutMapping("/{reservationId}/financials")
    public Map<String, Object> addFinancials(@PathVariable Long reservationId, @RequestBody Map<String, Object> financials) {
        return reservationService.addFinancials(reservationId, financials);
    }


    @PutMapping("/{reservationId}/legal")
    public Map<String, Object> addLegal(@PathVariable Long reservationId, @RequestBody Map<String, Object> legal) {
        return reservationService.addLegal(reservationId, legal);
    }

    @PutMapping("/{reservationId}/cancel")
    public Map<String, Object> cancelReservation(@PathVariable Long reservationId,@RequestBody Map<String, Object> body) {
        return reservationService.cancelReservation(reservationId,body.get("reason"));
    }



}
