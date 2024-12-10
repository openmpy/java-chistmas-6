package christmas.domain;

import christmas.domain.constants.BadgeInfo;
import christmas.domain.constants.EventInfo;
import christmas.domain.constants.FoodType;
import christmas.utils.StringParser;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Event {

    private final Map<EventInfo, Integer> eventMap = new HashMap<>();

    private BonusMenu bonusMenu = null;
    private BadgeInfo badgeInfo = null;

    public Event(VisitDate visitDate, OrderMenus orderMenus) {
        checkBonusMenu(orderMenus.getTotalPrice());
        checkChristmasDiscount(visitDate.getDate());
        checkDayDiscount(visitDate.getDate(), orderMenus);
        checkSpecialDiscount(visitDate.getDate());
        checkBadge(getTotalDiscountPrice());
    }

    public void printBonusMenu() {
        if (bonusMenu == null) {
            System.out.println("없음");
            return;
        }

        String formatted = String.format("%s %d개", bonusMenu.getFoodName(), bonusMenu.getAmount());
        System.out.println(formatted);
    }

    public void printEvents() {
        if (eventMap.isEmpty()) {
            System.out.println("없음");
            return;
        }

        eventMap.keySet().forEach(eventInfo -> {
            String formattedNumber = StringParser.formattedNumber(eventMap.get(eventInfo));
            String formatted = String.format("%s: -%s원", eventInfo.getName(), formattedNumber);
            System.out.println(formatted);
        });
    }

    public void printTotalDiscountPrice() {
        String formattedNumber = StringParser.formattedNumber(getTotalDiscountPrice());
        String formatted = String.format("-%s원", formattedNumber);
        System.out.println(formatted);
    }

    public void printAfterTotalDiscountPrice(OrderMenus orderMenus) {
        String formattedNumber = StringParser.formattedNumber(getAfterTotalDiscountPrice(orderMenus));
        String formatted = String.format("%s원", formattedNumber);
        System.out.println(formatted);
    }

    public void printBadge() {
        if (badgeInfo == null) {
            System.out.println("없음");
            return;
        }

        System.out.println(badgeInfo.getName());
    }

    private void checkBonusMenu(int totalPrice) {
        if (totalPrice > 120000) {
            bonusMenu = new BonusMenu("샴페인", 1);
            eventMap.put(EventInfo.BONUS_MENU_GIFT, bonusMenu.getPrice() * bonusMenu.getAmount());
        }
    }

    private void checkChristmasDiscount(int date) {
        if (date >= 1 && date <= 25) {
            int discountPrice = 1000 + (date - 1) * 100;
            eventMap.put(EventInfo.CHRISTMAS_DISCOUNT, discountPrice);
        }
    }

    private void checkDayDiscount(int date, OrderMenus orderMenus) {
        LocalDate localDate = LocalDate.of(2023, 12, date);
        int dayOfWeek = localDate.getDayOfWeek().getValue();
        int discountPrice = 2023;

        if (dayOfWeek == 1 || dayOfWeek == 2 || dayOfWeek == 3 || dayOfWeek == 4 || dayOfWeek == 7) {
            discountPrice *= orderMenus.getTotalFoodTypeCount(FoodType.DESSERT);
            eventMap.put(EventInfo.WEEKDAYS_DISCOUNT, discountPrice);
        } else if (dayOfWeek == 5 || dayOfWeek == 6) {
            discountPrice *= orderMenus.getTotalFoodTypeCount(FoodType.MAIN);
            eventMap.put(EventInfo.WEEKEND_DISCOUNT, discountPrice);
        }
    }

    private void checkSpecialDiscount(int date) {
        LocalDate localDate = LocalDate.of(2023, 12, date);
        int dayOfWeek = localDate.getDayOfWeek().getValue();

        if (date == 25 || dayOfWeek == 7) {
            eventMap.put(EventInfo.SPECIAL_DISCOUNT, 1000);
        }
    }

    private void checkBadge(int totalDiscountPrice) {
        if (totalDiscountPrice >= 20000) {
            badgeInfo = BadgeInfo.SANTA;
        } else if (totalDiscountPrice >= 10000) {
            badgeInfo = BadgeInfo.TREE;
        } else if (totalDiscountPrice >= 5000) {
            badgeInfo = BadgeInfo.STAR;
        }
    }

    public int getTotalDiscountPrice() {
        return eventMap.keySet()
                .stream()
                .mapToInt(eventMap::get)
                .sum();
    }

    public int getAfterTotalDiscountPrice(OrderMenus orderMenus) {
        int checkTotalPrice = eventMap.keySet()
                .stream()
                .filter(EventInfo::isCheck)
                .mapToInt(eventMap::get)
                .sum();

        return orderMenus.getTotalPrice() - checkTotalPrice;
    }
}
