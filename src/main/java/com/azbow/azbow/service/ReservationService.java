package com.azbow.azbow.service;

import java.util.Map;

public interface ReservationService {
    public Map<String, Object> saveReservation(Map<String, Object> reservationData);
    public Map<String, Object> addFinancials(Long reservationId, Map<String, Object> financials);

    public Map<String, Object> addLegal(Long reservationId, Map<String, Object> legal);
    public Map<String, Object> cancelReservation(Long reservationId, Object reason);




}
