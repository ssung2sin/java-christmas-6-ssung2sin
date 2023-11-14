package christmas.constant;

public enum Constant {
    APPETIZER("에피타이저"),
    MAIN("메인"),
    DESSERT("디저트"),
    DRINK("음료"),
    WEEKDAY("평일"),
    WEEKAND("주말"),
    SPECIAL("특별"),
    CHRISTMAS("크리스마스");

    private final String name;

    Constant(String name) {
        this.name = name;
    }

    public final String getName() {
        return name;
    }
}
