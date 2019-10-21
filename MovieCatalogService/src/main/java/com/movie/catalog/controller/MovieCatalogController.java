package com.movie.catalog.controller;

import com.movie.catalog.model.Movie;
import com.movie.catalog.model.MovieDetails;
import com.movie.catalog.model.MovieRatingDetails;
import com.movie.catalog.model.UserRatingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class MovieCatalogController {

    @Autowired
    @Qualifier("LoadBalancedRestTemplate")
    private RestTemplate restTemplate;

    @Autowired
    @Qualifier("NormalRestTemplate")
    private RestTemplate normalRestTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    /*****
     * This method uses Service Discovery for REST calls. We are using Load Balanced Rest Template for Service Discovery.
     * @param userId
     * @return
     */
    @RequestMapping("/movie/catalog/discovery/{userId}")
    public List<Movie> getMovieCatalogUsingServiceDiscovery(@PathVariable("userId") String userId) {

        /* You can check what instances you have for service on Eureka */
        List<ServiceInstance> instancesList = discoveryClient.getInstances("Movie-Rating-Service-App");
        System.out.println(instancesList);

        List<String> serviceList = discoveryClient.getServices();
        System.out.println(serviceList);

        /* Get the required data by calling different services */
        UserRatingResponse userRatings = restTemplate.getForObject("http://Movie-Rating-Service-App/users/" + userId, UserRatingResponse.class);
        List<MovieRatingDetails> movieRatings = userRatings.getUserRatingDetails();

        return movieRatings.stream().map(rating -> {
            MovieDetails movieDetails = restTemplate.getForObject("http://Movie-Info-Service-App/movie/info/" + rating.getMovieId(), MovieDetails.class);
            return  new Movie(movieDetails.getName(), "Dark Knight", rating.getMovieRating());
        }).collect(Collectors.toList());
    }

    /****
     * This method uses REST calls with URLs hardcoded. Here we are using Normal Rest Template and Giving actual URL for REST call.
     * @param userId
     * @return
     */
    @RequestMapping("/movie/catalog/{userId}")
    public List<Movie> getMovieCatalog(@PathVariable("userId") String userId) {


        UserRatingResponse userRatings = normalRestTemplate.getForObject("http://localhost:8083/users/" + userId, UserRatingResponse.class);
        List<MovieRatingDetails> movieRatings = userRatings.getUserRatingDetails();

        return movieRatings.stream().map(rating -> {
            MovieDetails movieDetails = normalRestTemplate.getForObject("http://localhost:8082/movie/info/" + rating.getMovieId(), MovieDetails.class);
            return  new Movie(movieDetails.getName(), "Dark Knight", rating.getMovieRating());
        }).collect(Collectors.toList());
    }

}
