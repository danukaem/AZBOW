package com.azbow.azbow.service;

import com.azbow.azbow.entity.Lead;

import java.util.List;
import java.util.Map;

public interface LeadService {

    public Map<String, Object> createLead(Lead lead);
    public List<Lead> getLeads();
    public Map<String, Object> assignLead(Long leadId, Long agentId);
    public List<Lead> searchLeads(String searchBy, String searchValue);
    
    
}
