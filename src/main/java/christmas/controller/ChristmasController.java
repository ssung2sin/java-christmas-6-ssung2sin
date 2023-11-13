package christmas.controller;

import christmas.service.CalculationService;
import christmas.service.DataService;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.List;

public class ChristmasController {
    private final InputView inputView;
    private final DataService dataService;
    private final CalculationService calculationService;

    public ChristmasController(InputView inputView, DataService dataService, CalculationService calculationService) {
        this.inputView = inputView;
        this.dataService = dataService;
        this.calculationService = calculationService;
    }

    public void run() {
        inputVisitDate();
        inputOrderMenus();
        printBenefitContent();
        printOrderMenus();
        printTotalAmountBeforeDiscount();
        printGiftMenu();
    }

    private void inputVisitDate() {
        OutputView.printIntroduction();
        while (true) {
            try {
                int visitDate = inputView.readDate();
                String classificationDate = calculationService.dateCalculation(visitDate);
                dataService.saveReservationDate(visitDate, classificationDate);
                break;
            } catch (IllegalArgumentException error) {
                OutputView.printErrorMessage(error.getMessage());
            }
        }
    }

    private void printBenefitContent() {
        dataService.printBenefitContent();
    }


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

    private void printOrderMenus() {
        OutputView.printSubjectOfOrderMenu();
        dataService.printOrderMenus();
    }

    private void printTotalAmountBeforeDiscount() {
        dataService.printTotalAmountBeforeDiscount();
    }

    private void printGiftMenu() {
        int totalAmount = dataService.getTotalAmount();
        StringBuilder giftMenu = dataService.printGiftMenu(totalAmount);
        OutputView.printGiftMenu(giftMenu);
    }
}
