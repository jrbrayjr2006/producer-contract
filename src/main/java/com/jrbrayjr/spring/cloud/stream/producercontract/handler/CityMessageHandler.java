package com.jrbrayjr.spring.cloud.stream.producercontract.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class CityMessageHandler {

    Source source;

    public CityMessageHandler(Source source) {
        this.source = source;
    }

    private static final String TAG = "CityMessageHandler";

    @SendTo(Source.OUTPUT)
    public void sendCityMessage(Map<String, String> city) {
        log.debug(TAG, "Sending message: " + city.toString());
        Map<String, Object> headerMap = new HashMap<>();
        headerMap.put(MessageHeaders.CONTENT_TYPE, "application/json");
        MessageHeaders messageHeaders = new MessageHeaders(headerMap);
        Message<Map<String, String>> message = MessageBuilder.createMessage(city, messageHeaders);
        source.output().send(message);
    }
}
