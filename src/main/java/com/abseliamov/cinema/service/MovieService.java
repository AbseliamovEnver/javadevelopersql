package com.abseliamov.cinema.service;

import com.abseliamov.cinema.dao.MovieDaoImpl;
import com.abseliamov.cinema.model.Movie;

import java.util.List;

public class MovieService {
    private MovieDaoImpl movieDao;

    public MovieService(MovieDaoImpl movieDao) {
        this.movieDao = movieDao;
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

    public List<Movie> searchMostProfitableMovie() {
        List<Movie> movies = movieDao.searchMostProfitableMovie();
        printMovieByRequest(movies);
        return movies;
    }

    public List<Movie> searchLeastProfitableMovie() {
        List<Movie> movies = movieDao.searchLeastProfitableMovie();
        printMovieByRequest(movies);
        return movies;
    }

    private void printMovieByRequest(List<Movie> movies) {
        if (movies.size() != 0) {
            System.out.println("|-------------------------------------------------|");
            System.out.printf("%-19s%-1s\n", " ", "REQUEST RESULT");
            System.out.println("|-------------------------------------------------|");
            System.out.printf("%-3s%-13s%-23s%-1s\n%-1s\n", " ", "ID", "MOVIE TITLE", "TOTAL COST",
                    "|------|-----------------------------|------------|");
            movies.forEach(movie -> System.out.printf("%-3s%-6s%-32s%-1s\n%-1s\n",
                    " ", movie.getId(), movie.getName(), movie.getCost(),
                    "|------|-----------------------------|------------|"));
        }else {
            System.out.println("At your request a movie is not found");
        }
    }
}
