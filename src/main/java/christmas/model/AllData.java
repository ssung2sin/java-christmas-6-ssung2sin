package christmas.model;

import christmas.constant.SavedMenus;
import java.util.ArrayList;
import java.util.List;

public class AllData {

    private Date date;
    private final List<OrderMenu> orderMenus;
    private final CategoryCount categoryCount;

    public AllData() {
        this.orderMenus = new ArrayList<>();
        this.categoryCount = new CategoryCount();
    }

    public void saveDate(int date, String dateType) {
        this.date = Date.saveDate(date, dateType);
    }

    public int getDate() {
        return this.date.getDate();
    }

    public String getDateType() {
        return this.date.getDateType();
    }

    public void saveOrderMenus(SavedMenus menu, int orderCount) {
        OrderMenu orderMenu = OrderMenu.saveOrderMenu(menu, orderCount);
        orderMenus.add(orderMenu);
    }

    public List<OrderMenu> getOrderMenus() {
        return orderMenus;
    }

    public void appetizerCount() {
        this.categoryCount.countAppetizer();
    }

    public void mainCount() {
        this.categoryCount.countMain();
    }

    public void dessertCount() {
        this.categoryCount.countDessert();
    }

    public void drinkCount() {
        this.categoryCount.countDrink();
    }

    public CategoryCount getCategoryCount() {
        return categoryCount;
    }
}
