package christmas.utils;

import christmas.domain.OrderMenu;
import christmas.exception.InvalidOrderMenuException;
import java.util.List;

public class StringParser {

    public static OrderMenu parseOrderMenu(String string) {
        try {
            List<String> strings = StringSplitter.splitDash(string);
            String foodName = strings.get(0);
            int amount = Integer.parseInt(strings.get(1));
            return new OrderMenu(foodName, amount);
        } catch (RuntimeException e) {
            throw new InvalidOrderMenuException();
        }
    }
}
