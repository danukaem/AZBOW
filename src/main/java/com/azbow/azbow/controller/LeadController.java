package com.azbow.azbow.controller;

import com.azbow.azbow.entity.Lead;
import com.azbow.azbow.service.impl.LeadServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/leads")
public class LeadController {
    @Autowired
    private LeadServiceImpl leadServiceImpl;

    @PostMapping
    public Map<String, Object> createLead(@RequestBody Lead lead) {
        return leadServiceImpl.createLead(lead);
    }

    @GetMapping
    public List<Lead> getLeads() {
        return leadServiceImpl.getLeads();
    }

    @PutMapping("/{leadId}/{agentId}/assign")
    public Map<String, Object> assignLead(@PathVariable Long leadId, @PathVariable Long agentId) {
        return leadServiceImpl.assignLead(leadId, agentId);
    }

    @GetMapping("/search/{searchBy}/{searchValue}")
    public List<Lead> searchLeads(@PathVariable String searchBy, @PathVariable String searchValue) {
        return leadServiceImpl.searchLeads(searchBy, searchValue);
    }

}
