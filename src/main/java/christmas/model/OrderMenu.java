package christmas.model;

import christmas.constant.SavedMenus;

public class OrderMenu {

    private final String category;
    private final String menuName;
    private final int menuAmount;
    private final int menuCount;

    private OrderMenu(String category, String menuName, int menuAmount, int menuCount) {
        this.category = category;
        this.menuName = menuName;
        this.menuAmount = menuAmount;
        this.menuCount = menuCount;
    }

    public static OrderMenu saveOrderMenu(SavedMenus menu, int menuCount) {
        return new OrderMenu(menu.getCategory(), menu.getMenuName(), menu.getMenuAmount(), menuCount);
    }

    public String getCategory() {
        return category;
    }

    public String getMenuName() {
        return menuName;
    }

    public int getMenuCount() {
        return menuCount;
    }

    public int getMenuAmount() {
        return menuAmount;
    }
}
