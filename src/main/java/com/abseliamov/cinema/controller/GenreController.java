package com.abseliamov.cinema.controller;

import com.abseliamov.cinema.model.Genre;
import com.abseliamov.cinema.service.GenreService;

import java.util.List;

public class GenreController {
    private GenreService genreService;

    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    public List<Genre> getAll(){
        return genreService.getAll();
    }
}
