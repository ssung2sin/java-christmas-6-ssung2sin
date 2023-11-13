package christmas.service;

import christmas.constant.Number;
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
            giftMenu.append("없음");
        }
        return giftMenu;
    }

    public int printChristmasDiscount() {
        int date = allData.getDate();
        int discountAmount = calculationService.calculateChristmasDiscount(date);
        String formattingAmount = numberFormatting(discountAmount);
        OutputView.printD_DayDiscount(formattingAmount);
        return discountAmount;

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
