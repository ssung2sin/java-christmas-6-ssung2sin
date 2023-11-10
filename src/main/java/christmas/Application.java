package christmas;

import christmas.controller.ChristmasController;
import christmas.service.DataService;
import christmas.service.InputService;
import christmas.view.InputView;

public class Application {
    public static void main(String[] args) {
        InputService inputservice = new InputService();
        InputView inputview = new InputView(inputservice);
        DataService dataService = new DataService();
        ChristmasController controller = new ChristmasController(inputview, dataService);
        controller.run();
    }
}
