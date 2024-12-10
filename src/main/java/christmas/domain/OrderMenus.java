package christmas.domain;

import christmas.exception.InvalidOrderMenuException;
import java.util.List;

public class OrderMenus {

    private final List<OrderMenu> menus;

    public OrderMenus(List<OrderMenu> menus) {
        validateDistinct(menus);

        this.menus = menus;
    }

    public void printMenus() {
        for (OrderMenu menu : menus) {
            String formatted = String.format("%s %d개", menu.getFoodName(), menu.getAmount());
            System.out.println(formatted);
        }
    }

    private void validateDistinct(List<OrderMenu> menus) {
        long count = menus.stream().distinct().count();

        if (menus.size() != count) {
            throw new InvalidOrderMenuException();
        }
    }

    public List<OrderMenu> getMenus() {
        return menus;
    }
}
