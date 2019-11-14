package com.movie.info.model;


public class MovieDetails {

    private int movieId;
    private String name;
    private String movieDesc;

    public MovieDetails() {

    }

    public MovieDetails(int movieId, String name, String description) {
        this.movieId = movieId;
        this.name = name;
        this.movieDesc = description;
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

    public String getMovieDesc() { return movieDesc; }

    public void setMovieDesc(String movieDesc) { this.movieDesc = movieDesc; }
}
