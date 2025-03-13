package com.azbow.azbow.service;

import com.azbow.azbow.entity.Agent;
import com.azbow.azbow.entity.Lead;
import com.azbow.azbow.entity.LeadStatus;
import com.azbow.azbow.repository.AgentRepository;
import com.azbow.azbow.repository.LeadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class LeadService {

    @Autowired
    private LeadRepository leadRepository;

    @Autowired
    AgentRepository agentRepository;

    public Map<String, Object> createLead(Lead lead) {

        Lead save = leadRepository.save(lead);
        Map<String, Object> response = new HashMap<>();
        response.put("leadId", save.getId());
        response.put("message", "Lead created successfully");

        return response;
    }


    public List<Lead> getLeads() {
        return leadRepository.findAll();
    }

    public Map<String, Object> assignLead(Long leadId, Long agentId) {
        Map<String, Object> response = new HashMap<>();
        Optional<Agent> byId = agentRepository.findById(agentId);
        Optional<Lead> lead = leadRepository.findById(leadId);

        if (lead.isPresent()) {
            if (byId.isPresent()) {
                Agent agent = byId.get();
                Lead lead1 = lead.get();
                lead1.setAgent(agent);
                lead1.setStatus(LeadStatus.ASSIGNED);
                leadRepository.save(lead1);
                response.put("message", "Agent assigned successfully");
                return response;
            } else {
                response.put("message", "Agent not found");
            }
        } else {
            response.put("message", "Lead not found");

        }

        return response;
    }

    public List<Lead> searchLeads(String searchBy, String searchValue) {

        if (searchBy.equals("agent")) {
            return leadRepository.findByAgent(searchValue);
        } else if (searchBy.equals("status")) {
            switch (searchValue) {
                case "UNASSIGNED":
                    return leadRepository.findByStatus(LeadStatus.UNASSIGNED);
                case "ASSIGNED":
                    return leadRepository.findByStatus(LeadStatus.ASSIGNED);
                case "RESERVATION":
                    return leadRepository.findByStatus(LeadStatus.RESERVATION);
                case "FINANCIAL_APPROVED":
                    return leadRepository.findByStatus(LeadStatus.FINANCIAL_APPROVED);
                case "LEGAL_FINALIZED":
                    return leadRepository.findByStatus(LeadStatus.LEGAL_FINALIZED);
                case "SOLD":
                    return leadRepository.findByStatus(LeadStatus.SOLD);
                case "CANCELLED":
                    return leadRepository.findByStatus(LeadStatus.CANCELLED);
            }
        }
        return null;

    }
}
