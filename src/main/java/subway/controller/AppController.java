package subway.controller;

import subway.view.InputView;
import subway.view.OutputView;

public class AppController {

    private final InputView inputView;
    private final RouteController routeController;

    public AppController(InputView inputView, RouteController routeController) {
        this.inputView = inputView;
        this.routeController = routeController;
    }

    public void run() {
        while (true) {
            String command = inputView.readMainMenu();

            if (command.equalsIgnoreCase("Q")) {
                OutputView.printProgramEnd();
                break;
            }

            if (command.equals("1")) {
                processRouteSearch();
            }
        }
    }

    private void processRouteSearch() {
        String searchType = inputView.readSearchType();

        if (searchType.equalsIgnoreCase("B")) {
            return;
        }

        String departureStationName = inputView.readDepartureStation();
        String destinationStationName = inputView.readDestinationStation();

        if (searchType.equals("1")) {
            routeController.searchShortestDistance(departureStationName, destinationStationName);
        }

        if (searchType.equals("2")) {
            routeController.searchMinimumTime(departureStationName, destinationStationName);
        }
    }
}