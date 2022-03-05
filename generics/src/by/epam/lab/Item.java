package by.epam.lab;

public abstract class Item {
    private final String name;

    public Item(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    protected abstract Byn getCost();

    public String fieldsToString() {
        return name;
    }

    public String toString() {
        return fieldsToString();
    }
}
