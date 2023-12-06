package christmas;

import christmas.controller.ChristmasController;
import christmas.model.AllData;
import christmas.service.CalculationService;
import christmas.service.DataService;
import christmas.service.InputService;
import christmas.view.InputView;

public class Application {
    public static void main(String[] args) {
        DataService dataService = new DataService(new AllData());
        InputView inputview = new InputView(new InputService(dataService));
        CalculationService calculationService = new CalculationService(new AllData());
        ChristmasController controller = new ChristmasController(inputview, dataService, calculationService);
        controller.run();
    }
}
