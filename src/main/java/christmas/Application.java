package christmas;

import christmas.domain.Event;
import christmas.domain.OrderMenu;
import christmas.domain.OrderMenus;
import christmas.domain.VisitDate;
import christmas.exception.InvalidOrderMenuException;
import christmas.exception.InvalidVisitDateException;
import christmas.utils.StringParser;
import christmas.utils.StringSplitter;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        // 환영 인사
        OutputView.printWelcome();

        // 예약 날짜 입력
        VisitDate visitDate = readVisitDate();

        // 음식 주문 입력
        OrderMenus orderMenus = readOrderMenus();

        // 이벤트 프리뷰
        OutputView.printEventPreview(visitDate);

        // 주문 메뉴 목록
        OutputView.printOrderMenus(orderMenus);

        // 할인 전 총주문 금액
        OutputView.printBeforeDiscount(orderMenus);

        // 이벤트
        Event event = new Event(visitDate, orderMenus);

        // 증정 메뉴
        OutputView.printBonusMenu(event);

        // 혜택 내역
        OutputView.printEvent(event);

        // 총혜택 금액
        OutputView.printTotalDiscountPrice(event);

        // 할인 후 예상 결제 금액
        OutputView.printAfterTotalDiscountPrice(event, orderMenus);

        // 12월 이벤트 뱃지
        OutputView.printBadge(event);
    }

    private static VisitDate readVisitDate() {
        while (true) {
            try {
                int readVisitDate = InputView.readVisitDate();
                return new VisitDate(readVisitDate);
            } catch (InvalidVisitDateException e) {
                System.out.println(e.getMessage());
                System.out.println();
            }
        }
    }

    private static OrderMenus readOrderMenus() {
        while (true) {
            try {
                String readOrderMenu = InputView.readOrderMenu();
                List<OrderMenu> orderMenuList = StringSplitter.splitComma(readOrderMenu).stream()
                        .map(StringParser::parseOrderMenu)
                        .toList();
                return new OrderMenus(orderMenuList);
            } catch (InvalidOrderMenuException e) {
                System.out.println(e.getMessage());
                System.out.println();
            }
        }
    }
}
