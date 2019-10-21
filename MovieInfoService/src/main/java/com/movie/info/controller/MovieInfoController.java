package com.movie.info.controller;

import com.movie.info.model.MovieDetails;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieInfoController {

    @RequestMapping("/movie/info/{movieId}")
    public MovieDetails getMovieInfo(@PathVariable("movieId") int movieId) {

        MovieDetails movieDetails = null;

        if(movieId == 1) {
            movieDetails = new MovieDetails(1, "The Dark Knight");
        } else if(movieId == 2) {
            movieDetails = new MovieDetails(2, "Joker");
        }

        return movieDetails;
    }




}
