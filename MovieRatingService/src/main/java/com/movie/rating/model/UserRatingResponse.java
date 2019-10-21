package com.movie.rating.model;

import java.util.List;

public class UserRatingResponse {

    private List<MovieRatingDetails> userRatingDetails;

    public List<MovieRatingDetails> getUserRatingDetails() {
        return userRatingDetails;
    }

    public void setUserRatingDetails(List<MovieRatingDetails> userRatingDetails) {
        this.userRatingDetails = userRatingDetails;
    }
}
