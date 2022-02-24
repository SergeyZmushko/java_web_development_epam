package by.epam.lab;

public class Byn implements Comparable<Byn> {
    private final int value;
    private final static String VALUE_FORMAT = "%d.%02d";

    public Byn(int value) {
        this.value = value;
    }

    public Byn(Byn byn) {
        this(byn.value);
    }

    public boolean isPositive() {
        return value > 0;
    }

    public Byn add(Byn byn) {
       return new Byn(value + byn.value);
    }

    public Byn sub(Byn byn) {
       return new Byn(value - byn.value);
    }

    public Byn mul(int k) {
        return new Byn(value * k);
    }

    public String toString() {
        return String.format(VALUE_FORMAT, value / 100, value % 100);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Byn byn = (Byn) o;
        return value == byn.value;
    }

    @Override
    public int compareTo(Byn byn) {
        return value - byn.value;
    }
}
