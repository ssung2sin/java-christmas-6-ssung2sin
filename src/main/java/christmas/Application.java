package christmas;

import christmas.controller.ChristmasController;
import christmas.model.AllData;
import christmas.service.DataService;
import christmas.service.InputService;
import christmas.view.InputView;

public class Application {
    public static void main(String[] args) {
        InputView inputview = new InputView(new InputService());
        DataService dataService = new DataService(new AllData());
        ChristmasController controller = new ChristmasController(inputview, dataService);
        controller.run();
    }
}
