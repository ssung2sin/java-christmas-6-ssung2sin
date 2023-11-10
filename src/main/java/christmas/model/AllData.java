package christmas.model;

public class AllData {

    private Date date;

    public AllData() {

    }

    public void saveDate(int date) {
        this.date = Date.saveDate(date);
    }

    public int getDate() {
        return this.date.getDate();
    }
}
