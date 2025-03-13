package com.azbow.azbow.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Entity
public class Agent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long agentId;
    String name;
    String contactInfo;

    @OneToMany(mappedBy = "agent", cascade = CascadeType.ALL)
    List<Lead> leads;


    public Agent() {
    }

    public Agent(Long agentId, String name, String contactInfo, List<Lead> leads) {
        this.agentId = agentId;
        this.name = name;
        this.contactInfo = contactInfo;
        this.leads = leads;
    }

    public Long getAgentId() {
        return agentId;
    }

    public void setAgentId(Long agentId) {
        this.agentId = agentId;
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

    public List<Lead> getLeads() {
        return leads;
    }

    public void setLeads(List<Lead> leads) {
        this.leads = leads;
    }
}
