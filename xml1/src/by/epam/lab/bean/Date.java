package by.epam.lab.bean;

import static by.epam.lab.util.Constants.*;

public class Date {
    private final String date;
    private final String month;
    private final String year;

    public Date(String date, String month, String year) {
        this.date = date;
        this.month = month;
        this.year = year;
    }

    public Date(String date) {
        this(getSeparatedDate(date));
    }

    public Date(Date date) {
        this(date.date, date.month, date.year);
    }

    private static Date getSeparatedDate(String date) {
        String[] dateMas = date.split(SEPARATOR_DASH);
        return new Date(dateMas[DATE_IND], dateMas[MONTH_IND], dateMas[YEAR_IND]);
    }

    @Override
    public String toString() {
        return date + DOT + month + DOT + year;
    }
}
