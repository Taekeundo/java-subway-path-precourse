package subway.view;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String readMainMenu() {
        OutputView.printMainMenu();
        OutputView.printSelectOption();
        return scanner.nextLine();
    }

    public String readSearchType() {
        OutputView.printSearchType();
        OutputView.printSelectOption();
        return scanner.nextLine();
    }

    public String readDepartureStation() {
        OutputView.printDeparture();
        return scanner.nextLine();
    }

    public String readDestinationStation() {
        OutputView.printDestination();
        return scanner.nextLine();
    }
}