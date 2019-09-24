package com.abseliamov.cinema;

import com.abseliamov.cinema.utils.Injector;
import com.abseliamov.cinema.view.MenuContent;

public class Main {
    public static void main(String[] args) {
        MenuContent.createMenuContent();


        Injector.getViewerMenu().authorizationMenu();
    }
}
