package christmas;

import christmas.controller.ChristmasController;
import christmas.view.InputView;

public class Application {
    public static void main(String[] args) {
        InputView inputview = new InputView();
        ChristmasController controller = new ChristmasController(inputview);
        controller.run();
    }
}
