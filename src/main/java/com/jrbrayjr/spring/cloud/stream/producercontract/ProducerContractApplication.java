package com.jrbrayjr.spring.cloud.stream.producercontract;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;

@EnableBinding(value = {Source.class})
@SpringBootApplication
public class ProducerContractApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProducerContractApplication.class, args);
	}

}
