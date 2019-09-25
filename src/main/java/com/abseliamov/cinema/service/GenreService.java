package com.abseliamov.cinema.service;

import com.abseliamov.cinema.dao.GenreDaoImpl;
import com.abseliamov.cinema.model.GenericModel;
import com.abseliamov.cinema.model.Genre;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class GenreService {
    private GenreDaoImpl genreDao;

    public GenreService(GenreDaoImpl genreDao) {
        this.genreDao = genreDao;
    }

    public List<Genre> getAll() {
        List<Genre> genreList = genreDao.getAll();
        if (!genreList.isEmpty()) {
            List<Genre> sortedGenreList = genreList
                    .stream()
                    .sorted(Comparator.comparingLong(GenericModel::getId))
                    .collect(Collectors.toList());
            System.out.println("\n|------------------------|");
            System.out.printf("%-5s%-1s\n", " ", "LIST OF GENRES");
            System.out.println("|------------------------|");
            System.out.printf("%-3s%-9s%-1s\n", " ", "ID", "GENRE");
            System.out.println("|-------|----------------|");
            sortedGenreList.forEach(System.out::println);
        } else {
            System.out.println("Genre list is empty.");
        }
        return genreList;
    }
}
