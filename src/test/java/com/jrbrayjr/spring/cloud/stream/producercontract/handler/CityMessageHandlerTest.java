package com.jrbrayjr.spring.cloud.stream.producercontract.handler;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CityMessageHandlerTest {


    private Source mockSource;

    CityMessageHandler handler;

    @BeforeEach
    void setUp() {
        mockSource = mock(Source.class);
        handler = new CityMessageHandler(mockSource);
    }

    @Test
    void shouldInvokeSourceOutputWhenSendMessage() {
        // Given
        Map<String, String> dummyCity = new HashMap<>();
        dummyCity.put("city", "Chicago");
        MessageChannel mockMessageChannel = mock(MessageChannel.class);
        // When
        when(mockSource.output()).thenReturn(mockMessageChannel);
        handler.sendCityMessage(dummyCity);
        // Then
        verify(mockSource).output();
    }
}