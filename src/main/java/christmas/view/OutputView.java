package christmas.view;

import christmas.constant.OutputMessage;

public class OutputView {
    public static void printIntroduction() {
        System.out.println(OutputMessage.FIRST_PRINT_INTRODUCTION.getMessage());
    }

    public static void printErrorMessage(String message) {
        System.out.println(message);
    }

    public static void printInputOrderMenus() {
        System.out.println(OutputMessage.ENTER_MENU_TO_ORDER.getMessage());
    }
}
