package subway.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Line {
    private String name;
    private List<Station> stations = new ArrayList<>();
    private List<Section> sections = new ArrayList<>();

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Section> getSections() {
        return Collections.unmodifiableList(sections);
    }

    public void addStation(Station stationName) {
        stations.add(stationName);
    }

    public List<Station> getStations() {
        return Collections.unmodifiableList(stations);
    }

    public void addSection(Station from, Station to, int distance, int time) {
        sections.add(new Section(from, to, distance, time));
    }
}