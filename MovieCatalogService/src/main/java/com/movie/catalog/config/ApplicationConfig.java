package com.movie.catalog.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ApplicationConfig {

    /* create a bean for Rest Template with Load Balance */
    @Bean
    @LoadBalanced
    @Qualifier("LoadBalancedRestTemplate")
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    /* create Normal Rest Template */
    @Bean
    @Qualifier("NormalRestTemplate")
    public RestTemplate getNormalRestTemplate() {return new RestTemplate();}

    /* Create Web Client from Reactive Stream */
    @Bean
    public WebClient.Builder getWebClientBuilder() {
        return WebClient.builder();
    }
}
