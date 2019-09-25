package com.abseliamov.cinema.service;

import com.abseliamov.cinema.dao.ViewerDaoImpl;

public class ViewerService {
    private ViewerDaoImpl userDao;
    private static final String ERROR_NAME_OR_PASSWORD =
            "Please enter correct username and password or enter \'0\' to exit:";

    public ViewerService(ViewerDaoImpl userDao) {
        this.userDao = userDao;
    }

    public boolean authorization(String name, String password) {
        boolean checkUser = false;
        if (name.isEmpty() || password.isEmpty()) {
            System.out.println(ERROR_NAME_OR_PASSWORD);
            return checkUser;
        } else if (userDao.checkUserAuthorization(name, password)) {
            checkUser = true;
        } else {
            System.out.println("User with name \'" + name + "\' and password \'" + password + "\' does not exist.");
            System.out.println(ERROR_NAME_OR_PASSWORD);
        }
        return checkUser;
    }
}
