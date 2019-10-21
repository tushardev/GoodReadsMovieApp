package com.movie.catalog.controller;

import com.movie.catalog.model.Movie;
import com.movie.catalog.model.MovieDetails;
import com.movie.catalog.model.MovieRatingDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class MovieCatalogWebClientController {

    @Autowired
    private WebClient.Builder builder;

    @RequestMapping("/movie/catalog/webclient/{userId}")
    public List<Movie> getMovieCatalog(@PathVariable("userId") String userId) {

        /* Hard coded the response from Movie Rating Service */
        List<MovieRatingDetails> movieRatings = Arrays.asList(
                new MovieRatingDetails(1, 8),
                new MovieRatingDetails(2, 6)
        );

        return movieRatings.stream().map(rating -> {
             MovieDetails movieDetails = builder.build()
                    .get()
                    .uri("http://localhost:8082/movie/info/" + rating.getMovieId())
                    .retrieve()
                    .bodyToMono(MovieDetails.class)
                    .block();
            return  new Movie(movieDetails.getName(), "Dark Knight", rating.getMovieRating());
        }).collect(Collectors.toList());
    }
}

/*****
 * This class introduces Web Client to make REST call. Web Client is part of reactive programming and used for async
 * execution.
 *
 * Above example - we have used block to get the actual response and we will be waiting for it.
 * But practically when you will be using WebClient you have to program asynchronously.
 *
*/