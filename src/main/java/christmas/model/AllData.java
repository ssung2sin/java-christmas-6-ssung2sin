package christmas.model;

import java.util.List;

public class AllData {

    private Date date;
    private List<OrderMenu> orderMenus;

    public AllData() {

    }

    public void saveDate(int date) {
        this.date = Date.saveDate(date);
    }

    public int getDate() {
        return this.date.getDate();
    }

    public void saveOrderMenus(OrderMenu orderMenu) {
        this.orderMenus.add(orderMenu);
    }

    public List<OrderMenu> getOrderMenu() {
        return orderMenus;
    }
}
