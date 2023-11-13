package christmas.service;

import christmas.constant.Number;
import christmas.constant.SavedMenus;
import christmas.model.AllData;
import java.util.List;

public class DataService {

    private final AllData allData;

    public DataService(AllData alldata) {
        this.allData = alldata;
    }

    public void saveReservationDate(int date) {
        allData.saveDate(date);
    }

    public void saveOrderMenus(List<String[]> menuList) {
        SavedMenus menu;
        for (String[] menuData : menuList) {
            int menuCount = Integer.parseInt(menuData[Number.COUNT.getNumber()]);
            menu = compareSavedMenus(menuData[Number.MENU.getNumber()]);
            allData.saveOrderMenus(menu, menuCount);
        }

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
