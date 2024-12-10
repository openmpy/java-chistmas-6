package christmas.view.constants;

public enum ViewMessage {

    INPUT_VISIT_DATE("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"),
    INPUT_ORDER_MENU("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)"),

    OUTPUT_WELCOME("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."),
    OUTPUT_EVENT_PREVIEW("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"),
    OUTPUT_ORDER_MENU_HEADER("<주문 메뉴>"),
    OUTPUT_BEFORE_DISCOUNT_HEADER("<할인 전 총주문 금액>"),
    OUTPUT_BONUS_FOOD_HEADER("<증정 메뉴>"),
    OUTPUT_EVENT_LIST_HEADER("<혜택 내역>"),
    OUTPUT_TOTAL_DISCOUNT_HEADER("<총혜택 금액>"),
    OUTPUT_AFTER_DISCOUNT_HEADER("<할인 후 예상 결제 금액>"),
    OUTPUT_BADGE_HEADER("<12월 이벤트 배지>"),
    ;

    private final String value;

    ViewMessage(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
