package com.azbow.azbow;

import com.azbow.azbow.controller.AgentController;
import com.azbow.azbow.entity.Agent;
import com.azbow.azbow.service.AgentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class AgentControllerTest {

    private MockMvc mockMvc;

    @Mock
    private AgentService agentService;

    @InjectMocks
    private AgentController agentController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(agentController).build();
    }

    @Test
    public void testCreateAgent() throws Exception {
        Agent agent = new Agent();
        agent.setAgentId(1L);
        agent.setName("John Doe");

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Agent created successfully");

        when(agentService.saveAgent(any(Agent.class))).thenReturn(response);

        mockMvc.perform(post("/api/agents")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"John Doe\"}"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"message\":\"Agent created successfully\"}"));
    }
}