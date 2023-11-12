package christmas.model;

public class OrderMenu {

    private final String category;
    private final String menuName;
    private final int menuCount;

    private OrderMenu(String category, String menuName, int menuCount) {
        this.category = category;
        this.menuName = menuName;
        this.menuCount = menuCount;
    }

    public static OrderMenu saveOrderMenu(String category, String menuName, int menuCount) {
        return new OrderMenu(category, menuName, menuCount);
    }

    public String getMenuName() {
        return menuName;
    }

    public int getMenuCount() {
        return menuCount;
    }
}
