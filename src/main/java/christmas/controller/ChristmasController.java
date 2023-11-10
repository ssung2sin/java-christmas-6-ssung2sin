package christmas.controller;

import christmas.service.DataService;
import christmas.view.InputView;
import christmas.view.OutputView;

public class ChristmasController {
    private final InputView inputView;
    private final DataService dataService;

    public ChristmasController(InputView inputView, DataService dataService) {
        this.inputView = inputView;
        this.dataService = dataService;
    }

    public void run() {
        inputVisitDate();
    }

    private void inputVisitDate() {
        OutputView.printIntroduction();
        while (true) {
            try {
                int visitDate = inputView.readDate();
                dataService.saveReservationDate(visitDate);
                break;
            } catch (IllegalArgumentException error) {
                OutputView.printErrorMessage(error.getMessage());
            }
        }
    }
}
