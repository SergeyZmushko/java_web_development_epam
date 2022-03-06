package by.epam.lab.beans;

import by.epam.lab.utils.Constant;
import by.epam.lab.enums.RoundMethod;

public class Byn implements Comparable<Byn> {
    private int value;

    public Byn(int value) {
        this.value = value;
    }

    public Byn sub(Byn byn) {
        return new Byn(value - byn.value);
    }

    public Byn mul(double k, RoundMethod roundMethod, int d) {
        return new Byn(roundMethod.round(value * k, d));
    }

    public String toString() {
        return String.format(Constant.VALUE_FORMAT, value / Constant.ONE_HUNDRED, value % Constant.ONE_HUNDRED);
    }

    @Override
    public int compareTo(Byn o) {
        return value - o.value;
    }
}
