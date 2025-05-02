package subway.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Line {
    private String name;
    private List<Station> stations = new ArrayList<>();

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addStation(String stationName) {
        stations.add(new Station(stationName));
    }

    public List<Station> getStations() {
        return Collections.unmodifiableList(stations);
    }
}