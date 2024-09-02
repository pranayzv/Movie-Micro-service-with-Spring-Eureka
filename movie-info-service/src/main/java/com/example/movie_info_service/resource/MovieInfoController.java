package com.example.movie_info_service.resource;

import com.example.movie_info_service.model.Movie;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
public class MovieInfoController {

    @RequestMapping("{movieId}")
    public Movie getMovie(@PathVariable String movieId) {
        return new Movie("1", "The Zone of interest");
    }
}
