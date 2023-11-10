package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.constant.OutputMessage;
import christmas.service.InputService;

public class InputView {

    private InputService inputService;

    public InputView(InputService inputService) {
        this.inputService = inputService;
    }

    public int readDate() {
        System.out.println(OutputMessage.ENTER_YOUR_VISIT_DATE.getMessage());
        String input = Console.readLine();
        return inputService.convertDateNumber(input);
    }
}
