package com.azbow.azbow.controller;

import com.azbow.azbow.entity.Agent;
import com.azbow.azbow.service.impl.AgentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/agents")
public class AgentController {

    @Autowired
    AgentServiceImpl agentServiceImpl;

    @PostMapping
    public Map<String, Object> createAgent(@RequestBody Agent agent) {
        return agentServiceImpl.saveAgent(agent);
    }

}
