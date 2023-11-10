package christmas;

import christmas.controller.ChristmasController;
import christmas.service.InputService;
import christmas.view.InputView;

public class Application {
    public static void main(String[] args) {
        InputService inputservice = new InputService();
        InputView inputview = new InputView(inputservice);
        ChristmasController controller = new ChristmasController(inputview);
        controller.run();
    }
}
