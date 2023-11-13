package christmas.constant;

public enum Number {

    THE_FIRST_DAY_OF_DECEMBER(1),
    THE_LAST_DAY_OF_DECEMBER(31),
    MENU(0),
    COUNT(1),
    FIRST_DIGIT(0);

    private final int number;

    Number(int number) {
        this.number = number;
    }

    public final int getNumber() {
        return number;
    }
}
