package christmas.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.constant.ErrorMessage;
import christmas.model.AllData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputServiceTest {
    private InputService inputService;

    @BeforeEach
    void init() {
        DataService dataService = new DataService(new AllData());
        this.inputService = new InputService(dataService);
    }

    @DisplayName("입력한 날짜가 1일에서 31일이 아닐경우 오류메시지 발생")
    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "asd", "한글", "33", "31.1", "31a"})
    void 입력한_날짜_유효성_검사(String input) {
        assertThatThrownBy(() -> inputService.convertDateNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ENTER_INVALID_DATE.getMessage());
    }

    @DisplayName("입력 메뉴 잘못 입력시 에러 처리")
    @ParameterizedTest
    @ValueSource(strings = {"양송이수프-2,바비큐랍-1", "-3,초코케이크-1", " ", "제로콜라바비큐립"})
    void 입력_메뉴_유효성_검사1(String input) {
        assertThatThrownBy(() -> inputService.saveOrderMenus(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ENTER_INVALID_ORDER_MENU.getMessage());
    }

    @DisplayName("입력 메뉴 갯수 잘못 입력시 에러처리")
    @ParameterizedTest
    @ValueSource(strings = {"양송이수프-2,바비큐립-11a", "제로콜라-as,초코케이크-2", "제로콜라- ,양송이수프-2",
            "제로콜라,바비큐립", "제로콜라-0"})
    void 입력_메뉴_유효성_검사2(String input) {
        assertThatThrownBy(() -> inputService.saveOrderMenus(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ENTER_INVALID_ORDER_MENU.getMessage());
    }

    @DisplayName("입력 메뉴 갯수 초과시 에러 발생")
    @Test
    void 입력_메뉴_유효성_검사3() {
        assertThatThrownBy(() -> inputService.saveOrderMenus("양송이수프-2,바비큐립-11,제로콜라-8"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ENTER_INVALID_ORDER_MENU.getMessage());
    }

    @DisplayName("중복 메뉴 입력시 에러 발생")
    @ParameterizedTest
    @ValueSource(strings = {"양송이수프-2,양송이수프-4", "제로콜라-1,양송이수프-1,제로콜라-2"})
    void 입력_메뉴_유효성_검사4(String input) {
        assertThatThrownBy(() -> inputService.saveOrderMenus(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ENTER_INVALID_ORDER_MENU.getMessage());
    }

    @DisplayName("모든 입력 메뉴가 음료일 시 에러 발생")
    @ParameterizedTest
    @ValueSource(strings = {"제로콜라-2,샴페인-4", "샴페인-3", "제로콜라-2,레드와인-1,샴페인-3"})
    void 입력_메뉴_유효성_검사5(String input) {
        assertThatThrownBy(() -> inputService.saveOrderMenus(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ENTER_INVALID_ORDER_MENU.getMessage());
    }

}
