package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public void addMovie(Movie movie){
        movieRepository.addMovie(movie);
    }

    public void addDirector(Director director){
        movieRepository.addDirector(director);
    }

    public void addMovieDirectorPair(String movie, String director){
        movieRepository.addMovieDirectorPair(movie, director);
    }

    public Movie getMovie(String movie){
        return movieRepository.getMovieByName(movie);
    }

    public Director getDirector(String director){
        return movieRepository.getDirectorByName(director);
    }

    public List<String> getDirectorMovies(String directorName){
        return movieRepository.getMoviesByDirectorName(directorName);
    }

    public List<String> getAllMovies(){
        return movieRepository.findAllMovies();
    }

    public void deleteDirector (String directorName){
        movieRepository.deleteDirectorByName(directorName);
    }

    public void deleteAllDirectors(){
        movieRepository.deleteAllDirectors();
    }

}
