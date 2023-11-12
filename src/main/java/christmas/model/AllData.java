package christmas.model;

import java.util.List;

public class AllData {

    private Date date;
    private List<OrderMenu> orderMenus;

    public void saveDate(int date) {
        this.date = Date.saveDate(date);
    }

    public int getDate() {
        return this.date.getDate();
    }

    public void saveOrderMenus(String category, String orderMenu, int menuAmount, int orderCount) {
        OrderMenu menu = OrderMenu.saveOrderMenu(category, orderMenu, menuAmount, orderCount);
        orderMenus.add(menu);
    }

    public List<OrderMenu> getOrderMenus() {
        return orderMenus;
    }
}
