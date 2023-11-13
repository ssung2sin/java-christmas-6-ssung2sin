package christmas.service;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.model.AllData;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class DataServiceTest {

    private DataService dataService;
    private AllData allData;
    private InputService inputService;

    @BeforeEach
    void init() {
        this.allData = new AllData();
        this.dataService = new DataService(allData);
        this.inputService = new InputService();
    }

    @DisplayName("입력한 날짜가 잘 저장되어 있는지 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 31, 20})
    void 입력한_날짜_저장_검사(int input) {
        dataService.saveReservationDate(input);
        assertThat(allData.getDate()).isEqualTo(input);
    }

    @DisplayName("입력한 메뉴 : 에피타이저 / 양송이수프 / 6000 / 3 +"
            + "음료 / 제로콜라 / 3000 / 2")
    @Test
    void 입력한_메뉴_저장_검사() {
        List<String[]> menuList = inputService.saveOrderMenus("양송이수프-3,제로콜라-2");
        dataService.saveOrderMenus(menuList);
        assertThat(allData.getOrderMenus().get(0).getCategory()).isEqualTo("에피타이저");
        assertThat(allData.getOrderMenus().get(0).getMenuName()).isEqualTo("양송이수프");
        assertThat(allData.getOrderMenus().get(0).getMenuAmount()).isEqualTo(6000);
        assertThat(allData.getOrderMenus().get(0).getMenuCount()).isEqualTo(3);
        assertThat(allData.getOrderMenus().get(1).getCategory()).isEqualTo("음료");
        assertThat(allData.getOrderMenus().get(1).getMenuName()).isEqualTo("제로콜라");
        assertThat(allData.getOrderMenus().get(1).getMenuAmount()).isEqualTo(3000);
        assertThat(allData.getOrderMenus().get(1).getMenuCount()).isEqualTo(2);
    }

}
