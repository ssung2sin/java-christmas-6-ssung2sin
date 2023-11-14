package christmas.constant;

public enum Category {
    APPETIZER("에피타이저"),
    MAIN("메인"),
    DESSERT("디저트"),
    DRINK("음료");

    private final String category;

    Category(String category) {
        this.category = category;
    }

    public final String getCategory() {
        return category;
    }
}
