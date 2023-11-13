package christmas.service;

import christmas.constant.Number;
import christmas.constant.SavedMenus;
import christmas.model.AllData;
import christmas.view.OutputView;
import java.util.List;

public class DataService {

    private final AllData allData;

    public DataService(AllData alldata) {
        this.allData = alldata;
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

    private SavedMenus compareSavedMenus(String menuName) {
        for (SavedMenus menu : SavedMenus.values()) {
            if (menuName.equals(menu.getMenuName())) {
                return menu;
            }
        }
        return null;
    }
}
