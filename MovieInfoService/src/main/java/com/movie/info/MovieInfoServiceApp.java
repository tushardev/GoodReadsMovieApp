package com.movie.info;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class MovieInfoServiceApp
{
    @Bean
    public RestTemplate getRestTemplate() {return new RestTemplate();}


    public static void main( String[] args )
    { SpringApplication.run(MovieInfoServiceApp.class, args);
    }
}
