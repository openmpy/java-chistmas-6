package christmas.domain;

import christmas.domain.constants.FoodInfo;
import christmas.domain.constants.FoodType;
import christmas.exception.InvalidOrderMenuException;

public class OrderMenu {

    private final FoodInfo foodInfo;
    private final int amount;

    public OrderMenu(String foodName, int amount) {
        validateAmount(amount);

        this.foodInfo = FoodInfo.of(foodName);
        this.amount = amount;
    }

    private void validateAmount(int amount) {
        if (amount < 1) {
            throw new InvalidOrderMenuException();
        }
    }

    public String getFoodName() {
        return foodInfo.getName();
    }

    public int getAmount() {
        return amount;
    }

    public FoodType getFoodType() {
        return foodInfo.getType();
    }

    public int getPrice() {
        return foodInfo.getPrice();
    }
}
