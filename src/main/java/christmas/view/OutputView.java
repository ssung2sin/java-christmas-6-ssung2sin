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

    public static void printTotalAmountBeforeDiscount(String totalAmount) {
        System.out.println();
        System.out.println(OutputMessage.PRINT_TOTAL_AMOUNT_BEFORE_DISCOUNT.getMessage());
        System.out.println(totalAmount + OutputMessage.WON.getMessage());
        System.out.println();
    }

    public static void printGiftMenu(StringBuilder giftMenu) {
        System.out.println(OutputMessage.PRINT_GIFT_MENU.getMessage());
        System.out.println(giftMenu);
        System.out.println();
    }

    public static void printSubjectOfBenefit() {
        System.out.println(OutputMessage.PRINT_BENEFITS.getMessage());
    }

    public static void printD_DayDiscount(String discountAmount) {
        System.out.printf(OutputMessage.OUTPUT_D_DAY_DISCOUNT.getMessage(), discountAmount);
    }

}
