package com.abseliamov.cinema.view;

import com.abseliamov.cinema.controller.GenreController;
import com.abseliamov.cinema.controller.TicketController;
import com.abseliamov.cinema.controller.ViewerController;
import com.abseliamov.cinema.utils.IOUtil;

public class ViewerMenu {
    private ViewerController viewerController;
    private TicketController ticketController;
    private GenreController genreController;

    public ViewerMenu(ViewerController viewerController,
                      TicketController ticketController, GenreController genreController) {
        this.viewerController = viewerController;
        this.ticketController = ticketController;
        this.genreController = genreController;
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
        long mainMenuItem = -1;
        long ticketId;
        while (true) {
            if (mainMenuItem == -1) {
                IOUtil.printMenuItem(MenuContent.getMainMenu());
                mainMenuItem = IOUtil.getValidLongInputData("Select MAIN MENU item: ");
            }
            switch ((int) mainMenuItem) {
                case 0:
                    IOUtil.printMenuHeader(MenuContent.getFooterMenu());
                    System.exit(0);
                    break;
                case 1:
                    ticketId = searchMenu();
                    if (ticketId != 0) {
                        mainMenuItem = 2;
                    }
                    break;
                case 2:
                    System.out.println("Buy ticket");
                    mainMenuItem = -1;
                    break;
                case 3:
                    System.out.println("Return ticket");
                    break;
                case 4:
                    System.out.println("Search tickets by viewer");
                    break;
                default:
                    System.out.println("Error. Incorrect menu item.\n*********************************");
                    break;
            }
        }
    }

    private long searchMenu() {
        long searchMenuItem = -1;
        long ticketId;
        while (true) {
            if (searchMenuItem == -1) {
                IOUtil.printMenuItem(MenuContent.getSearchMenu());
                searchMenuItem = IOUtil.getValidLongInputData("Select SEARCH MENU item: ");
            }
            switch ((int) searchMenuItem) {
                case 0:
                    return 0;
                case 1:
                    ticketId = searchTicketByMovieTitle();
                    if (ticketId != 0) {
                        return ticketId;
                    } else {
                        searchMenuItem = -1;
                    }
                    break;
                case 2:
                    System.out.println("Search tickets by genre");
                    ticketId = searchTicketByGenre();
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
                if (viewerController.authorization(name, password)) {
                    return true;
                } else {
                    continue;
                }
            } else {
                return false;
            }
        }
    }

    private long searchTicketByMovieTitle() {
        long ticketId = 0;
        if (ticketController.getTicketByMovieTitle(IOUtil.readString("Enter movie title: "))) {
            ticketId = IOUtil.readNumber("\nEnter ticket ID to buy or enter \'0\' for a new search: ");
        }
        return ticketId;
    }

    private long searchTicketByGenre() {
        long ticketId = 0;
        if (genreController.getAll() != null) {
            long genreId = IOUtil.readNumber("\nEnter ID genre or \'0\' to return: ");
            if (genreId != 0) {
                ticketController.getTicketByGenre(genreId);

            }
        }
        return ticketId;
    }
}
