package christmas.constant;

public enum SavedMenus {
    MUSHROOM_SOUP("에피타이저", "양송이수프", 6000),
    TAPAS("에피타이저", "타파스", 5000),
    CAESAR_SALAD("에피타이저", "시저샐러드", 8000),
    T_BONE_STEAK("메인", "티본스테이크", 55000),
    BARBICUE_RIBS("메인", "바비큐립", 45000),
    SEAFOOD_PASTA("메인", "해산물파스타", 35000),
    CHRISTMAS_PASTA("메인", "크리스마스파스타", 25000),
    CHOCOLATE_CAKE("디저트", "초코케이크", 15000),
    ICE_CREAM("디저트", "아이스크림", 5000),
    ZERO_COKE("음료", "제로콜라", 3000),
    RED_WINE("음료", "레드와인", 60000),

    CHAMPAGNE("음료", "샴페인", 25000);

    private final String category;
    private final String menuName;
    private final int menuAmount;

    SavedMenus(String category, String menuName, int menuAmount) {
        this.category = category;
        this.menuName = menuName;
        this.menuAmount = menuAmount;
    }

    public final String getCategory() {
        return category;
    }

    public final String getMenuName() {
        return menuName;
    }

    public final int getMenuAmount() {
        return menuAmount;
    }
}
