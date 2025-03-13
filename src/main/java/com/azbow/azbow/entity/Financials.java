package com.azbow.azbow.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Financials {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long financialId;
    String financialStatus;
    Double loanAmount;
    @OneToOne
    @JoinColumn(name = "reservation_id", referencedColumnName = "reservationId")
    Reservation reservation;

    int paymentPlan;


    public Financials() {
    }

    public Financials(Long financialId, String financialStatus, Double loanAmount, Reservation reservation, int paymentPlan) {
        this.financialId = financialId;
        this.financialStatus = financialStatus;
        this.loanAmount = loanAmount;
        this.reservation = reservation;
        this.paymentPlan = paymentPlan;
    }

    public Long getFinancialId() {
        return financialId;
    }

    public void setFinancialId(Long financialId) {
        this.financialId = financialId;
    }

    public String getFinancialStatus() {
        return financialStatus;
    }

    public void setFinancialStatus(String financialStatus) {
        this.financialStatus = financialStatus;
    }

    public Double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(Double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public int getPaymentPlan() {
        return paymentPlan;
    }

    public void setPaymentPlan(int paymentPlan) {
        this.paymentPlan = paymentPlan;
    }
}
