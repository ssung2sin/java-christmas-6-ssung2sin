package christmas.model;

public class OrderMenu {

    private final String menuName;
    private final int menuCount;

    private OrderMenu(String menuName, int menuCount) {
        this.menuName = menuName;
        this.menuCount = menuCount;
    }

    public static OrderMenu saveOrderMenu(String menuName, int menuCount) {
        return new OrderMenu(menuName, menuCount);
    }

    public String getMenuName() {
        return menuName;
    }

    public int getMenuCount() {
        return menuCount;
    }
}
