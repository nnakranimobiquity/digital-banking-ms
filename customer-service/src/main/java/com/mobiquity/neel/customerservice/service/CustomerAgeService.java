package com.mobiquity.neel.customerservice.service;

import com.mobiquity.neel.customerservice.dto.AgeResponseDto;
import com.mobiquity.neel.customerservice.exception.ValidationFailedException;
import com.mobiquity.neel.customerservice.util.Properties;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class CustomerAgeService {

    private final Properties properties;

    private final RestTemplate restTemplate;

    public CustomerAgeService(Properties properties, RestTemplate restTemplate) {
        this.properties = properties;
        this.restTemplate = restTemplate;
    }

//    public String findAgeForCustomer(String userName){
//        Mono<AgeResponseDto> ageResponseDtoMono = WebClient.create().get().uri(properties.getUrl() + userName).retrieve().bodyToMono(AgeResponseDto.class);
//        AgeResponseDto ageResponseDto = ageResponseDtoMono.blockOptional().orElseThrow(ValidationFailedException::new);
//        return ageResponseDto.getAge();
//    }

    public String findAgeForCustomer1(String userName){

//        RestTemplate restTemplate = new RestTemplate();

        System.out.println("url-----" + properties.getUrl());

        ResponseEntity<AgeResponseDto> exchange = restTemplate.exchange(properties.getUrl() + userName,
                HttpMethod.GET,
                null,
                AgeResponseDto.class);

        AgeResponseDto body = Optional.ofNullable(exchange.getBody()).orElseThrow(ValidationFailedException::new);
        return body.getAge();
    }
}
