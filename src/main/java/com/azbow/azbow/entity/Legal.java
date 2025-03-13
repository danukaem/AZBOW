package com.azbow.azbow.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Legal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long legalId;
    Boolean contractSigned;
    @OneToOne
    @JoinColumn(name = "reservation_id", referencedColumnName = "reservationId")
    Reservation reservation;
    String legalNotes;


    public Legal() {
    }

    public Legal(Long legalId, Boolean contractSigned, Reservation reservation, String legalNotes) {
        this.legalId = legalId;
        this.contractSigned = contractSigned;
        this.reservation = reservation;
        this.legalNotes = legalNotes;
    }

    public Long getLegalId() {
        return legalId;
    }

    public void setLegalId(Long legalId) {
        this.legalId = legalId;
    }

    public Boolean getContractSigned() {
        return contractSigned;
    }

    public void setContractSigned(Boolean contractSigned) {
        this.contractSigned = contractSigned;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public String getLegalNotes() {
        return legalNotes;
    }

    public void setLegalNotes(String legalNotes) {
        this.legalNotes = legalNotes;
    }
}
