package com.azbow.azbow.repository;


import com.azbow.azbow.entity.Agent;
import com.azbow.azbow.entity.Lead;
import com.azbow.azbow.entity.LeadStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface LeadRepository extends JpaRepository<Lead, Long> {

    @Query("SELECT l FROM Lead l WHERE l.agent.id = :agentId")
    List<Lead> findByAgent(String agentId);

    @Query("SELECT l FROM Lead l WHERE l.status = :status")
    List<Lead> findByStatus(LeadStatus status);
}
