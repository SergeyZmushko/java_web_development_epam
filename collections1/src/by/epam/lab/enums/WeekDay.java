package by.epam.lab.enums;

import by.epam.lab.utils.Constant;

public enum WeekDay {
    MONDAY(Constant.MONDAY),
    TUESDAY(Constant.TUESDAY),
    WEDNESDAY(Constant.WEDNESDAY),
    THURSDAY(Constant.THURSDAY),
    FRIDAY(Constant.FRIDAY),
    SATURDAY(Constant.SATURDAY),
    SUNDAY(Constant.SUNDAY);

    private final String day;

    WeekDay(String day) {
        this.day = day;
    }

    public String getDay() {
        return day;
    }
}
