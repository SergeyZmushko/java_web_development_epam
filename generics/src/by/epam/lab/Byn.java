package by.epam.lab;

public class Byn implements Comparable<Byn> {
    private final int value;
    private final static String VALUE_FORMAT = "%d.%02d";

    public Byn(int value) {
        this.value = value;
    }

    public Byn() {
        this(0);
    }

    public Byn add(Byn byn) {
        return new Byn(value + byn.value);
    }

    public Byn mul(int i) {
        return new Byn(value * i);
    }

    public Byn mul(double d) {
        return mul(d, RoundMethod.ROUND, 0);
    }

    public Byn sub(Byn byn) {
        return new Byn(value - byn.value);
    }

    public Byn divide(double k, RoundMethod roundMethod, int d) {
        return new Byn(roundMethod.round(value / k, d));
    }

    public Byn mul(double k, RoundMethod roundMethod, int d) {
        return new Byn(roundMethod.round(value * k, d));
    }

    public Byn round(RoundMethod roundMethod, int d) {
        return new Byn(roundMethod.round(value, d));
    }

    public String toString() {
        return String.format(VALUE_FORMAT, value / 100, value % 100);
    }

    @Override
    public int compareTo(Byn o) {
        return value - o.value;
    }
}
