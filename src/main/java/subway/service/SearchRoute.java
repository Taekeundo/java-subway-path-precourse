package subway.service;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;

import java.util.ArrayList;
import java.util.List;

public class SearchRoute {

    public ResultRoute calcShortestDistance(Station departureStation, Station destinationStation) {
        Graph<Station, DefaultWeightedEdge> graph = createGraphByDistance();
        return calculateRoute(graph, departureStation, destinationStation);
    }

    public ResultRoute calcMinimumTime(Station departureStation, Station destinationStation) {
        Graph<Station, DefaultWeightedEdge> graph = createGraphByTime();
        return calculateRoute(graph, departureStation, destinationStation);
    }

    private ResultRoute calculateRoute(Graph<Station, DefaultWeightedEdge> graph, Station departure, Station destination) {
        DijkstraShortestPath<Station, DefaultWeightedEdge> dijkstra = new DijkstraShortestPath<>(graph);

        if (dijkstra.getPath(departure, destination) == null) {
            return new ResultRoute(new ArrayList<>(), 0, 0); // 경로가 없을 경우
        }

        List<Station> path = dijkstra.getPath(departure, destination).getVertexList();
        int totalValue = (int) dijkstra.getPath(departure, destination).getWeight();

        if (graph.equals(createGraphByDistance())) {
            return new ResultRoute(path, totalValue, 0);
        }
        return new ResultRoute(path, 0, totalValue);
    }

    private Graph<Station, DefaultWeightedEdge> createGraphByDistance() {
        Graph<Station, DefaultWeightedEdge> graph = new WeightedMultigraph<>(DefaultWeightedEdge.class);

        for (Line line : LineRepository.lines()) {
            List<Station> stations = line.getStations();

            for (int i = 0; i < stations.size() - 1; i++) {
                Station from = stations.get(i);
                Station to = stations.get(i + 1);

                graph.addVertex(from);
                graph.addVertex(to);

                DefaultWeightedEdge edge = graph.addEdge(from, to);
                graph.setEdgeWeight(edge, 10);
            }
        }
        return graph;
    }

    private Graph<Station, DefaultWeightedEdge> createGraphByTime() {
        Graph<Station, DefaultWeightedEdge> graph = new WeightedMultigraph<>(DefaultWeightedEdge.class);

        for (Line line : LineRepository.lines()) {
            List<Station> stations = line.getStations();

            for (int i = 0; i < stations.size() - 1; i++) {
                Station from = stations.get(i);
                Station to = stations.get(i + 1);

                graph.addVertex(from);
                graph.addVertex(to);

                DefaultWeightedEdge edge = graph.addEdge(from, to);
                graph.setEdgeWeight(edge, 5);
            }
        }
        return graph;
    }
}