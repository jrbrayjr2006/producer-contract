package com.jrbrayjr.spring.cloud.stream.producercontract.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CityInfo {

    String cityName;
    String region;
    Long population;
}
