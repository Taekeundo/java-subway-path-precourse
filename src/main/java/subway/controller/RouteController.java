package subway.controller;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.service.ResultRoute;
import subway.service.SearchRoute;

public class RouteController {

    private final SearchRoute searchRoute = new SearchRoute();

    public void searchShortestDistance(String departName, String destinationName) {
        Station departure = StationRepository.findbyName(departName);
        Station destination = StationRepository.findbyName(destinationName);

        if (departure == null || destination == null) {
            // TODO: View will print out error messgae.
            return;
        }

        ResultRoute result = searchRoute.calcShortestDistance(departure, destination);
        // TODO: View will print out result.
    }

    public void searchMinimumTime(String departName, String destinationName) {
        Station departure = StationRepository.findbyName(departName);
        Station destination = StationRepository.findbyName(destinationName);

        if (departure == null || destination == null) {
            // TODO: View will print out error messgae.
            return;
        }
        ResultRoute result = searchRoute.calcMinimumTime(departure, destination);
        // TODO: View will print out result.
    }
}