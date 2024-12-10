package christmas.view;

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
}
