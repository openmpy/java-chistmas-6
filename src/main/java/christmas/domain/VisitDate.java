package christmas.domain;

import christmas.exception.InvalidVisitDateException;

public class VisitDate {

    private final int date;

    public VisitDate(int date) {
        validateDate(date);

        this.date = date;
    }

    private void validateDate(int date) {
        if (date < 1 || date > 31) {
            throw new InvalidVisitDateException();
        }
    }

    public int getDate() {
        return date;
    }
}
