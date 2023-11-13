package christmas.service;

import christmas.model.AllData;

public class CalculationService {

    private final AllData alldata;

    public CalculationService(AllData alldata) {
        this.alldata = alldata;
    }

    public String dateCalculation(int visitDate) {
        if (visitDate == 25) {
            return "크리스마스";
        }
        int week = visitDate % 7;

        if (week > 0 && week <= 2) {
            return "주말";
        }

        if (week >= 4 || week == 0) {
            return "평일";
        }

        return "평일+특별";
    }
}
