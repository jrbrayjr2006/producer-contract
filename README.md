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

### Type
The type of communication between this microservice and its consumer(s) is via messages. The default `Source.class` interface is bound to the microservice.

`@EnableBinding(value = {Source.class})`

## Testing

### Unit Testing
The unit tests are standard unit tests using Junit 5.

Run the tests with the following command:

`./mvnw test`

### Contract Testing
The contract test is dependent on the contract which is written in Groovy in this service.  An alternative version of this contract could be YAML.

```groovy
package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description(
            'Will send city data'
    )
    label(
            'City Producer Contract'
    )
    input {
        triggeredBy(
                'createCityMessage()'
        )
    }
    outputMessage {
        sentTo('output')
        body(city: alphaNumeric())
    }
}
```

The contract test is an abstract class with a verifier annotation:

```java
...
...
@AutoConfigureMessageVerifier
@RunWith(SpringRunner.class)
@SpringBootTest( classes = ProducerContractApplication.class, webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@ExtendWith(SpringExtension.class)
@DirtiesContext
public abstract class ProducerContractTest {
    ...
    ...
    
    
    ...
    ...
}
```

## Resources
- [Contracts on the Producer Side 2.1.3.BUILD-SNAPSHOT](https://cloud-samples.spring.io/spring-cloud-contract-samples/tutorials/contracts_on_the_producer_side.html#_producer_flow_1)
