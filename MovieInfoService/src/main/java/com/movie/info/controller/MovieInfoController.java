package com.movie.info.controller;

import com.movie.info.model.MovieDetails;
import com.movie.info.model.MovieSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MovieInfoController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${api.key}")
    private String apiKey;

    @RequestMapping("/movie/info/{movieId}")
    public MovieDetails getMovieInfo(@PathVariable("movieId") int movieId) {

        String movieDBUrl = "https://api.themoviedb.org/3/movie/" + movieId + "?api_key=" + apiKey;

        /* Get real time data from external API for movie details */
        MovieSummary movieSummary = restTemplate.getForObject(movieDBUrl, MovieSummary.class);

        return new MovieDetails(movieId, movieSummary.getTitle(), movieSummary.getOverview());
    }




}
