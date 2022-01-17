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

    public int sum (int value){
        return this.value + value;
    }

    public int difference(int value){
        return this.value - value;
    }

    public int multiplication (int value){
        return this.value * value;
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
