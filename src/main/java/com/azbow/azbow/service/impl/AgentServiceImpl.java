package com.azbow.azbow.service.impl;

import com.azbow.azbow.entity.Agent;
import com.azbow.azbow.repository.AgentRepository;
import com.azbow.azbow.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AgentServiceImpl implements AgentService {
    @Autowired
    AgentRepository agentrepository;

    public  Map<String,Object> saveAgent(Agent agent) {
        Agent save = agentrepository.save(agent);
        Map<String,Object> response = new HashMap<>();
        response.put("lagentId",save.getAgentId());
        response.put("message","Agent created successfully");

        return response;
    }
}
