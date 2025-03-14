package com.azbow.azbow.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Property {
    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long propertyId;
    String location;
    Double price;

    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL)
    List<Reservation> reservations;

    public Property() {
    }

    public Property(Long propertyId, String location, Double price, List<Reservation> reservations) {
        this.propertyId = propertyId;
        this.location = location;
        this.price = price;
        this.reservations = reservations;
    }

    public Long getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Long propertyId) {
        this.propertyId = propertyId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
