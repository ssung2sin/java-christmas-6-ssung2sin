package christmas.constant;

public enum Constant {
    APPETIZER("에피타이저", 1),
    MAIN("메인", 2),
    DESSERT("디저트", 3),
    DRINK("음료", 4),
    WEEKDAY("평일", 1),
    WEEKEND("주말", 2),
    SPECIAL("특별", 3),
    CHRISTMAS("크리스마스", 4);

    private final String name;
    private final int nameCode;

    Constant(String name, int nameCode) {
        this.name = name;
        this.nameCode = nameCode;
    }

    public final String getName() {
        return name;
    }

    public final int getNameCode() {
        return nameCode;
    }
}
