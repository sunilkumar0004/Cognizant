package com.cognizant.springlearn;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Base64;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import com.cognizant.springlearn.controller.AuthenticationController;
import com.cognizant.springlearn.controller.CountryController;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
class SpringLearnApplicationTests {

    @Autowired
    private AuthenticationController authenticationController;

    @Autowired
    private CountryController countryController;

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void contextLoads() {
        assertNotNull(authenticationController);
        assertNotNull(countryController);
    }

    @Test
    void testAuthenticateSuccess() throws Exception {
        String basicAuth = "Basic " + Base64.getEncoder().encodeToString("user:pwd".getBytes());
        ResultActions actions = mvc.perform(get("/authenticate").header("Authorization", basicAuth));

        actions.andExpect(status().isOk());
        actions.andExpect(jsonPath("$.token").exists());
    }

    @Test
    void testUnauthenticatedAccess() throws Exception {
        ResultActions actions = mvc.perform(get("/countries"));
        actions.andExpect(status().isUnauthorized());
    }

    @Test
    void testAuthenticatedAccessWithJwt() throws Exception {
        // Step 1: Authenticate to get JWT token
        String basicAuth = "Basic " + Base64.getEncoder().encodeToString("user:pwd".getBytes());
        MvcResult result = mvc.perform(get("/authenticate").header("Authorization", basicAuth))
                .andExpect(status().isOk())
                .andReturn();

        String responseString = result.getResponse().getContentAsString();
        JsonNode jsonNode = objectMapper.readTree(responseString);
        String token = jsonNode.get("token").asText();

        // Step 2: Invoke protected endpoint with Bearer token
        ResultActions countryActions = mvc.perform(get("/countries")
                .header("Authorization", "Bearer " + token));

        countryActions.andExpect(status().isOk());
        countryActions.andExpect(jsonPath("$[0].code").value("IN"));
    }

    @Test
    void testInvalidJwtAccess() throws Exception {
        ResultActions actions = mvc.perform(get("/countries")
                .header("Authorization", "Bearer invalid.jwt.token"));

        actions.andExpect(status().isUnauthorized());
    }
}
