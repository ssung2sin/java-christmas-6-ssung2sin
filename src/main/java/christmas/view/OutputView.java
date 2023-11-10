package christmas.view;

import christmas.constant.OutputMessage;

public class OutputView {
    public static void printIntroduction() {
        System.out.println(OutputMessage.FIRST_PRINT_INTRODUCTION.getMessage());
    }

    public static void printErrorMessage(String message) {
        System.out.println(message);
    }
}
