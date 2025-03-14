package com.azbow.azbow.service.impl;

import com.azbow.azbow.entity.Financials;
import com.azbow.azbow.entity.Lead;
import com.azbow.azbow.entity.Property;
import com.azbow.azbow.entity.Reservation;
import com.azbow.azbow.repository.*;
import com.azbow.azbow.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    LeadRepository leadRepository;

    @Autowired
    PropertyRepository propertyRepository;

    @Autowired
    FinancialRepository financialRepository;

    @Autowired
    Legalrepository legalrepository;


    public Map<String, Object> saveReservation(Map<String, Object> reservationData) {
        Map<String, Object> response = new HashMap<>();

        Reservation reservation = new Reservation();

        Integer leadId = (Integer) reservationData.get("leadId");
        Integer propertyId = (Integer) reservationData.get("propertyId");
        Integer reservationFee = (Integer) reservationData.get("reservationFee");
        String reservationDate = (String) reservationData.get("reservationDate");


        Optional<Lead> lead = leadRepository.findById(Long.valueOf(leadId));
        Optional<Property> property = propertyRepository.findById(Long.valueOf(propertyId));
        if (lead.isPresent() && property.isPresent()) {
            reservation.setLead(lead.get());
            reservation.setProperty(property.get());
            reservation.setReservationFee(Double.valueOf(reservationFee));
            reservation.setReservationDate(LocalDate.parse(reservationDate));

            try {
                Reservation save = reservationRepository.save(reservation);
                response.put("reservationId", save.getReservationId());
                response.put("message", "Reservation  created successfully");

            } catch (Exception e) {
                e.printStackTrace();
                response.put("message", "Reservation  creation failed");

            }
        } else {
            response.put("message", "Reservation  creation failed");

        }


        return response;
    }

    public Map<String, Object> addFinancials(Long reservationId, Map<String, Object> financials) {

        Map<String, Object> response = new HashMap<>();
        Optional<Reservation> reservation = reservationRepository.findById(reservationId);
        if (reservation.isPresent()) {
            Integer loanAmount = (Integer) financials.get("loanAmount");
            String financialStatus = (String) financials.get("financialStatus");
            Integer paymentPlan = (Integer) financials.get("paymentPlan");

            Financials financ = new Financials();
            financ.setReservation(reservation.get());
            financ.setFinancialStatus(financialStatus);
            financ.setLoanAmount(Double.valueOf(loanAmount));
            financ.setPaymentPlan(paymentPlan);

            try {
                financialRepository.save(financ);
                response.put("message", "Financials added successfully");
            } catch (Exception e) {
                e.printStackTrace();
                response.put("message", "Financials addition failed");

            }

        } else {
            response.put("message", "Financials addition failed");

        }
        return response;

    }

    public Map<String, Object> addLegal(Long reservationId, Map<String, Object> legal) {

        Map<String, Object> response = new HashMap<>();
        Optional<Reservation> reservation = reservationRepository.findById(reservationId);
        if (reservation.isPresent()) {
            Boolean contractSigned = (Boolean) legal.get("contractSigned");
            String legalNotes = (String) legal.get("legalNotes");

            com.azbow.azbow.entity.Legal legalEntity = new com.azbow.azbow.entity.Legal();
            legalEntity.setReservation(reservation.get());
            legalEntity.setContractSigned(contractSigned);
            legalEntity.setLegalNotes(legalNotes);

            try {
                legalrepository.save(legalEntity);
                response.put("message", "Legal added successfully");
            } catch (Exception e) {
                e.printStackTrace();
                response.put("message", "Legal addition failed");

            }

        } else {
            response.put("message", "Legal addition failed");

        }
        return response;
    }

    public Map<String, Object> cancelReservation(Long reservationId, Object reason) {

        Map<String, Object> response = new HashMap<>();
        Optional<Reservation> reservation = reservationRepository.findById(reservationId);
        if (reservation.isPresent()) {
            reservationRepository.delete(reservation.get());
            response.put("message", "Reservation cancelled successfully");
        } else {
            response.put("message", "Reservation cancellation failed");

        }
        return response;
    }
}
