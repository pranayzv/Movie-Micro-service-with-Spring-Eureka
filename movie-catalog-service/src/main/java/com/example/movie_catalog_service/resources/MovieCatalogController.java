package com.example.movie_catalog_service.resources;

import com.example.movie_catalog_service.MovieCatalogServiceApplication;
import com.example.movie_catalog_service.model.CatalogItem;
import com.example.movie_catalog_service.model.Movie;
import com.example.movie_catalog_service.model.Rating;
import com.example.movie_catalog_service.model.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {

    @Autowired
    WebClient.Builder builder;

    @Autowired
    RestTemplate restTemplate;
    @RequestMapping("{userId}")
    public List<CatalogItem> getCatalog(@PathVariable String userId){

         Movie movie = builder.build()
                 .get()
                 .uri("http://movie-info-service/movie/1")
                 .retrieve()
                 .bodyToMono(Movie.class)
                 .block();


        List<CatalogItem> catalogItemList = new ArrayList<>();
        UserRating userRating = restTemplate.getForObject("http://ratings-data-service/rating/users/"+userId, UserRating.class);

        for (Rating rating :userRating.getRatingList()) {
            catalogItemList.add(new CatalogItem(movie.getName(), rating.getMovieId(), rating.getRating()));
        }


        return catalogItemList;
    }

}
