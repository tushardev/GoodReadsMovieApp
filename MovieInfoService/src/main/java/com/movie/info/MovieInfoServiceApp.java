package com.movie.info;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class MovieInfoServiceApp
{
    public static void main( String[] args )
    { SpringApplication.run(MovieInfoServiceApp.class, args);
    }
}
