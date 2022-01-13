package by.epam.lab;

public class Purchase implements Comparable<Purchase> {
    public final static String PRODUCT_NAME = "Grape";
    public final static int PRICE = 1500;
    private int number;
    private double percent;
    private WeekDay day;

    public Purchase() {

    }

    public Purchase(int number, double percent, WeekDay day) {
        this.number = number;
        this.percent = percent;
        this.day = day;
    }

    public Purchase(int number, double percent, int day) {
        this(number, percent, WeekDay.values()[day]);
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    public WeekDay getDay() {
        return day;
    }

    public void setDay(WeekDay day) {
        this.day = day;
    }

    public int getCost() {
        return (int) Math.round(PRICE * number * (100 - percent) / 10000) * 100;
    }

    @Override
    public String toString() {
        return number + ";" + percent + ";" + day + ";" + Utils.fromPennyToByn(getCost());
    }

    @Override
    public int compareTo(Purchase purchase) {
        return number - purchase.getNumber();
    }
}
