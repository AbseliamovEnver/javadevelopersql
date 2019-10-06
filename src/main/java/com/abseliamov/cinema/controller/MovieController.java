package com.abseliamov.cinema.controller;

import com.abseliamov.cinema.model.Movie;
import com.abseliamov.cinema.service.MovieService;

import java.math.BigDecimal;

public class MovieController {
    private MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    public boolean increaseCostMovie(BigDecimal ticketCost, Movie movie) {
        return movieService.increaseCostMovie(ticketCost, movie);
    }

    public boolean reduceCostMovie(BigDecimal ticketCost, Movie movie) {
        return movieService.reduceCostMovie(ticketCost, movie);
    }

    public void searchMostProfitableMovie(){
        movieService.searchMostProfitableMovie();
    }

    public void searchLeastProfitableMovie() {
        movieService.searchLeastProfitableMovie();
    }
}
