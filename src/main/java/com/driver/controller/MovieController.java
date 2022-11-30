package com.driver.controller;

import com.driver.models.Director;
import com.driver.models.Movie;
import com.driver.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("movies")
public class MovieController {
    @Autowired
    MovieService movieService;

    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie){
        movieService.addMovie(movie);

        return new ResponseEntity<>("Added Movie", HttpStatus.CREATED);
    }

    @PostMapping("/add-director")
    public ResponseEntity<String> addMovie(@RequestBody Director director){
        movieService.addDirector(director);

        return new ResponseEntity<>("Added Director", HttpStatus.CREATED);
    }

    @PutMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam String movie, @RequestParam String director){
        movieService.addMovieDirectorPair(movie, director);

        return new ResponseEntity<>("Added Pair", HttpStatus.CREATED);
    }

    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable String name){
        Movie movie = movieService.getMovie(name);

        return new ResponseEntity<>(movie, HttpStatus.CREATED);
    }

    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable String name){
        Director director = movieService.getDirector(name);

        return new ResponseEntity<>(director, HttpStatus.CREATED);
    }

    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity<ArrayList<String>> getMovie(@PathVariable String director){
        ArrayList<String>movies = movieService.getDirectorMovies(director);

        return new ResponseEntity<>(movies, HttpStatus.CREATED);
    }

    @GetMapping("get-all-Movies")
    public ResponseEntity<ArrayList<String>> findAllMovies(){
        ArrayList<String>movies = movieService.getAllMovies();
        return new ResponseEntity<>(movies, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam String director){
        movieService.deleteDirector(director);

        return new ResponseEntity<>("Removed Director", HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){
        movieService.deleteAllDirectors();
        return new ResponseEntity<>("Deleted all Directors", HttpStatus.CREATED);
    }

}
