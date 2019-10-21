package com.movie.catalog.model;

public class Movie {

    private String movieName;
    private String description;
    private int rating;

    public Movie(String movieName, String description, int rating) {
        this.movieName = movieName;
        this.description = description;
        this.rating = rating;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
