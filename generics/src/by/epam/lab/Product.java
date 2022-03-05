package by.epam.lab;

public class Product extends Item {
    private Byn price;

    public Product(){
        super(null);
    }

    public Product(String name, Byn price){
        super(name);
        this.price = price;
    }

    public Byn getPrice() {
        return price;
    }

    @Override
    protected Byn getCost() {
        return price;
    }

    public String fieldsToString(){
        return super.fieldsToString() + ";" + price;
    }
}
