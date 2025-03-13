package com.azbow.azbow.controller;

import com.azbow.azbow.entity.Lead;
import com.azbow.azbow.service.LeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/leads")
public class LeadController {
    @Autowired
    private LeadService leadService;

    @PostMapping
    public Map<String, Object> createLead(@RequestBody Lead lead) {
        return leadService.createLead(lead);
    }

    @GetMapping
    public List<Lead> getLeads() {
        return leadService.getLeads();
    }

    @PutMapping("/{leadId}/{agentId}/assign")
    public Map<String, Object> assignLead(@PathVariable Long leadId, @PathVariable Long agentId) {
        return leadService.assignLead(leadId, agentId);
    }

    @GetMapping("/search/{searchBy}/{searchValue}")
    public List<Lead> searchLeads(@PathVariable String searchBy, @PathVariable String searchValue) {
        return leadService.searchLeads(searchBy, searchValue);
    }

}
