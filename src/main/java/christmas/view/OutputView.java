package christmas.view;

import christmas.constant.Constant;
import christmas.constant.Number;
import christmas.constant.OutputMessage;
import christmas.service.DataService;

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

    public static void printBenefitOfChristmasDDay(String discountAmount) {
        System.out.printf(OutputMessage.OUTPUT_D_DAY_DISCOUNT.getMessage(), discountAmount);
    }

    public static void printBenefits(int[] discountValues) {
        int discountAmount = discountValues[Number.DISCOUNT_NUMBER.getNumber()];
        String formattingDiscountAmount = DataService.numberFormatting(discountAmount);
        if (discountValues[Number.CATEGORY_NAME_NUMBER.getNumber()] == Constant.WEEKDAY.getNameCode()) {
            System.out.printf(OutputMessage.OUTPUT_DISCOUNT.getMessage()
                    , Constant.WEEKDAY.getName(), formattingDiscountAmount);
        }
        if (discountValues[Number.CATEGORY_NAME_NUMBER.getNumber()] == Constant.WEEKEND.getNameCode()) {
            System.out.printf(OutputMessage.OUTPUT_DISCOUNT.getMessage()
                    , Constant.WEEKEND.getName(), formattingDiscountAmount);
        }
        if (discountValues[Number.CATEGORY_NAME_NUMBER.getNumber()] == Constant.SPECIAL.getNameCode()) {
            System.out.printf(OutputMessage.OUTPUT_DISCOUNT.getMessage()
                    , Constant.WEEKDAY.getName(), formattingDiscountAmount);
            int discountChristmasAmount = discountValues[Number.DISCOUNT_CHRISTMAS_NUMBER.getNumber()];
            String formattingDiscountChristmasAmount = DataService.numberFormatting(discountChristmasAmount);
            System.out.printf(OutputMessage.OUTPUT_DISCOUNT.getMessage()
                    , Constant.SPECIAL.getName(), formattingDiscountChristmasAmount);
        }
        System.out.println();
    }

    public static void printAllBenefitAmount(int totalDiscountAmount, boolean checkDiscount) {
        String formattingTotalDiscountAmount = DataService.numberFormatting(totalDiscountAmount);
        System.out.println(OutputMessage.PRINT_TOTAL_BENEFITS_AMOUNT.getMessage());
        if (checkDiscount) {
            System.out.println(formattingTotalDiscountAmount + OutputMessage.WON.getMessage());
        }
        if (!checkDiscount) {
            System.out.println(OutputMessage.NOTHING.getMessage());
        }
        System.out.println();
    }

    public static void printEstimatedAmount(int totalAmount, int totalDiscount, boolean checkDiscount) {
        String formattingAmount = DataService.numberFormatting(totalAmount - totalDiscount);
        System.out.println(OutputMessage.PRINT_ESTIMATED_AMOUNT.getMessage());
        if (checkDiscount) {
            System.out.println(formattingAmount + OutputMessage.WON.getMessage());
        }
        if (!checkDiscount) {
            System.out.println(OutputMessage.NOTHING.getMessage());
        }
        System.out.println();
    }

    public static void printNothingBenefits() {
        System.out.println(OutputMessage.NOTHING.getMessage());
        System.out.println();
    }

    public static void printSubjectOfEventBadge() {
        System.out.println(OutputMessage.PRINT_EVENT_BADGE.getMessage());
    }

    public static void printEventBadge(String eventBadge) {
        System.out.println(eventBadge);
    }
}
