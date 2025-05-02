package subway.service;

import java.util.List;
import subway.domain.Station;

public class ResultRoute {
    private List<Station> stations;
    private int totalDistance;
    private int totalTime;

    public ResultRoute(List<Station> stations, int totalDistance, int totalTime) {
        this.stations = stations;
        this.totalDistance = totalDistance;
        this.totalTime = totalTime;
    }

    public List<Station> getStations() {
        return stations;
    }

    public int getTotalDistance() {
        return totalDistance;
    }

    public int getTotalTime() {
        return totalTime;
    }
}