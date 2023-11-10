package christmas.service;

import christmas.constant.ErrorMessage;
import christmas.constant.Number;

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
}
