package com.abseliamov.cinema.view;

import com.abseliamov.cinema.controller.TicketController;
import com.abseliamov.cinema.controller.UserController;
import com.abseliamov.cinema.utils.IOUtil;

public class ViewerMenu {
    private UserController userController;
    private TicketController ticketController;

    public ViewerMenu(UserController userController, TicketController ticketController) {
        this.userController = userController;
        this.ticketController = ticketController;
    }

    public void authorizationMenu() {
        long authorizationMenuItem;
        IOUtil.printMenuItem(MenuContent.getAuthorizationMenu());
        authorizationMenuItem = IOUtil.getValidLongInputData("Select AUTHORIZATION MENU item: ");
        while (true) {
            switch ((int) authorizationMenuItem) {
                case 0:
                    IOUtil.printMenuHeader(MenuContent.getFooterMenu());
                    System.exit(0);
                    break;
                case 1:
                    if (authorization()) {
                        mainMenu();
                    } else {
                        authorizationMenuItem = 0;
                    }
                    break;
            }
        }
    }

    public void mainMenu() {
        IOUtil.printMenuHeader(MenuContent.getHeaderMenu());
        long mainMenuItem;
        while (true) {
            IOUtil.printMenuItem(MenuContent.getMainMenu());
            mainMenuItem = IOUtil.getValidLongInputData("Select MAIN MENU item: ");

            switch ((int) mainMenuItem) {
                case 0:
                    IOUtil.printMenuHeader(MenuContent.getFooterMenu());
                    System.exit(0);
                    break;
                case 1:
                    searchMenu();
                    break;
                case 2:
                    System.out.println("Case 2");
                    break;
                case 3:
                    System.out.println("Case 3");
                    break;
                case 4:
                    System.out.println("Case 4");
                    break;
                default:
                    System.out.println("Error. Incorrect menu item.\n*********************************");
                    break;
            }
        }
    }

    private void searchMenu() {
        long searchMenuItem;
        while (true) {
            IOUtil.printMenuItem(MenuContent.getSearchMenu());
            searchMenuItem = IOUtil.getValidLongInputData("Select SEARCH MENU item: ");

            switch ((int) searchMenuItem) {
                case 0:
                    return;
                case 1:
                    searchTicketByMovieTitle();
                    break;
                case 2:
                    System.out.println("Search tickets by genre");
                    break;
                case 3:
                    System.out.println("Search tickets by date");
                    break;
                case 4:
                    System.out.println("Search tickets by seat type");
                    break;
                default:
                    System.out.println("Error. Incorrect menu item.\n*********************************");
                    break;
            }
        }
    }

    private boolean authorization() {
        while (true) {
            String name = IOUtil.readString("Enter name: ");
            if (!name.equals("0")) {
                String password = IOUtil.readString("Enter password: ");
                if (userController.authorization(name, password)) {
                    return true;
                } else {
                    continue;
                }
            } else {
                return false;
            }
        }
    }

    private void searchTicketByMovieTitle() {
        ticketController.getTicketByMovieTitle(IOUtil.readString("Enter movie title: "));
    }
}
