package by.epam.lab;

public abstract class Item {
    private String name;

    public Item(){
        this.name = null;
    }

    public Item(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    protected abstract Byn getCost();

    public String fieldsToString(){
        return name;
    }

    public String toString(){
        return fieldsToString();
    }
}
