package christmas.domain.constants;

public enum EventInfo {

    CHRISTMAS_DISCOUNT("크리스마스 디데이 할인", true),
    WEEKDAYS_DISCOUNT("평일 할인", true),
    WEEKEND_DISCOUNT("주말 할인", true),
    SPECIAL_DISCOUNT("특별 할인", true),
    BONUS_MENU_GIFT("증정 이벤트", false),
    ;

    private final String name;
    private final boolean isCheck;

    EventInfo(String name, boolean isCheck) {
        this.name = name;
        this.isCheck = isCheck;
    }

    public String getName() {
        return name;
    }

    public boolean isCheck() {
        return isCheck;
    }
}
