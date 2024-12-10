package christmas.domain;

import christmas.domain.constants.FoodType;
import christmas.exception.InvalidOrderMenuException;
import christmas.utils.StringParser;
import java.util.List;

public class OrderMenus {

    private final List<OrderMenu> menus;

    public OrderMenus(List<OrderMenu> menus) {
        validateDistinct(menus);
        validateOnlyDrink(menus);
        validateAmount(menus);

        this.menus = menus;
    }

    public void printMenus() {
        for (OrderMenu menu : menus) {
            String formatted = String.format("%s %d개", menu.getFoodName(), menu.getAmount());
            System.out.println(formatted);
        }
    }

    public void printBeforeDiscountTotalPrice() {
        int totalPrice = getTotalPrice();
        String formatted = String.format("%s원", StringParser.formattedNumber(totalPrice));
        System.out.println(formatted);
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

    private void validateAmount(List<OrderMenu> menus) {
        int totalAmount = menus.stream()
                .mapToInt(OrderMenu::getAmount)
                .sum();

        if (totalAmount > 20) {
            throw new InvalidOrderMenuException();
        }
    }

    public List<OrderMenu> getMenus() {
        return menus;
    }

    public int getTotalPrice() {
        return menus.stream()
                .mapToInt(it -> it.getPrice() * it.getAmount())
                .sum();
    }

    public int getTotalFoodTypeCount(FoodType type) {
        return menus.stream()
                .filter(it -> it.getFoodType().equals(type))
                .mapToInt(OrderMenu::getAmount)
                .sum();
    }
}
