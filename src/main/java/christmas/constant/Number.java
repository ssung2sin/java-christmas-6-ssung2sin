package christmas.constant;

public enum Number {

    THE_FIRST_DAY_OF_DECEMBER(1),
    THE_LAST_DAY_OF_DECEMBER(31),
    MENU(0),
    COUNT(1),
    STANDARD_OF_GIFT_MENU(120000),
    DELETE_FIRST_INDEX(0),
    DELETE_LAST_INDEX(6),
    FIRST_DIGIT(0),
    DISCOUNT_ON_CHRISTMAS_BASIS(1000),
    DISCOUNT_AMOUT_PER_DATE(100);

    private final int number;

    Number(int number) {
        this.number = number;
    }

    public final int getNumber() {
        return number;
    }
}
