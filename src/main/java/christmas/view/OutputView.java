package christmas.view;

import christmas.domain.Event;
import christmas.domain.OrderMenus;
import christmas.domain.VisitDate;
import christmas.view.constants.ViewMessage;

public class OutputView {

    public static void printWelcome() {
        System.out.println(ViewMessage.OUTPUT_WELCOME.getValue());
    }

    public static void printEventPreview(VisitDate visitDate) {
        String formatted = String.format(ViewMessage.OUTPUT_EVENT_PREVIEW.getValue(), visitDate.getDate());
        System.out.println(formatted);
        System.out.println();
    }

    public static void printOrderMenus(OrderMenus orderMenus) {
        System.out.println(ViewMessage.OUTPUT_ORDER_MENU_HEADER.getValue());
        orderMenus.printMenus();
        System.out.println();
    }

    public static void printBeforeDiscount(OrderMenus orderMenus) {
        System.out.println(ViewMessage.OUTPUT_BEFORE_DISCOUNT_HEADER.getValue());
        orderMenus.printBeforeDiscountTotalPrice();
        System.out.println();
    }

    public static void printBonusMenu(Event event) {
        System.out.println(ViewMessage.OUTPUT_BONUS_FOOD_HEADER.getValue());
        event.printBonusMenu();
        System.out.println();
    }

    public static void printEvent(Event event) {
        System.out.println(ViewMessage.OUTPUT_EVENT_LIST_HEADER.getValue());
        event.printEvents();
        System.out.println();
    }

    public static void printTotalDiscountPrice(Event event) {
        System.out.println(ViewMessage.OUTPUT_TOTAL_DISCOUNT_HEADER.getValue());
        event.printTotalDiscountPrice();
        System.out.println();
    }

    public static void printAfterTotalDiscountPrice(Event event, OrderMenus orderMenus) {
        System.out.println(ViewMessage.OUTPUT_AFTER_DISCOUNT_HEADER.getValue());
        event.printAfterTotalDiscountPrice(orderMenus);
        System.out.println();
    }

    public static void printBadge(Event event) {
        System.out.println(ViewMessage.OUTPUT_BADGE_HEADER.getValue());
        event.printBadge();
    }
}
