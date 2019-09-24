package com.abseliamov.cinema.service;

import com.abseliamov.cinema.dao.GenreDaoImpl;

public class GenreService {
    private GenreDaoImpl genreDao;

    public GenreService(GenreDaoImpl genreDao) {
        this.genreDao = genreDao;
    }
}
