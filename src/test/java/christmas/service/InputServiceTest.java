package christmas.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.constant.ErrorMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputServiceTest {
    private InputService inputService;

    @BeforeEach
    void init() {
        this.inputService = new InputService();
    }

    @DisplayName("입력한 날짜가 1일에서 31일이 아닐경우 오류메시지 발생")
    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "asd", "한글", "33", "31.1", "31a"})
    void 입력한_날짜_유효성_검사(String input) {
        assertThatThrownBy(() -> inputService.convertDateNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ENTER_INVALID_DATE.getMessage());
    }
}
