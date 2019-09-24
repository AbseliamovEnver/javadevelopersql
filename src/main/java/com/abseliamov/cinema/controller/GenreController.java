package com.abseliamov.cinema.controller;

import com.abseliamov.cinema.service.GenreService;

public class GenreController {
    private GenreService genreService;

    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }
}
