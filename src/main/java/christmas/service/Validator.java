package christmas.service;

import christmas.constant.ErrorMessage;
import christmas.constant.Number;
import christmas.constant.SavedMenus;
import java.util.List;

public class Validator {

    public static void isIntegerNumber(String number) {
        for (int numberOfDigits = 0; numberOfDigits < number.length(); numberOfDigits++) {
            if (!Character.isDigit(number.charAt(numberOfDigits))) {
                throw new IllegalArgumentException(ErrorMessage.ENTER_INVALID_DATE.getMessage());
            }
        }
    }

    public static void dateValidation(int integerNumber) {
        if (integerNumber < Number.THE_FIRST_DAY_OF_DECEMBER.getNumber() ||
                integerNumber > Number.THE_LAST_DAY_OF_DECEMBER.getNumber()) {
            throw new IllegalArgumentException(ErrorMessage.ENTER_INVALID_DATE.getMessage());
        }
    }

    public static void inputMenuValidation(String[] menu) {
        isMenuNameValidation(menu[Number.MENU.getNumber()]);
        isMenuCountValidation(menu[Number.COUNT.getNumber()]);
    }

    public static void duplicateMenuName(List<String[]> menuList) {
        String[] menuName = separateMenuName(menuList);
        for (int index = 0; index < menuList.size(); index++) {
            if (compareMenuName(menuName[index], menuName, index)) {
                throw new IllegalArgumentException(ErrorMessage.ENTER_INVALID_ORDER_MENU.getMessage());
            }
        }
    }

    private static String[] separateMenuName(List<String[]> menuList) {
        String[] menuName = new String[menuList.size()];
        for (int index = 0; index < menuList.size(); index++) {
            menuName[index] = menuList.get(index)[Number.MENU.getNumber()];
        }
        return menuName;
    }

    private static boolean compareMenuName(String menuName, String[] arrayMenuName, int menuIndex) {
        for (int index = 0; index < arrayMenuName.length; index++) {
            if (index == menuIndex) {
                continue;
            }
            if (menuName.equals(arrayMenuName[index])) {
                return true;
            }
        }
        return false;
    }

    public static void totalCountValidation(int totalCount) {
        if (totalCount > 20) {
            throw new IllegalArgumentException(ErrorMessage.ENTER_INVALID_ORDER_MENU.getMessage());
        }
    }

    private static void isMenuNameValidation(String inputMenu) {
        int menuCount = 0;
        int differenceCompareCount = 0;
        for (SavedMenus menu : SavedMenus.values()) {
            if (!inputMenu.equals(menu.getMenuName())) {
                differenceCompareCount++;
            }
            menuCount++;
        }
        if (differenceCompareCount == menuCount) {
            throw new IllegalArgumentException(ErrorMessage.ENTER_INVALID_ORDER_MENU.getMessage());
        }
    }

    private static void isMenuCountValidation(String inputCount) {
        for (int numberIndex = 0; numberIndex < inputCount.length(); numberIndex++) {
            isMenuCountIntegerNumber(inputCount.charAt(numberIndex));
        }
        isFirstNumberNotZero(inputCount.charAt(Number.FIRST_DIGIT.getNumber()));
    }

    private static void isFirstNumberNotZero(char firstDigit) {
        if (firstDigit == '0') {
            throw new IllegalArgumentException(ErrorMessage.ENTER_INVALID_ORDER_MENU.getMessage());
        }
    }

    private static void isMenuCountIntegerNumber(char inputCount) {
        if (!Character.isDigit(inputCount)) {
            throw new IllegalArgumentException((ErrorMessage.ENTER_INVALID_ORDER_MENU.getMessage()));
        }
    }


}
