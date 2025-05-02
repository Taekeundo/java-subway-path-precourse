package subway.view;

import java.util.List;
import subway.domain.Station;
import subway.service.ResultRoute;

public class OutputView {

    public static void printMainMenu() {
        System.out.println(Message.MAIN_MENU.text());
    }

    public static void printSearchType() {
        System.out.println(Message.SEARCH_TYPE.text());
    }

    public static void printDeparture() {
        System.out.println(Message.DEPARTURE.text());
    }

    public static void printDestination() {
        System.out.println(Message.DESTINATION.text());
    }

    public static void printError(String message) {
        System.out.println("[ERROR] " + message);
    }

    public static void printResult(ResultRoute result) {
        System.out.println("\n## 조회 결과");
        printPath(result.getStations());
        System.out.println("총 거리: " + result.getTotalDistance() + "km");
        System.out.println("총 시간: " + result.getTotalTime() + "분");
    }

    private static void printPath(List<Station> stations) {
        for (Station station : stations) {
            System.out.println("[역] " + station.getName());
        }
    }
}