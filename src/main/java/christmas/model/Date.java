package christmas.model;

public class Date {
    private final int date;
    private final String dateType;

    private Date(int date, String dateType) {
        this.date = date;
        this.dateType = dateType;
    }


    public static Date saveDate(int date, String dateType) {
        return new Date(date, dateType);
    }

    public int getDate() {
        return this.date;
    }
}