package com.abseliamov.cinema.controller;

import com.abseliamov.cinema.model.Movie;
import com.abseliamov.cinema.service.MovieService;

public class MovieController {
    private MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    public void getMovieByMaxCost(){
        movieService.getMovieByMaxCost();
    }

    public boolean increaseCostMovie(double ticketCost, Movie movie) {
        return movieService.increaseCostMovie(ticketCost, movie);
    }

    public boolean reduceCostMovie(double ticketCost, Movie movie) {
        return movieService.reduceCostMovie(ticketCost, movie);
    }
}
