package com.abseliamov.cinema.utils;

import com.abseliamov.cinema.model.Viewer;

public class CurrentViewer {
    private static CurrentViewer currentViewer;
    private Viewer viewer;

    private CurrentViewer() {
    }

    public static CurrentViewer getInstance() {
        if (currentViewer == null) {
            currentViewer = new CurrentViewer();
        }
        return currentViewer;
    }

    public Viewer getViewer() {
        return viewer;
    }

    public void setViewer(Viewer viewer) {
        this.viewer = viewer;
    }
}
