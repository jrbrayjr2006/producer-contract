package com.jrbrayjr.spring.cloud.stream.producercontract.handler;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.cloud.stream.messaging.Source;

import static org.mockito.Mockito.mock;

import static org.junit.jupiter.api.Assertions.*;

class CityMessageHandlerTest {


    private Source mockSource;

    CityMessageHandler handler;

    @BeforeEach
    void setUp() {
        mockSource = mock(Source.class);
        handler = new CityMessageHandler(mockSource);
    }

    @Test
    void shouldSendMesage() {
        // Given

        // When

        // Then
    }
}