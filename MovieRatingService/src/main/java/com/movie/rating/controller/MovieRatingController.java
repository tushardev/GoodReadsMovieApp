package com.movie.rating.controller;

import com.movie.rating.model.MovieRatingDetails;
import com.movie.rating.model.UserRatingResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class MovieRatingController {

    @RequestMapping("/movie/rating/{movieId}")
    public MovieRatingDetails getMovieRatingDetails(@PathVariable("movieId")  int movieId) {
        MovieRatingDetails ratingDetails = null;

        if(movieId == 1) {
            ratingDetails = new MovieRatingDetails(movieId,8);
        } else if(movieId == 2) {
            ratingDetails = new MovieRatingDetails(movieId,9);
        }

        return ratingDetails;
    }

    @RequestMapping("users/{userId}")
    public UserRatingResponse getUserRatings(@PathVariable("userId") String userId) {

        UserRatingResponse response = new UserRatingResponse();

        List<MovieRatingDetails> ratingDetails = Arrays.asList(
                new MovieRatingDetails(1, 8),
                new MovieRatingDetails(2, 9)
        );

        response.setUserRatingDetails(ratingDetails);
        return response;
    }
}
