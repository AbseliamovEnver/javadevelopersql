package com.abseliamov.cinema.service;

import com.abseliamov.cinema.dao.MovieDaoImpl;
import com.abseliamov.cinema.model.Movie;

import java.util.List;

public class MovieService {
    private MovieDaoImpl movieDao;

    public MovieService(MovieDaoImpl movieDao) {
        this.movieDao = movieDao;
    }

    public List<Movie> getMovieByMaxCost(){
        List<Movie> movies = movieDao.requestMovie();
        printMovie(movies);
        return movies;
    }

    public boolean increaseCostMovie(double ticketCost, Movie movie) {
        long movieId = movie.getId();
        Movie newMovie = new Movie(movieId, movie.getName(), movie.getGenre(), movie.getCost() + ticketCost);
        return movieDao.update(movieId, newMovie);
    }

    public boolean reduceCostMovie(double ticketCost, Movie movie) {
        long movieId = movie.getId();
        Movie newMovie = new Movie(movieId, movie.getName(), movie.getGenre(), movie.getCost() - ticketCost);
        return movieDao.update(movieId, newMovie);
    }

    private void printMovie(List<Movie> movies){
        System.out.printf("%-3s%-16s%-19s%-1s\n%-1s\n", " ", "ID", "NAME", "COST",
                "|--------------------------------------------|");
        movies.forEach(System.out::println);
    }
}
