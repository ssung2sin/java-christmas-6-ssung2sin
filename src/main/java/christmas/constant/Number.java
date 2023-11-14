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
    DISCOUNT_AMOUNT(2300),
    DISCOUNT_ON_CHRISTMAS_BASIS(1000),

    DISCOUNT_AMOUNT_OF_SPECIAL_DAY(1000),
    DISCOUNT_AMOUNT_PER_DATE(100),
    MINIMUM_AMOUNT(10000),
    IS_NOT_EXISTED_MENU_COUNT(1),
    DISCOUNT_ARRAY_SIZE(3),
    DISCOUNT_ALL_INCLUDE_SIZE(5),
    CHRISTMAS_D_DAY_DISCOUNT_NUMBER(4),
    CATEGORY_NAME_NUMBER(0),
    DISCOUNT_NUMBER(1),
    DISCOUNT_CHRISTMAS_NUMBER(2),
    TOTAL_DISCOUNT_NUMBER(3),
    STAR(5000),
    TREE(10000),
    SANTA(20000);

    private final int number;

    Number(int number) {
        this.number = number;
    }

    public final int getNumber() {
        return number;
    }
}
