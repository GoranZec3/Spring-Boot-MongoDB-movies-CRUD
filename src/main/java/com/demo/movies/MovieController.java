package com.demo.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies(){
        return new ResponseEntity<List<Movie>>(movieService.allMovies(), HttpStatus.OK);
    }

    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable String imdbId){
        return new ResponseEntity<Optional<Movie>>(movieService.singleMovie(imdbId), HttpStatus.OK);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String>deleteById(@PathVariable ObjectId id){
        movieService.deleteById(id);
        return new ResponseEntity<String>("object is deleted", HttpStatus.OK);
    }

    //testiranje trenutno ne radi

    @GetMapping("/review/{reviewIds}")
    public ResponseEntity<Optional<Movie>> getSingleReview(@PathVariable String reviewIds){
        return new ResponseEntity<>(movieService.singleReview(reviewIds), HttpStatus.OK);
    }


    @DeleteMapping("delete/review/{reviewIds}")
    public ResponseEntity<String> deleteReview(@PathVariable String reviewIds){
        movieService.deleteReviewById(reviewIds);
        return new ResponseEntity<>("Review is deleted", HttpStatus.OK);
    }



}
