package christmas.service;

public class InputService {

    public int convertDateNumber(String input) {
        Validator.isIntegerNumber(input);
        int integerNumber = Integer.parseInt(input);
        Validator.dateValidation(integerNumber);
        return integerNumber;
    }
}
