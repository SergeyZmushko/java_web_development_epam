package by.epam.lab.beans;

import by.epam.lab.utils.Constant;
import by.epam.lab.utils.RoundMethod;

import java.util.Scanner;

public class Byn implements Comparable<Byn> {
    private int value;

    public Byn() {

    }

    public Byn(int value) {
        this.value = value;
    }

    public Byn(int rubs, int coins) {
        this(rubs * Constant.ONE_HUNDRED + coins);
    }

    public Byn(Scanner sc) {
        this(sc.nextInt());
    }

    public int getRubs() {
        return value / Constant.ONE_HUNDRED;
    }

    public int getCoins() {
        return value % Constant.ONE_HUNDRED;
    }

    public Byn(Byn byn) {
        this(byn.value);
    }

    public Byn add(Byn byn) {
        value += byn.value;
        return this;
    }

    public Byn sub(Byn byn) {
        value -= byn.value;
        return this;
    }

    public Byn mul(int k) {
        value *= k;
        return this;
    }

    public Byn mul(double d) {
        return mul(d, RoundMethod.ROUND, 0);
    }

    public Byn mul(double k, RoundMethod roundMethod, int d) {
        value = roundMethod.round(value * k, d);
        return this;
    }

    @Override
    public String toString() {
        return String.format(Constant.FORMAT_STRING_TO_BYN, value / Constant.ONE_HUNDRED, value % Constant.ONE_HUNDRED);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Byn byn = (Byn) o;
        return value == byn.value;
    }

    @Override
    public int hashCode() {
        return value;
    }

    @Override
    public int compareTo(Byn byn) {
        return value - byn.value;
    }
}
