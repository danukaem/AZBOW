package com.azbow.azbow.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long reservationId;
    LocalDate reservationDate;
    Double reservationFee;
    @OneToOne
    @JoinColumn(name = "lead_id", referencedColumnName = "id")
    private Lead lead;

    @ManyToOne
    @JoinColumn(name = "propertyId", referencedColumnName = "propertyId")
    Property property;

    public Reservation() {
    }

    public Reservation(Long reservationId, LocalDate reservationDate, Double reservationFee, Lead lead, Property property) {
        this.reservationId = reservationId;
        this.reservationDate = reservationDate;
        this.reservationFee = reservationFee;
        this.lead = lead;
        this.property = property;
    }

    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }

    public LocalDate getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(LocalDate reservationDate) {
        this.reservationDate = reservationDate;
    }

    public Double getReservationFee() {
        return reservationFee;
    }

    public void setReservationFee(Double reservationFee) {
        this.reservationFee = reservationFee;
    }

    public Lead getLead() {
        return lead;
    }

    public void setLead(Lead lead) {
        this.lead = lead;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }
}
