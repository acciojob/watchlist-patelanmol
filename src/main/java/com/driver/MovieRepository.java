package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class MovieRepository {
    private final HashMap<String, Movie> movieHashMap;
    private final HashMap<String, Director> directorHashMap;
    private final HashMap<String, List<String>> directorMovieList;

    public MovieRepository(){
        this.movieHashMap = new HashMap<>();
        this.directorHashMap = new HashMap<>();
        this.directorMovieList = new HashMap<>();
    }

    public void addMovie(Movie movie){
        movieHashMap.put(movie.getName(), movie);
    }

    public void addDirector(Director director){
        directorHashMap.put(director.getName(), director);
    }

    public void addMovieDirectorPair(String movieName, String directorName){
        if(movieHashMap.containsKey(movieName) && directorHashMap.containsKey(directorName)){
            List<String>directorMovies = new ArrayList<>();
            if(directorMovieList.containsKey(directorName)){
                directorMovies = directorMovieList.get(directorName);
                directorMovieList.put(directorName, directorMovies);
            }
            else{
                directorMovies.add(movieName);
                directorMovieList.put(directorName, directorMovies);
            }
        }
    }

    public Movie getMovieByName(String movieName){
        return movieHashMap.get(movieName);
    }

    public Director getDirectorByName(String directorName){
        return directorHashMap.get(directorName);
    }

    public List<String> getMoviesByDirectorName(String directorName){
        List<String> directorMovies = new ArrayList<>();
        if(directorMovieList.containsKey(directorName)){
            directorMovies = directorMovieList.get(directorName);
        }
        return directorMovies;
    }

    public List<String> findAllMovies(){
        return new ArrayList<>(movieHashMap.keySet());
    }

    public void deleteDirectorByName(String directorName){
        List<String> directorMovies;
        if(directorMovieList.containsKey(directorName)){
            directorMovies = directorMovieList.get(directorName);
            for(String movieName : directorMovies){
                movieHashMap.remove(movieName);
            }
        }
        directorMovieList.remove(directorName);
        directorHashMap.remove(directorName);
    }

    public void deleteAllDirectors(){
        List<String> directorMovies = new ArrayList<>();
        for(String director : directorMovieList.keySet()){
            directorMovies.addAll(directorMovieList.get(director));
        }

        for(String movie : directorMovies)
            movieHashMap.remove(movie);
    }
}
