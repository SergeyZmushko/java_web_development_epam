package by.epam.lab;

public class Byn implements Comparable<Byn> {
    public int value;

    public Byn() {

    }

    public Byn(int value) {
        this.value = value;
    }

    public String toString() {
        return Utils.fromPennyToByn(value);
    }

    public Byn sum(Byn byn) {
        value += byn.value;
        return this;
    }

    public Byn difference(double value) {
        this.value -= value;
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
