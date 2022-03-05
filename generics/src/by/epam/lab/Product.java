package by.epam.lab;

public class Product extends Item {
    private final Byn price;

    public Product(String name, Byn price) {
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

    public String fieldsToString() {
        return super.fieldsToString() + Constant.SEPARATOR + price;
    }
}
