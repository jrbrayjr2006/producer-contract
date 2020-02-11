package com.jrbrayjr.spring.cloud.stream.producercontract.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class CityController {

    @GetMapping( value = "/city/{cityName}", produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<Void> addCity(@PathVariable String cityName) {
        ResponseEntity<Void> response = ResponseEntity.ok().build();
        return response;
    }
}
