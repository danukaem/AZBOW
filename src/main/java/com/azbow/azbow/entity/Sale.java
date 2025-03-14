package com.azbow.azbow.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
@Entity
@Data
public class Sale {
    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long saleId;
    LocalDate saleDate;
    Double salePrice;
    @OneToOne
    @JoinColumn(name = "lead_id", referencedColumnName = "id")
    private Lead lead;


    public Sale() {
    }

    public Sale(Long saleId, LocalDate saleDate, Double salePrice, Lead lead) {        this.saleId = saleId;
        this.saleDate = saleDate;
        this.salePrice = salePrice;
        this.lead = lead;
    }

    public Long getSaleId() {
        return saleId;
    }

    public void setSaleId(Long saleId) {
        this.saleId = saleId;
    }

    public LocalDate getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(LocalDate saleDate) {
        this.saleDate = saleDate;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    public Lead getLead() {
        return lead;
    }

    public void setLead(Lead lead) {
        this.lead = lead;
    }
}
