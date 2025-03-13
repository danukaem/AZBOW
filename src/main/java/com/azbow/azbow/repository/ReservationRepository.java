package com.azbow.azbow.repository;

import com.azbow.azbow.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation ,Long> {
}
