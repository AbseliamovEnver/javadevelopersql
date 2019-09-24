package com.abseliamov.cinema.model;

public class Movie extends GenericModel {
    private Genre genre;

    public Movie(long id, String name, Genre genre) {
        this.genre = genre;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;

        return genre != null ? genre.equals(movie.genre) : movie.genre == null;

    }

    @Override
    public int hashCode() {
        return genre != null ? genre.hashCode() : 0;
    }
}
