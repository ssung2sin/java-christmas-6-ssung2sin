package christmas.controller;

import christmas.view.InputView;
import christmas.view.OutputView;

public class ChristmasController {
    private final InputView inputView;

    public ChristmasController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        inputVisitDate();
    }

    private void inputVisitDate() {
        OutputView.printIntroduction();
        while (true) {
            try {
                int visitDate = inputView.readDate();
                break;
            } catch (IllegalArgumentException error) {
                OutputView.printErrorMessage(error.getMessage());
            }
        }
    }
}
