package com.azbow.azbow.repository;

import com.azbow.azbow.entity.Legal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Legalrepository extends JpaRepository<Legal,Long> {
}
