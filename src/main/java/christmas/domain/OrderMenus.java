package christmas.domain;

import christmas.domain.constants.FoodType;
import christmas.exception.InvalidOrderMenuException;
import java.util.List;

public class OrderMenus {

    private final List<OrderMenu> menus;

    public OrderMenus(List<OrderMenu> menus) {
        validateDistinct(menus);
        validateOnlyDrink(menus);

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

    private void validateOnlyDrink(List<OrderMenu> menus) {
        long drinkCount = menus.stream()
                .filter(it -> it.getFoodType().equals(FoodType.DRINK))
                .count();

        if (menus.size() == drinkCount) {
            throw new InvalidOrderMenuException();
        }
    }

    public List<OrderMenu> getMenus() {
        return menus;
    }
}
