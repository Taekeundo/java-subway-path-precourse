package subway.controller;

import subway.domain.Station;
import subway.domain.StationRepository;
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
        while (true) {
            String searchType = inputView.readSearchType();

            if (searchType.equalsIgnoreCase("B")) {
                return;
            }

            String departureStationName = inputView.readDepartureStation();
            String destinationStationName = inputView.readDestinationStation();

            Station departure = StationRepository.findbyName(departureStationName);
            Station destination = StationRepository.findbyName(destinationStationName);

            if (!validateStations(departure, destination)) {
                continue;
            }

            if (searchType.equals("1")) {
                routeController.searchShortestDistance(departureStationName, destinationStationName);
            }

            if (searchType.equals("2")) {
                routeController.searchMinimumTime(departureStationName, destinationStationName);
            }

            break;
        }
    }

    private boolean validateStations(Station departure, Station destination) {
        if (departure == null || destination == null) {
            OutputView.printError("존재하지 않는 역입니다.");
            return false;
        }

        if (departure.equals(destination)) {
            OutputView.printError("출발역과 도착역이 동일합니다.");
            return false;
        }

        return true;
    }
}