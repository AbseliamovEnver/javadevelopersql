package com.abseliamov.cinema.controller;

import com.abseliamov.cinema.service.MovieService;

public class MovieController {
    private MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }
}
