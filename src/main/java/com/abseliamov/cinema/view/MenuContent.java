package com.abseliamov.cinema.view;

import java.util.ArrayList;
import java.util.List;

public class MenuContent {
    private static List<String> headerMenu = new ArrayList<>();
    private static List<String> authorizationMenu  = new ArrayList<>();
    private static List<String> mainMenu = new ArrayList<>();
    private static List<String> searchMenu = new ArrayList<>();
    private static List<String> footerMenu = new ArrayList<>();

    private MenuContent() {
    }

    public static void createMenuContent() {
        headerMenu.add("*********************************");
        headerMenu.add("   ** WELCOME TO THE CINEMA **");
        headerMenu.add("*********************************");

        authorizationMenu.add("AUTHORIZATION MENU");
        authorizationMenu.add("Log in");
        authorizationMenu.add("Exit");

        mainMenu.add("MAIN MENU");
        mainMenu.add("Search ticket");
        mainMenu.add("Buy ticket");
        mainMenu.add("Return ticket");
        mainMenu.add("Search tickets by viewer");
        mainMenu.add("Test request");
        mainMenu.add("Exit");

        searchMenu.add("SEARCH MENU");
        searchMenu.add("Search tickets by movie title");
        searchMenu.add("Search tickets by genre");
        searchMenu.add("Search tickets by date");
        searchMenu.add("Search tickets by seat type");
        searchMenu.add("Exit");

        footerMenu.add("**************************************");
        footerMenu.add("-= THANK FOR USING OUR APPLICATION! =-");
        footerMenu.add("****-= ENJOY WATCHING THE MOVIE =-****");
    }

    public static List<String> getHeaderMenu() {
        return headerMenu;
    }

    public static List<String> getAuthorizationMenu() {
        return authorizationMenu;
    }

    public static List<String> getMainMenu() {
        return mainMenu;
    }

    public static List<String> getSearchMenu() {
        return searchMenu;
    }

    public static List<String> getFooterMenu() {
        return footerMenu;
    }
}
