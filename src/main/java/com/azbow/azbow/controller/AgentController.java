package com.azbow.azbow.controller;

import com.azbow.azbow.entity.Agent;
import com.azbow.azbow.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/agents")
public class AgentController {

    @Autowired
    AgentService agentService;

    @PostMapping
    public Map<String, Object> createAgent(@RequestBody Agent agent) {
        return agentService.saveAgent(agent);
    }

}
