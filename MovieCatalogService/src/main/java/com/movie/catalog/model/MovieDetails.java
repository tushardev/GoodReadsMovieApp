package com.movie.catalog.model;


public class MovieDetails {

    private int movieId;
    private String name;

    public MovieDetails() {

    }

    public MovieDetails(int movieId, String name) {
        this.movieId = movieId;
        this.name = name;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
