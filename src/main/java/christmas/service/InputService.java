package christmas.service;

import christmas.constant.Number;
import java.util.ArrayList;
import java.util.List;

public class InputService {
    final DataService dataService;

    public InputService(DataService dataService) {
        this.dataService = dataService;
    }

    public int convertDateNumber(String input) {
        Validator.isIntegerNumber(input);
        int integerNumber = Integer.parseInt(input);
        Validator.dateValidation(integerNumber);
        return integerNumber;
    }

    public List<String[]> saveOrderMenus(String inputOrderMenus) {
        String[] splitOrderMenus = splitComma(inputOrderMenus);
        List<String[]> menuList = new ArrayList<>();
        int totalCount = 0;
        for (int menuIndex = 0; menuIndex < splitOrderMenus.length; menuIndex++) {
            String[] splitMenu = splitHyphen(splitOrderMenus[menuIndex]);
            Validator.inputMenuValidation(splitMenu);
            totalCount += Integer.parseInt(splitMenu[Number.COUNT.getNumber()]);
            menuList.add(splitMenu);
        }
        Validator.duplicateMenuName(menuList);
        Validator.totalCountValidation(totalCount);
        dataService.checkAllMenuAreDrinks(menuList);
        return menuList;
    }

    private String[] splitComma(String inputOrderMenus) {
        return inputOrderMenus.split(",");
    }

    private String[] splitHyphen(String splitMenu) {
        return splitMenu.split("-");
    }

}
