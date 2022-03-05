package by.epam.lab.beans;

import by.epam.lab.utills.Constant;
import by.epam.lab.enums.RoundMethod;

public class Byn implements Comparable<Byn> {
    private final int value;

    public Byn(int value) {
        this.value = value;
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

    public String toString() {
        return String.format(Constant.VALUE_FORMAT, value / 100, value % 100);
    }

    @Override
    public int compareTo(Byn o) {
        return value - o.value;
    }
}
