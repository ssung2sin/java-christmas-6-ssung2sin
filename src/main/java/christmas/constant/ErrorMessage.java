package christmas.constant;

public enum ErrorMessage {
    ENTER_INVALID_DATE("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    ENTER_INVALID_ORDER_MENU("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public final String getMessage() {
        return message;
    }
}
