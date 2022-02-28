package by.epam.lab.beans;

import by.epam.lab.exceptions.NegativeArgumentException;

public class Byn implements Comparable<Byn> {
    private final int value;
    private final static String VALUE_FORMAT = "%d.%02d";
    private final static String WRONG_VALUE_BYN = "wrong value for Byn: ";
    private final static String WRONG_VALUE_RUBS = "wrong value rubs: ";
    private final static String WRONG_VALUE_COINS = "wrong value coins: ";

    public Byn(int value) {
        if (value < 0) {
            throw new NegativeArgumentException(WRONG_VALUE_BYN + value);
        }
        this.value = value;
    }

    public Byn() {
        this(0);
    }

    public Byn(Byn byn) {
        this(byn.value);
    }

    public Byn(int rubs, int kops) {
        this(getValidValue(rubs, kops));
    }

    public Byn(String strKops) {
        this(Integer.parseInt(strKops));
    }

    private static int getValidValue(int rubs, int coins) {
        if (rubs < 0) {
            throw new NegativeArgumentException(WRONG_VALUE_RUBS + rubs);
        }
        if (coins < 0 || coins >= 100) {
            throw new NegativeArgumentException(WRONG_VALUE_COINS + coins);
        }
        return 100 * rubs + coins;
    }

    public int getValue() {
        return value;
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
