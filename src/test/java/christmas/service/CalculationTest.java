package christmas.service;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.model.AllData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CalculationTest {

    private AllData allData;
    private CalculationService calculationService;

    @BeforeEach
    void init() {
        this.allData = new AllData();
        this.calculationService = new CalculationService(allData);
    }

    @DisplayName("평일 날짜 입력시 '평일'저장되는지 확인")
    @ParameterizedTest
    @ValueSource(ints = {4, 7, 12, 27})
    void 입력한_날짜_저장_검사1(int input) {
        String date = calculationService.dateCalculation(input);
        assertThat(date).isEqualTo("평일");
    }

    @DisplayName("주말 날짜 입력시 '주말'저장되는지 확인")
    @ParameterizedTest
    @ValueSource(ints = {1, 9, 23, 29})
    void 입력한_날짜_저장_검사2(int input) {
        String date = calculationService.dateCalculation(input);
        assertThat(date).isEqualTo("주말");
    }

    @DisplayName("특별한 날짜 입력시 '평일+특별'저장되는지 확인")
    @ParameterizedTest
    @ValueSource(ints = {3, 17, 24, 31})
    void 입력한_날짜_저장_검사3(int input) {
        String date = calculationService.dateCalculation(input);
        assertThat(date).isEqualTo("평일+특별");
    }

    @DisplayName("크리스마스 날짜 입력시 '크리스마스'저장되는지 확인")
    @Test
    void 입력한_날짜_저장_검사4() {
        String date = calculationService.dateCalculation(25);
        assertThat(date).isEqualTo("크리스마스");
    }
}
