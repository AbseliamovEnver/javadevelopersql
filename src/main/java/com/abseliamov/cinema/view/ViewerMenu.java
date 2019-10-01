package com.abseliamov.cinema.view;

import com.abseliamov.cinema.controller.*;
import com.abseliamov.cinema.model.Role;
import com.abseliamov.cinema.model.Ticket;
import com.abseliamov.cinema.utils.CurrentViewer;
import com.abseliamov.cinema.utils.IOUtil;

import java.util.List;

public class ViewerMenu {
    private CurrentViewer currentViewer;
    private ViewerController viewerController;
    private TicketController ticketController;
    private GenreController genreController;
    private SeatController seatController;
    private SeatTypesController seatTypesController;
    private MovieController movieController;

    public ViewerMenu(CurrentViewer currentViewer, ViewerController viewerController, TicketController ticketController,
                      GenreController genreController, SeatController seatController,
                      SeatTypesController seatTypesController, MovieController movieController) {
        this.currentViewer = currentViewer;
        this.viewerController = viewerController;
        this.ticketController = ticketController;
        this.genreController = genreController;
        this.seatController = seatController;
        this.seatTypesController = seatTypesController;
        this.movieController = movieController;
    }

    public void authorizationMenu() {
        long authorizationMenuItem;
        IOUtil.printMenuItem(MenuContent.getAuthorizationMenu());
        while (true) {
            authorizationMenuItem = IOUtil.getValidLongInputData("Select AUTHORIZATION MENU item: ");
            switch ((int) authorizationMenuItem) {
                case 0:
                    IOUtil.printMenuHeader(MenuContent.getFooterMenu());
                    System.exit(0);
                    break;
                case 1:
                    if (authorization()) {
                        mainMenu();
                    }
                    break;
                default:
                    if (authorizationMenuItem >= MenuContent.getAuthorizationMenu().size() - 1) {
                        System.out.println("Enter correct menu item.");
                    }
                    break;
            }
        }
    }

    public void mainMenu() {
        IOUtil.printMenuHeader(MenuContent.getHeaderMenu());
        long mainMenuItem = -1;
        long ticketId = 0;
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
                    mainMenuItem = ticketId != 0 ? 2 : -1;
                    break;
                case 2:
                    if (ticketId != 0) {
                        buyTicketById(ticketId);
                        ticketId = 0;
                        mainMenuItem = -1;
                    } else {
                        if (!buyTicket()) {
                            mainMenuItem = 1;
                        }
                    }
                    break;
                case 3:
                    mainMenuItem = returnTicket() ? 3 : -1;
                    break;
                case 4:
                    mainMenuItem = searchTicketByViewer() ? 4 : -1;
                    break;
                case 5:
                    movieController.getMovieByMaxCost();
                    mainMenuItem = -1;
                    break;
                default:
                    if (mainMenuItem >= MenuContent.getMainMenu().size() - 1) {
                        mainMenuItem = -1;
                        System.out.println("Enter correct main menu item.\n*********************************");
                    }
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
                    ticketId = searchTicketByGenre();
                    if (ticketId != 0) {
                        return ticketId;
                    } else {
                        searchMenuItem = -1;
                    }
                    break;
                case 3:
                    ticketId = searchTicketByDate();
                    if (ticketId != 0) {
                        return ticketId;
                    } else {
                        searchMenuItem = -1;
                    }
                    break;
                case 4:
                    ticketId = searchTicketByTypeSeat();
                    if (ticketId != 0) {
                        return ticketId;
                    } else {
                        searchMenuItem = -1;
                    }
                    break;
                default:
                    if (searchMenuItem >= MenuContent.getSearchMenu().size() - 1) {
                        searchMenuItem = -1;
                        System.out.println("Enter correct search menu item.\n*********************************");
                    }
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
                }
            } else {
                return false;
            }
        }
    }

    private long searchTicketByMovieTitle() {
        long ticketId;
        String movieTitle = IOUtil.readString("Enter movie title: ");
        List<Ticket> ticketList = ticketController.getTicketByMovieTitle(movieTitle);
        ticketId = checkTicketAvailable(ticketList);
        return ticketId;
    }

    private long searchTicketByGenre() {
        long ticketId = 0;
        long genreListSize;
        List<Ticket> ticketList;
        if ((genreListSize = genreController.getAll().size()) != 0) {
            long genreId = IOUtil.readNumber("\nEnter ID genre or \'0\' to return: ");
            if (genreId != 0 && genreId <= genreListSize) {
                ticketList = ticketController.getTicketByGenre(genreId);
                ticketId = checkTicketAvailable(ticketList);
            } else {
                System.out.println("Genre with id \'" + genreId + "\' not available.\n" +
                        "Please try again.");
            }
        }
        return ticketId;
    }

    private long searchTicketByDate() {
        long ticketId = 0;
        List<Ticket> ticketList;
        if (ticketController.getAllDate() != null) {
            long dateId = IOUtil.readNumber("\nEnter ID date or \'0\' to return: ");
            if (dateId != 0) {
                ticketList = ticketController.getAllTicketByDate(dateId);
                ticketId = checkTicketAvailable(ticketList);
            }
        }
        return ticketId;
    }

    private long searchTicketByTypeSeat() {
        long ticketId = 0;
        long seatTypeListSize;
        List<Ticket> ticketList;
        if ((seatTypeListSize = seatTypesController.getAllSeatType().size()) != 0) {
            long seatTypeId = IOUtil.readNumber("\nEnter ID seat type or \'0\' to return: ");
            if (seatTypeId != 0 && seatTypeId <= seatTypeListSize) {
                ticketList = ticketController.getTicketBySeatType(seatTypeId);
                ticketId = checkTicketAvailable(ticketList);
            } else {
                System.out.println("Seat type with id \'" + seatTypeId + "\' not available.\n" +
                        "Please try again.");
            }
        }
        return ticketId;
    }

    private boolean buyTicketById(long ticketId) {
        boolean buyExist = false;
        Ticket ticket;
        if (ticketId != 0 && (ticket = ticketController.getById(ticketId)) != null) {
            long ticketConfirm = IOUtil.readNumber("\nEnter the ticket ID to confirm the purchase or \'0\' to return: ");
            if (ticketConfirm == 0){
                return buyExist;
            }else if (ticketId == ticketConfirm) {
                if (ticketController.buyTicket(ticketId) && movieController.increaseCostMovie(ticket.getPrice(),
                        ticket.getMovie())) {
                    System.out.println("Thanks for your purchase\n");
                    buyExist = true;
                } else {
                    System.out.println("Purchase failed. Please try again.\n");
                }
            } else {
                System.out.println("The entered \'" + ticketConfirm + "\' does not match the available ticket.");
                System.out.println("Please try again.");
            }
        } else {
            System.out.println("Ticket with id \'" + ticketId + "\' not found.");
        }
        return buyExist;
    }

    private boolean buyTicket() {
        boolean buyExist = false;
        long ticketId = IOUtil.readNumber("\nPlease enter the ticket ID or \'0\' to go to the search: ");
        if (ticketId != 0) {
            buyExist = buyTicketById(ticketId);
        }
        return buyExist;
    }

    private boolean returnTicket() {
        boolean returnExist = false;
        Ticket ticket;
        if (!ticketController.getAllTicketViewer().isEmpty()) {
            long ticketId = IOUtil.readNumber("\nEnter the ticket ID to return or \'0\' to return menu: ");
            if (ticketId != 0 && (ticket = ticketController.getOrderedTicketById(ticketId)) != null) {
                long ticketConfirm = IOUtil.readNumber("\nEnter ticket ID to confirm return the ticket or \'0\' to return: ");
                if (ticketId == ticketConfirm && ticketController.returnTicket(ticketId)
                        && movieController.reduceCostMovie(ticket.getPrice(), ticket.getMovie())) {
                    returnExist = true;
                    System.out.println("Ticket returned.");
                }
            }
        } else {
            System.out.println("List of tickets ordered is empty.");
        }
        return returnExist;
    }

    private boolean searchTicketByViewer() {
        boolean ticketExist = false;
        if (currentViewer.getViewer().getRole() == Role.ADMIN) {
            viewerController.getAll();
            long viewerId = IOUtil.readNumber("\nEnter viewer ID or \'0\' to return menu: ");
            if (viewerId != 0) {
                ticketController.getAllTicketByViewerId(viewerId);
                ticketExist = true;
            }
        } else {
            System.out.println("Not enough rights for this menu.");
        }
        return ticketExist;
    }

    private long checkTicketAvailable(List<Ticket> ticketList) {
        long ticketId = 0;
        if (ticketList != null) {
            ticketId = IOUtil.readNumber("\nEnter ticket ID to buy or enter \'0\' for a new search: ");
            if (ticketId == 0) {
                return ticketId;
            } else {
                ticketId = ticketController.checkTicketAvailable(ticketId) ? ticketId : 0;
                if (ticketId != 0 && confirmTicketId(ticketList, ticketId)) {
                    return ticketId;
                } else if (ticketId != 0) {
                    System.out.println("Ticket id \'" + ticketId + "\' not confirmed.\n");
                    ticketId = 0;
                }
            }
        } else {
            System.out.println("Ticket list is empty.");
        }
        return ticketId;
    }

    private boolean confirmTicketId(List<Ticket> ticketList, long ticketId) {
        return ticketList.stream()
                .anyMatch(ticket -> ticket.getId() == ticketId);
    }
}
