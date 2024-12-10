package christmas.utils;

import christmas.domain.OrderMenu;
import christmas.exception.InvalidOrderMenuException;
import java.text.NumberFormat;
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

    public static String formattedNumber(int number) {
        NumberFormat numberFormat = NumberFormat.getInstance();
        return numberFormat.format(number);
    }
}
