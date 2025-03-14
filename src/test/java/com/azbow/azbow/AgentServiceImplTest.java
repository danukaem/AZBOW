package com.azbow.azbow;

import com.azbow.azbow.entity.Agent;
import com.azbow.azbow.repository.AgentRepository;
import com.azbow.azbow.service.impl.AgentServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class AgentServiceImplTest {

    @Mock
    private AgentRepository agentRepository;

    @InjectMocks
    private AgentServiceImpl agentServiceImpl;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveAgent() {
        Agent agent = new Agent();
        agent.setAgentId(1L);
        agent.setName("John Doe");

        when(agentRepository.save(any(Agent.class))).thenReturn(agent);

        Map<String, Object> expectedResponse = new HashMap<>();
        expectedResponse.put("lagentId", 1L);
        expectedResponse.put("message", "Agent created successfully");

        Map<String, Object> actualResponse = agentServiceImpl.saveAgent(agent);

        assertEquals(expectedResponse, actualResponse);
    }
}