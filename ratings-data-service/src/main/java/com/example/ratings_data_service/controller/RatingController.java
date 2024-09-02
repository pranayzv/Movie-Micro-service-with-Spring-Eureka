package com.example.ratings_data_service.controller;

import com.example.ratings_data_service.model.Rating;
import com.example.ratings_data_service.model.UserRating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingController {

    @RequestMapping("{movieId}")
    public Rating getRating(@PathVariable String movieId) {
        System.out.println(movieId);
        return new Rating("1", 4);
    }

    @RequestMapping("users/{userId}")
    public UserRating getUserRatings(@PathVariable String userId) {
        List<Rating> ratingList = Arrays.asList(
                new Rating("1", 4),
                new Rating("2", 5),
                new Rating("3", 1)
        );
        UserRating userRating = new UserRating(ratingList);
        return userRating;
    }

}
