package christmas.service;

import christmas.constant.Number;
import christmas.model.AllData;

public class CalculationService {

    private final AllData alldata;

    public CalculationService(AllData alldata) {
        this.alldata = alldata;
    }

    public String dateCalculation(int visitDate) {
        int week = visitDate % 7;
        if (week > 0 && week <= 2) {
            return "주말";
        }
        if (week >= 4 || week == 0) {
            return "평일";
        }
        return "특별";
    }

    public int calculateChristmasDiscount(int date) {
        int basisAmount = Number.DISCOUNT_ON_CHRISTMAS_BASIS.getNumber();
        basisAmount += Number.DISCOUNT_AMOUNT_PER_DATE.getNumber() * (date - 1);
        return basisAmount;
    }
}
