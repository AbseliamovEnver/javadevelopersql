package com.abseliamov.cinema.controller;

import com.abseliamov.cinema.model.Viewer;
import com.abseliamov.cinema.service.ViewerService;

import java.util.List;

public class ViewerController {
    private ViewerService viewerService;

    public ViewerController(ViewerService viewerService) {
        this.viewerService = viewerService;
    }

    public boolean authorization(String name, String password) {
        return viewerService.authorization(name, password);
    }

    public List<Viewer> getAll() {
        return viewerService.getAll();
    }

    public List<Viewer> searchViewerMovieCountByGenre(long genreId) {
        return viewerService.searchViewerMovieCountByGenre(genreId);
    }

    public List<Viewer> searchViewersVisitingMovieInIntervalDaysFromBirthday() {
        return viewerService.searchViewersVisitingMovieInIntervalDaysFromBirthday();
    }
}
