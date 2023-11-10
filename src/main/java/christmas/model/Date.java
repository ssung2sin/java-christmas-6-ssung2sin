package christmas.model;

public class Date {
    private final int date;

    public Date(int date) {
        this.date = date;
    }

    public static Date saveDate(int date) {
        return new Date(date);
    }

    public int getDate() {
        return this.date;
    }
}
