package christmas.controller;

import christmas.service.DataService;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.List;

public class ChristmasController {
    private final InputView inputView;
    private final DataService dataService;

    public ChristmasController(InputView inputView, DataService dataService) {
        this.inputView = inputView;
        this.dataService = dataService;
    }

    public void run() {
        inputVisitDate();
        /*loadMenu();*/
        inputOrderMenus();
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

    /*private void loadMenu() {
        dataService.loadMenu();
    }*/

    private void inputOrderMenus() {
        List<String[]> menuList;
        while (true) {
            try {
                menuList = inputView.readOrderMenu();
                break;
            } catch (IllegalArgumentException error) {
                OutputView.printErrorMessage(error.getMessage());
            }
        }
        dataService.saveOrderMenus(menuList);
    }
}
