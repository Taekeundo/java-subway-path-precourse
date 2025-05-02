package subway;

import subway.view.InputView;
import subway.controller.AppController;
import subway.controller.RouteController;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        InputView inputView = new InputView(scanner);
        RouteController routeController = new RouteController();
        AppController appController = new AppController(inputView, routeController);

        appController.run();
    }
}
