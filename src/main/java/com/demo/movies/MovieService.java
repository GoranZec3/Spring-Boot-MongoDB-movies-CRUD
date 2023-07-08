package com.demo.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {


    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> allMovies(){
        return movieRepository.findAll();
    }

    public Optional<Movie> singleMovie(String imdbId){
        return movieRepository.findMovieByImdbId(imdbId);
    }

    public void deleteById(ObjectId id){
        movieRepository.deleteById(id);
    }


    //testiranje trenutno ne radi
    //query documents in collections
    public  Optional<Movie> singleReview(String reviewIds){
        return movieRepository.findReviewById(reviewIds);
    }

    public void deleteReviewById(String reviewIds){
        movieRepository.deleteReviewById(reviewIds);
    }


}
