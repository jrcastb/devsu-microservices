package com.microservices.accountservice.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
    //utiliza Spring webFlux
    @Bean
    @LoadBalanced //Agrega el balanceador de carga del lado del cliente
    public WebClient.Builder webClientBuilder(){
        return WebClient.builder();
    }
}
