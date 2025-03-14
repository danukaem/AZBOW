package com.azbow.azbow.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "lead_table")
public class Lead {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long id;

    private String name;
    private String contactInfo;
    private String source;
    private LocalDate inquiryDate;


    @Enumerated(EnumType.STRING)
    private LeadStatus status = LeadStatus.UNASSIGNED;


    @ManyToOne
    @JoinColumn(name = "agent_id", referencedColumnName = "agentId")
    private Agent agent;


    public Lead() {
    }

    public Lead(Long id, String name, String contactInfo, String source, LocalDate inquiryDate, LeadStatus status, Agent agent) {
        this.id = id;
        this.name = name;
        this.contactInfo = contactInfo;
        this.source = source;
        this.inquiryDate = inquiryDate;
        this.status = status;
        this.agent = agent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public LocalDate getInquiryDate() {
        return inquiryDate;
    }

    public void setInquiryDate(LocalDate inquiryDate) {
        this.inquiryDate = inquiryDate;
    }

    public LeadStatus getStatus() {
        return status;
    }

    public void setStatus(LeadStatus status) {
        this.status = status;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }
}

