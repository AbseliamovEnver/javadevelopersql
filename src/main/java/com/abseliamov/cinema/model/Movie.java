package com.abseliamov.cinema.model;

public class Movie extends GenericModel {
    private Genre genre;
    private double cost;

    public Movie(long id, String name, Genre genre, double cost) {
        super(id, name);
        this.genre = genre;
        this.cost = cost;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
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

    @Override
    public String toString() {
        return String.format("%-2s%-8s%-26s%-1s\n%-1s\n", " ", getId(), getName(), getCost(),
                "|-------|-------------------------|----------|");
    }
}
