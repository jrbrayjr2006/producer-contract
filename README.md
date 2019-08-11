# Producer Cloud Contract Example

## Purpose
The purpose of this project is to provide a working example of a Spring Cloud Stream producer contract implementation.

## Details
### Configuration
The project includes both cloud and contract testing dependencies, which are shown in the POM snippet below:
```xml
	<dependencies>
	    ...
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-amqp</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-stream</artifactId>
		</dependency>
		...
		...
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-contract-verifier</artifactId>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-stream-test-support</artifactId>
			<scope>test</scope>
		</dependency>
	</dependencies>
```

## Resources
- [Contracts on the Producer Side 2.1.3.BUILD-SNAPSHOT](https://cloud-samples.spring.io/spring-cloud-contract-samples/tutorials/contracts_on_the_producer_side.html#_producer_flow_1)
