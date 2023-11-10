package christmas.constant;

public enum OutputMessage {
    FIRST_PRINT_INTRODUCTION("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."),
    ENTER_YOUR_VISIT_DATE("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"),
    ENTER_MENU_TO_ORDER("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)"),
    OUTPUT_BENEFIT_CONTENT("12월 3일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"),
    PRINT_ORDER_MENU("<주문 메뉴>"),
    PRINT_TOTAL_AMOUNT_BEFORE_DISCOUNT("<할인 전 총주문 금액>"),
    PRINT_GIFT_MENU("<증정 메뉴>"),
    PRINT_BENEFITS("<혜택 내역>"),
    PRINT_TOTAL_BENEFITS_AMOUNT("<총혜택 금액>"),
    PRINT_ESTIMATED_AMOUNT("<할인 후 예상 결제 금액>"),
    PRINT_EVENT_BADGE("<12월 이벤트 배지>");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public final String getMessage() {
        return message;
    }
}
