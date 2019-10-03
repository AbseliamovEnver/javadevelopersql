package com.abseliamov.cinema.service;

import com.abseliamov.cinema.dao.ViewerDaoImpl;
import com.abseliamov.cinema.model.GenericModel;
import com.abseliamov.cinema.model.Viewer;
import com.abseliamov.cinema.utils.CurrentViewer;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ViewerService {
    private ViewerDaoImpl viewerDao;
    private CurrentViewer currentViewer;
    private static final String ERROR_NAME_OR_PASSWORD =
            "Please enter correct username and password or enter \'0\' to exit:";

    public ViewerService(ViewerDaoImpl viewerDao, CurrentViewer currentViewer) {
        this.viewerDao = viewerDao;
        this.currentViewer = currentViewer;
    }

    public boolean authorization(String name, String password) {
        boolean checkUser = false;
        Viewer viewer;
        if (name.isEmpty() || password.isEmpty()) {
            System.out.println(ERROR_NAME_OR_PASSWORD);
            return checkUser;
        } else if ((viewer = viewerDao.checkUserAuthorization(name, password)) != null) {
            currentViewer.setViewer(viewer);
            checkUser = true;
        } else {
            System.out.println("User with name \'" + name + "\' and password \'" + password + "\' does not exist.");
            System.out.println(ERROR_NAME_OR_PASSWORD);
        }
        return checkUser;
    }

    public List<Viewer> getAll() {
        List<Viewer> viewerList = viewerDao.getAll();
        printViewer(viewerList);
        return viewerList;
    }

    private void printViewer(List<Viewer> viewerList) {
        if (!viewerList.isEmpty()) {
            System.out.println("\n|----------------------------------------------------------------------------------|");
            System.out.printf("%-35s%-1s\n", " ", "LIST OF VIEWERS");
            System.out.println("|----------------------------------------------------------------------------------|");
            System.out.printf("%-3s%-12s%-23s%-21s%-13s%-1s\n",
                    " ", "ID", "FIRST NAME", "LAST NAME", "ROLE", "BIRTHDAY");
            System.out.println("|-------|---------------------|----------------------|--------------|--------------|");
            viewerList.stream()
                    .sorted(Comparator.comparing(GenericModel::getId))
                    .collect(Collectors.toList())
                    .forEach(System.out::println);
        } else {
            System.out.println("List viewers is empty.");
        }
    }

    public List<Viewer> searchViewerMovieCountByGenre(long genreId) {
        List<Viewer> viewers = viewerDao.searchViewerMovieCountByGenre(genreId);
        printViewerByRequest(viewers);
        return viewers;
    }

    public List<Viewer> searchViewersVisitingMovieInIntervalDaysFromBirthday() {
        List<Viewer> viewers = viewerDao.searchViewersVisitingMovieInIntervalDaysFromBirthday();
        printViewerByRequest(viewers);
        return viewers;
    }

    public List<Viewer> searchViewerByComplexQuery(long genreId, double amount, List<LocalDate> dates) {
        List<Viewer> viewers = viewerDao.searchViewerByComplexQuery(genreId, amount, dates);
        printViewerByRequest(viewers);
        return viewers;
    }

    private void printViewerByRequest(List<Viewer> viewers) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        if (!viewers.isEmpty()) {
            System.out.println("|------------------------------------------------------------|");
            System.out.printf("%-27s%-1s\n", " ", "REQUEST RESULT");
            System.out.println("|------------------------------------------------------------|");
            System.out.printf("%-3s%-10s%-21s%-17s%-1s\n%-1s\n", " ", "ID", "FIRST NAME", "LAST NAME", "BIRTHDAY",
                    "|------|-------------------|--------------------|------------|");
            viewers.forEach(viewer -> System.out.printf("%-3s%-6s%-20s%-21s%-1s\n%-1s\n",
                    " ", viewer.getId(), viewer.getName(), viewer.getLastName(),
                    formatter.format(viewer.getBirthday()),
                    "|------|-------------------|--------------------|------------|"));
        } else {
            System.out.println("At your request viewers not found\n");
        }
    }
}
