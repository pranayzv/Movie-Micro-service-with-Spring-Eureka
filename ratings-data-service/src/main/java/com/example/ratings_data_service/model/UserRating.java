package com.example.ratings_data_service.model;

import java.util.List;

public class UserRating {

    List<Rating> ratingList;

    public UserRating(List<Rating> ratingList) {
        this.ratingList = ratingList;
    }

    public List<Rating> getRatingList() {
        return ratingList;
    }

    public void setRatingList(List<Rating> ratingList) {
        this.ratingList = ratingList;
    }
}
