package christmas.service;

import christmas.constant.Constant;
import christmas.constant.Number;
import christmas.constant.OutputMessage;
import christmas.constant.SavedMenus;
import christmas.model.AllData;
import christmas.view.OutputView;
import java.text.DecimalFormat;
import java.util.List;

public class DataService {

    private final AllData allData;
    private final CalculationService calculationService;

    public DataService(AllData alldata) {
        this.allData = alldata;
        this.calculationService = new CalculationService(alldata);
    }

    public void saveReservationDate(int date, String dateType) {
        allData.saveDate(date, dateType);
    }

    public void printOrderMenus() {
        for (int OrderMenuIndex = 0; OrderMenuIndex < allData.getOrderMenus().size(); OrderMenuIndex++) {
            String menuName = allData.getOrderMenus().get(OrderMenuIndex).getMenuName();
            int menuCount = allData.getOrderMenus().get(OrderMenuIndex).getMenuCount();
            OutputView.outputOrderMenus(menuName, menuCount);
        }
    }

    public void saveOrderMenus(List<String[]> menuList) {
        SavedMenus menu;
        for (String[] menuData : menuList) {
            int menuCount = Integer.parseInt(menuData[Number.COUNT.getNumber()]);
            menu = compareSavedMenus(menuData[Number.MENU.getNumber()]);
            allData.saveOrderMenus(menu, menuCount);
            for (int index = 0; index < menuCount; index++) {
                compareCategory(menu);
            }
        }

    }

    private void compareCategory(SavedMenus menu) {
        for (Constant category : Constant.values()) {
            if (menu.getCategory().equals(category.getName())) {
                countCategory(category.getNameCode());
                break;
            }
        }
    }

    private void countCategory(int categoryCode) {
        if (categoryCode == Constant.APPETIZER.getNameCode()) {
            allData.appetizerCount();
        }
        if (categoryCode == Constant.MAIN.getNameCode()) {
            allData.mainCount();
        }
        if (categoryCode == Constant.DESSERT.getNameCode()) {
            allData.dessertCount();
        }
        if (categoryCode == Constant.APPETIZER.getNameCode()) {
            allData.drinkCount();
        }
    }


    public void printBenefitContent() {
        int date = allData.getDate();
        OutputView.printBenefitContent(date);
    }

    public StringBuilder printGiftMenu(int totalAmount) {
        StringBuilder giftMenu = new StringBuilder();
        giftMenu.append(SavedMenus.CHAMPAGNE.getMenuName());
        giftMenu.append(" 1개");
        if (totalAmount < Number.STANDARD_OF_GIFT_MENU.getNumber()) {
            giftMenu.delete(Number.DELETE_FIRST_INDEX.getNumber(), Number.DELETE_LAST_INDEX.getNumber());
            giftMenu.append(OutputMessage.NOTHING.getMessage());
        }
        return giftMenu;
    }

    public void printBenefits() {
        int[] totalDiscount = totalDiscountAmount();
        boolean checkDiscount = getTotalAmount() >= Number.MINIMUM_AMOUNT.getNumber();
        if (checkDiscount) {
            String formattingDiscount = numberFormatting(
                    totalDiscount[Number.CHRISTMAS_D_DAY_DISCOUNT_NUMBER.getNumber()]);
            OutputView.printBenefitOfChristmasDDay(formattingDiscount);
            OutputView.printBenefits(totalDiscount, getTotalAmount());
        }
        if (!checkDiscount) {
            OutputView.printNothingBenefits();
        }
        OutputView.printAllBenefitAmount(totalDiscount[Number.TOTAL_DISCOUNT_NUMBER.getNumber()], checkDiscount
                , getTotalAmount());
        OutputView.printEstimatedAmount(getTotalAmount(), totalDiscount[Number.TOTAL_DISCOUNT_NUMBER.getNumber()],
                checkDiscount);
        printEventBadge(totalDiscount[Number.TOTAL_DISCOUNT_NUMBER.getNumber()]);
    }

    private void printEventBadge(int totalDiscount) {
        OutputView.printSubjectOfEventBadge();
        if (totalDiscount > Number.SANTA.getNumber()) {
            OutputView.printEventBadge(OutputMessage.SANTA.getMessage());
            return;
        }
        if (totalDiscount > Number.TREE.getNumber()) {
            OutputView.printEventBadge(OutputMessage.TREE.getMessage());
            return;
        }
        if (totalDiscount > Number.STAR.getNumber()) {
            OutputView.printEventBadge(OutputMessage.STAR.getMessage());
            return;
        }
        OutputView.printEventBadge(OutputMessage.NOTHING.getMessage());
    }

    private int[] totalDiscountAmount() {
        int[] returnDiscount = new int[Number.DISCOUNT_ALL_INCLUDE_SIZE.getNumber()];
        int totalDiscount = 0;
        int date = allData.getDate();
        String dateType = allData.getDateType();
        totalDiscount += calculationService.calculateChristmasDiscount(date);
        returnDiscount[Number.CHRISTMAS_D_DAY_DISCOUNT_NUMBER.getNumber()] = calculationService.calculateChristmasDiscount(
                date);
        int[] discountValues = compareOrderMenuCategory(dateType);
        assert discountValues != null;
        totalDiscount += discountValues[Number.DISCOUNT_NUMBER.getNumber()];
        if (isChristmasDayOrSpecialDay(dateType)) {
            totalDiscount += discountValues[Number.DISCOUNT_CHRISTMAS_NUMBER.getNumber()];
        }
        for (int index = 0; index < discountValues.length; index++) {
            returnDiscount[index] = discountValues[index];
        }
        returnDiscount[Number.TOTAL_DISCOUNT_NUMBER.getNumber()] = totalDiscount;

        return returnDiscount;
    }

    private boolean isChristmasDayOrSpecialDay(String dateType) {
        if (dateType.equals("특별") || dateType.equals("크리스마스")) {
            return true;
        }
        return false;
    }


    private int[] compareOrderMenuCategory(String dateType) {
        for (Constant date : Constant.values()) {
            if (dateType.equals(date.getName())) {
                return getDateTypeOfDiscount(date.getNameCode());
            }
        }
        return null;
    }

    private int[] getDateTypeOfDiscount(int nameCode) {
        int[] returnValue = new int[Number.DISCOUNT_ARRAY_SIZE.getNumber()];
        returnValue[Number.CATEGORY_NAME_NUMBER.getNumber()] = nameCode;
        int mainCount = allData.getCategoryCount().getCountMain();
        int dessertCount = allData.getCategoryCount().getCountDessert();
        if (nameCode == Constant.WEEKDAY.getNameCode()) {
            returnValue[Number.DISCOUNT_NUMBER.getNumber()] = dessertCount * Number.DISCOUNT_AMOUNT.getNumber();
        }
        if (nameCode == Constant.WEEKEND.getNameCode()) {
            returnValue[Number.DISCOUNT_NUMBER.getNumber()] = mainCount * Number.DISCOUNT_AMOUNT.getNumber();
        }
        if (nameCode == Constant.SPECIAL.getNameCode()) {
            returnValue[Number.DISCOUNT_CHRISTMAS_NUMBER.getNumber()] = Number.DISCOUNT_AMOUNT_OF_SPECIAL_DAY.getNumber();
            returnValue[Number.DISCOUNT_NUMBER.getNumber()] = dessertCount * Number.DISCOUNT_AMOUNT.getNumber();
        }
        if (nameCode == Constant.CHRISTMAS.getNameCode()) {
            returnValue[Number.DISCOUNT_CHRISTMAS_NUMBER.getNumber()] = Number.DISCOUNT_AMOUNT_OF_SPECIAL_DAY.getNumber();
            returnValue[Number.DISCOUNT_NUMBER.getNumber()] = dessertCount * Number.DISCOUNT_AMOUNT.getNumber();
        }
        return returnValue;
    }

    public int printChristmasDiscount() {
        int date = allData.getDate();
        int discountAmount = calculationService.calculateChristmasDiscount(date);
        String formattingAmount = numberFormatting(discountAmount);
        OutputView.printD_DayDiscount(formattingAmount);
        return discountAmount;

    }

    public void checkAllMenuAreDrinks(List<String[]> menuList) {
        int drinkCount = 0;
        for (int menuListIndex = 0; menuListIndex < menuList.size(); menuListIndex++) {
            String menuName = menuList.get(menuListIndex)[Number.MENU.getNumber()];
            SavedMenus menu = compareSavedMenus(menuName);
            assert menu != null;
            String menuCategory = menu.getCategory();
            if (checkMenuCategoryIsDrink(menuCategory)) {
                drinkCount++;
            }
        }
        Validator.CheckAllMenuAreDrink(drinkCount, menuList.size());
    }

    private boolean checkMenuCategoryIsDrink(String category) {
        if (category.equals(Constant.DRINK.getName())) {
            return true;
        }
        return false;
    }

    private SavedMenus compareSavedMenus(String menuName) {
        for (SavedMenus menu : SavedMenus.values()) {
            if (menuName.equals(menu.getMenuName())) {
                return menu;
            }
        }
        return null;
    }

    public void printTotalAmountBeforeDiscount() {
        int totalAmount = getTotalAmount();
        String formattingNumber = numberFormatting(totalAmount);
        OutputView.printTotalAmountBeforeDiscount(formattingNumber);
    }

    public int getTotalAmount() {
        int totalAmount = 0;
        for (int OrderMenuIndex = 0; OrderMenuIndex < allData.getOrderMenus().size(); OrderMenuIndex++) {
            int menuCount = allData.getOrderMenus().get(OrderMenuIndex).getMenuAmount()
                    * allData.getOrderMenus().get(OrderMenuIndex).getMenuCount();
            totalAmount += menuCount;
        }
        return totalAmount;
    }

    public static String numberFormatting(int totalAmount) {
        DecimalFormat formatter = new DecimalFormat("###,###");
        return formatter.format(totalAmount);
    }
}
