package com.azbow.azbow.repository;

import com.azbow.azbow.entity.Financials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinancialRepository extends JpaRepository<Financials,Long> {
}
