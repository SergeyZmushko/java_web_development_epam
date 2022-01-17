package by.epam.lab;

public class Byn implements Comparable<Byn> {
    private int value;

    public Byn() {

    }

    public Byn(int value) {
        this.value = value;
    }

    public Byn sum(Byn byn) {
        value += byn.value;
        return this;
    }

    public Byn difference(Byn byn) {
        value -= byn.value;
        return this;
    }

    public Byn multiplication(int value) {
        this.value *= value;
        return this;
    }

    public Byn multiplication(double value) {
        this.value = (int) Math.round(this.value * value);
        return this;
    }

    public String toString() {
        return String.format("%d.%02d", value / 100, value % 100);
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
