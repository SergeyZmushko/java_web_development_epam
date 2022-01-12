package by.epam.lab;

public class Purchase implements Comparable<Purchase> {
    public final static String PRODUCT_NAME = "Grape";
    public final static int PRICE = 1500;
    private int number;
    private double percent;
    private WeekDay day;

    public Purchase() {

    }

    public Purchase(int number, int percent, WeekDay day) {
        this.number = number;
        this.percent = percent;
        this.day = day;
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
        int result;
        result = (int) (PRICE * number * (100 - percent) / 100);
        if (result % 100 >= 50) {
            return (result / 100 + 1) * 100;
        } else {
            return (result / 100) * 100;
        }
    }

    @Override
    public String toString() {
        return number + ";" + percent + ";" + day + ";" + Utils.fromPennyToByn(getCost());
    }

    @Override
    public int compareTo(Purchase o) {
        return Integer.compare(number, o.number);
    }
}
