package com.azbow.azbow.controller;

import com.azbow.azbow.service.impl.ReservationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    @Autowired
    ReservationServiceImpl reservationServiceImpl;

    @PostMapping
    public Map<String, Object> createReservation(@RequestBody Map<String, Object> reservation) {
        return reservationServiceImpl.saveReservation(reservation);
    }


    @PutMapping("/{reservationId}/financials")
    public Map<String, Object> addFinancials(@PathVariable Long reservationId, @RequestBody Map<String, Object> financials) {
        return reservationServiceImpl.addFinancials(reservationId, financials);
    }


    @PutMapping("/{reservationId}/legal")
    public Map<String, Object> addLegal(@PathVariable Long reservationId, @RequestBody Map<String, Object> legal) {
        return reservationServiceImpl.addLegal(reservationId, legal);
    }

    @PutMapping("/{reservationId}/cancel")
    public Map<String, Object> cancelReservation(@PathVariable Long reservationId,@RequestBody Map<String, Object> body) {
        return reservationServiceImpl.cancelReservation(reservationId,body.get("reason"));
    }



}
