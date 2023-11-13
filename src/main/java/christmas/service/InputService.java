package christmas.service;

import christmas.constant.Number;
import java.util.ArrayList;
import java.util.List;

public class InputService {

    public int convertDateNumber(String input) {
        Validator.isIntegerNumber(input);
        int integerNumber = Integer.parseInt(input);
        Validator.dateValidation(integerNumber);
        return integerNumber;
    }

    public List<String[]> saveOrderMenus(String inputOrderMenus) {
        String[] splitOrderMenus = splitComma(inputOrderMenus);
        List<String[]> result = new ArrayList<>();
        int totalCount = 0;
        for (int menuIndex = 0; menuIndex < splitOrderMenus.length; menuIndex++) {
            String[] splitMenu = splitHyphen(splitOrderMenus[menuIndex]);
            Validator.inputMenuValidation(splitMenu);
            totalCount += Integer.parseInt(splitMenu[Number.COUNT.getNumber()]);
            result.add(splitMenu);
        }
        Validator.totalCountValidation(totalCount);
        return result;
    }

    private String[] splitComma(String inputOrderMenus) {
        return inputOrderMenus.split(",");
    }

    private String[] splitHyphen(String splitMenu) {
        return splitMenu.split("-");
    }

}
