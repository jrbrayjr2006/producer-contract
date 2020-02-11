package com.jrbrayjr.spring.cloud.stream.producercontract.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class CityControllerTest {

    CityController controller;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        controller = new CityController();
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    @DisplayName("Given a city name, then should add city to list")
    void givenACity_shouldReturnCreateMessageAndReturnOk() throws Exception {
        // Given
        String endpoint = "/city/{cityName}";
        String cityName = "Cleveland";
        // When
        mockMvc.perform(get(endpoint, cityName)).andExpect(status().isOk());
        // Then
    }
}