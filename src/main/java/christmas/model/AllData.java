package christmas.model;

import christmas.constant.SavedMenus;
import java.util.ArrayList;
import java.util.List;

public class AllData {

    private Date date;
    private final List<OrderMenu> orderMenus;
    /*private List<OrderMenu> menus;*/

    public AllData() {
        this.orderMenus = new ArrayList<>();
        /*this.menus = new ArrayList<>();*/
    }

    public void saveDate(int date) {
        this.date = Date.saveDate(date);
    }

    public int getDate() {
        return this.date.getDate();
    }

    /*public void loadMenus(String category, String orderMenu, int menuAmount) {
        OrderMenu menu = OrderMenu.loadMenu(category, orderMenu, menuAmount);
        this.menus.add(menu);
    }*/

    /*public List<OrderMenu> getMenus() {
        return menus;
    }*/

    public void saveOrderMenus(SavedMenus menu, int orderCount) {
        OrderMenu orderMenu = OrderMenu.saveOrderMenu(menu, orderCount);
        orderMenus.add(orderMenu);
    }

    public List<OrderMenu> getOrderMenus() {
        return orderMenus;
    }
}
