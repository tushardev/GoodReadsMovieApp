package com.movie.catalog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableCircuitBreaker
public class MovieCatalogServiceApp {
    public static void main( String[] args )
    {
        SpringApplication.run(MovieCatalogServiceApp.class, args);
    }
}
