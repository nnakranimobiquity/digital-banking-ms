package com.mobiquity.neel.apigateway.connfiguration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

    @Bean
    RouteLocator gatewayRouter(RouteLocatorBuilder builder){
        return builder.routes()
//                .route(p -> p.path("/get")
//                        .filters(f -> f.addRequestHeader("MyHeaders", "MyUrl"))
//                        .uri("http://httpbin.org:80"))
                .route(p -> p.path("/customer-service/**")
                        .uri("lb://customer-service"))
                .route(p -> p.path("/populate-data/**")
                        .uri("lb://customer-service"))
                .route(p -> p.path("/otp-service/**")
                        .uri("lb://otp-service"))
                .build();
    }
}
