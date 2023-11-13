package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.constant.OutputMessage;
import christmas.service.InputService;
import java.util.List;

public class InputView {

    private final InputService inputService;

    public InputView(InputService inputService) {
        this.inputService = inputService;
    }

    public int readDate() {
        System.out.println(OutputMessage.ENTER_YOUR_VISIT_DATE.getMessage());
        String input = Console.readLine();
        return inputService.convertDateNumber(input);
    }

    public List<String[]> readOrderMenu() {
        System.out.println(OutputMessage.ENTER_MENU_TO_ORDER.getMessage());
        String input = Console.readLine();
        return inputService.saveOrderMenus(input);
    }
}
