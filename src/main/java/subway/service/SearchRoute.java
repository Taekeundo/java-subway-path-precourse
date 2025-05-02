package subway.service;

import java.util.List;
import java.util.ArrayList;
import subway.domain.Station;

public class SearchRoute {

    public ResultRoute calcShortestDistance(Station departureStation, Station destinationStation) {
        // TODO: Implement shortest path calculation logic
        List<Station> path = new ArrayList<>();
        path.add(departureStation);
        path.add(destinationStation);

        int totalDistance = 10;
        int totalTime = 0;

        return new ResultRoute(path, totalDistance, totalTime);
    }

    public ResultRoute calcMinimumTime(Station departureStation, Station destinationStation) {
        // TODO: Implement minimum time calculation logic
        List<Station> path = new ArrayList<>();
        path.add(departureStation);
        path.add(destinationStation);

        int totalDistance = 10; // T.B.D.
        int totalTime = 10;     // T.B.D.

        return new ResultRoute(path, totalDistance, totalTime);
    }
}