package christmas.service;

import christmas.model.AllData;

public class DataService {

    private final AllData allData;

    public DataService(AllData alldata) {
        this.allData = alldata;
    }

    public void saveReservationDate(int date) {
        allData.saveDate(date);
    }

    public void loadMenu() {

    }
}
