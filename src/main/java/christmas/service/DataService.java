package christmas.service;

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

    public boolean checktotalAmount() {
        int totalAmount = getTotalAmount();
        if (totalAmount >= Number.MINIMUM_AMOUNT.getNumber()) {
            return true;
        }
        return false;
    }

    public void printBenefits() {
        int totalDiscount = 0;
        int date = allData.getDate();
        totalDiscount += calculationService.calculateChristmasDiscount(date);
        totalDiscount += discountByDate();

    }

    private int discountByDate(){
        String date = allData.
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
        if (category.equals(SavedMenus.ZERO_COKE.getCategory())) {
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

    private String numberFormatting(int totalAmount) {
        DecimalFormat formatter = new DecimalFormat("###,###");
        return formatter.format(totalAmount);
    }
}
