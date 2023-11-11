package christmas.service;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.model.AllData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class DataServiceTest {

    private DataService dataService;
    private AllData allData;

    @BeforeEach
    void init() {
        this.allData = new AllData();
        this.dataService = new DataService(allData);
    }

    @DisplayName("입력한 날짜가 잘 저장되어 있는지 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 31, 20})
    void 입력한_날짜_저장_검사(int input) {
        dataService.saveReservationDate(input);
        assertThat(allData.getDate()).isEqualTo(input);
    }
}
