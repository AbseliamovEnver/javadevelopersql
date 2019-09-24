package com.abseliamov.cinema.service;

import com.abseliamov.cinema.dao.MovieDaoImpl;

public class MovieService {
    private MovieDaoImpl movieDao;

    public MovieService(MovieDaoImpl movieDao) {
        this.movieDao = movieDao;
    }
}
