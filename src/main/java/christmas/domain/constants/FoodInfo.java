package christmas.domain.constants;

import christmas.exception.InvalidOrderMenuException;
import java.util.Arrays;

public enum FoodInfo {

    MUSHROOM_SOUP(FoodType.APPETIZER, "양송이수프", 6000),
    TAPAS(FoodType.APPETIZER, "타파스", 5500),
    CAESAR_SALAD(FoodType.APPETIZER, "시저샐러드", 8000),

    T_BONE_STEAK(FoodType.MAIN, "티본스테이크", 55000),
    BARBECUE_RIBS(FoodType.MAIN, "바비큐립", 54000),
    SEAFOOD_PASTA(FoodType.MAIN, "해산물파스타", 35000),
    CHRISTMAS_PASTA(FoodType.MAIN, "크리스마스파스타", 25000),

    CHOCOLATE_CAKE(FoodType.DESSERT, "초코케이크", 15000),
    ICE_CREAM(FoodType.DESSERT, "아이스크림", 5000),

    ZERO_COLA(FoodType.DRINK, "제로콜라", 3000),
    RED_WINE(FoodType.DRINK, "레드와인", 60000),
    CHAMPAGNE(FoodType.DRINK, "샴페인", 25000),
    ;

    private final FoodType type;
    private final String name;
    private final int price;

    FoodInfo(FoodType type, String name, int price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    public static FoodInfo of(String name) {
        return Arrays.stream(values())
                .filter(it -> it.name.equals(name))
                .findFirst()
                .orElseThrow(InvalidOrderMenuException::new);
    }

    public FoodType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
