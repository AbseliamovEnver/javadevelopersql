package com.abseliamov.cinema.service;

import com.abseliamov.cinema.dao.ViewerDaoImpl;
import com.abseliamov.cinema.model.Viewer;
import com.abseliamov.cinema.utils.CurrentViewer;

public class ViewerService {
    private ViewerDaoImpl userDao;
    private CurrentViewer currentViewer;
    private static final String ERROR_NAME_OR_PASSWORD =
            "Please enter correct username and password or enter \'0\' to exit:";

    public ViewerService(ViewerDaoImpl userDao, CurrentViewer currentViewer) {
        this.userDao = userDao;
        this.currentViewer = currentViewer;
    }

    public boolean authorization(String name, String password) {
        boolean checkUser = false;
        Viewer viewer;
        if (name.isEmpty() || password.isEmpty()) {
            System.out.println(ERROR_NAME_OR_PASSWORD);
            return checkUser;
        } else if ((viewer = userDao.checkUserAuthorization(name, password)) != null) {
            currentViewer.setViewer(viewer);
            checkUser = true;
        } else {
            System.out.println("User with name \'" + name + "\' and password \'" + password + "\' does not exist.");
            System.out.println(ERROR_NAME_OR_PASSWORD);
        }
        return checkUser;
    }
}
