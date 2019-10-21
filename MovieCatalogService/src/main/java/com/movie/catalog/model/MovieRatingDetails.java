package com.movie.catalog.model;

public class MovieRatingDetails {

    private int movieId;
    private int movieRating;

    public MovieRatingDetails() {
    }

    public MovieRatingDetails(int movieId, int movieRating) {
        this.movieId = movieId;
        this.movieRating = movieRating;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getMovieRating() {
        return movieRating;
    }

    public void setMovieRating(int movieRating) {
        this.movieRating = movieRating;
    }
}
