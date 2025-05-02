package subway.config;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class DataInitializer {

    public static void init() {
        initStations();
        initLines();
    }

    private static void initStations() {
        StationRepository.addStation(new Station("교대역"));
        StationRepository.addStation(new Station("강남역"));
        StationRepository.addStation(new Station("역삼역"));
        StationRepository.addStation(new Station("남부터미널"));
        StationRepository.addStation(new Station("양재역"));
        StationRepository.addStation(new Station("매봉역"));
        StationRepository.addStation(new Station("양재시민의숲역"));
    }

    private static void initLines() {
        initLine2();
        initLine3();
        initLineS();
    }

    private static void initLine2() {
        Station 교대역 = StationRepository.findbyName("교대역");
        Station 강남역 = StationRepository.findbyName("강남역");
        Station 역삼역 = StationRepository.findbyName("역삼역");

        Line line2 = new Line("2호선");
        line2.addStation(교대역);
        line2.addStation(강남역);
        line2.addStation(역삼역);
        line2.addSection(교대역, 강남역, 2, 3);
        line2.addSection(강남역, 역삼역, 2, 3);
        LineRepository.addLine(line2);
    }

    private static void initLine3() {
        Station 교대역 = StationRepository.findbyName("교대역");
        Station 남부터미널역 = StationRepository.findbyName("남부터미널역");
        Station 양재역 = StationRepository.findbyName("양재역");
        Station 매봉역 = StationRepository.findbyName("매봉역");

        Line line3 = new Line("3호선");
        line3.addStation(교대역);
        line3.addStation(남부터미널역);
        line3.addStation(양재역);
        line3.addStation(매봉역);
        line3.addSection(교대역, 남부터미널역, 3, 2);
        line3.addSection(남부터미널역, 양재역, 6, 5);
        line3.addSection(양재역, 매봉역, 1, 1);
        LineRepository.addLine(line3);
    }

    private static void initLineS() {
        Station 강남역 = StationRepository.findbyName("강남역");
        Station 양재역 = StationRepository.findbyName("양재역");
        Station 양재시민의숲역 = StationRepository.findbyName("양재시민의숲역");

        Line lineS = new Line("신분당선");
        lineS.addStation(강남역);
        lineS.addStation(양재역);
        lineS.addStation(양재시민의숲역);
        lineS.addSection(강남역, 양재역, 2, 8);
        lineS.addSection(양재역, 양재시민의숲역, 10, 3);
        LineRepository.addLine(lineS);
    }
}