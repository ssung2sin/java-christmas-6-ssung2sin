package christmas.view;

import christmas.constant.OutputMessage;

public class OutputView {
    public static void printIntroduction() {
        System.out.println(OutputMessage.FIRST_PRINT_INTRODUCTION.getMessage());
    }

    public static void printErrorMessage(String message) {
        System.out.println(message);
    }

    public static void printBenefitContent(int date) {
        System.out.printf(OutputMessage.PRINT_BENEFIT_CONTENT.getMessage(), date);
    }

    public static void printSubjectOfOrderMenu() {
        System.out.println(OutputMessage.PRINT_ORDER_MENU.getMessage());
    }

    public static void outputOrderMenus(String menuName, int menuCount) {
        System.out.printf(OutputMessage.OUTPUT_ORDER_MENU.getMessage(), menuName, menuCount);
    }
}
