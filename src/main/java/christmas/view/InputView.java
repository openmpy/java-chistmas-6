package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.view.constants.ViewMessage;

public class InputView {

    public static int readVisitDate() {
        System.out.println(ViewMessage.INPUT_VISIT_DATE.getValue());
        String value = Console.readLine();
        return Integer.parseInt(value);
    }

    public static String readOrderMenu() {
        System.out.println(ViewMessage.INPUT_ORDER_MENU.getValue());
        return Console.readLine();
    }
}
