package com.abseliamov.cinema.controller;

import com.abseliamov.cinema.service.UserService;

public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public boolean authorization(String name, String password) {
        return userService.authorization(name, password);
    }
}
