package com.jrbrayjr.spring.cloud.stream.producercontract;

import com.jrbrayjr.spring.cloud.stream.producercontract.handler.CityMessageHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.verifier.messaging.MessageVerifier;
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

@AutoConfigureMessageVerifier
@RunWith(SpringRunner.class)
@SpringBootTest( classes = ProducerContractApplication.class, webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@ExtendWith(SpringExtension.class)
@DirtiesContext
public abstract class ProducerContractTest {

    @Autowired
    CityMessageHandler handler;

    @Autowired
    Source source;

    @Inject
    MessageVerifier messaging;

    Map<String, String> cityMap;


    @BeforeEach
    void setUp() {
        cityMap = new HashMap<>();
        //messaging.receive("output");
    }

    public void createCityMessage() {
        cityMap.put("city", "Chicago");
        handler.sendCityMessage(cityMap);
    }
}
