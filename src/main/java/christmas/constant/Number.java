package christmas.constant;

public enum Number {

    THE_FIRST_DAY_OF_DECEMBER(1),
    THE_LAST_DAY_OF_DECEMBER(31);

    private final int number;

    Number(int number) {
        this.number = number;
    }

    public final int getNumber() {
        return number;
    }
}
