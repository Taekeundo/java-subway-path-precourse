package subway.controller;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.service.ResultRoute;
import subway.service.SearchRoute;
import subway.view.OutputView;

public class RouteController {

    private final SearchRoute searchRoute = new SearchRoute();

    public void searchShortestDistance(String departName, String destinationName) {
        Station departure = StationRepository.findbyName(departName);
        Station destination = StationRepository.findbyName(destinationName);

        if (!validateStations(departure, destination)) {
            return;
        }

        ResultRoute result = searchRoute.calcShortestDistance(departure, destination);
        OutputView.printResult(result);
    }

    public void searchMinimumTime(String departName, String destinationName) {
        Station departure = StationRepository.findbyName(departName);
        Station destination = StationRepository.findbyName(destinationName);

        if (!validateStations(departure, destination)) {
            return;
        }

        ResultRoute result = searchRoute.calcMinimumTime(departure, destination);
        OutputView.printResult(result);
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