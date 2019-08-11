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