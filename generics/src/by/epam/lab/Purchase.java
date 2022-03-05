package by.epam.lab;

public class Purchase {
    private final Item item;
    private final Number count;

    public Purchase(Item item, Number count) {
        this.item = item;
        this.count = count;
    }

    public Item getItem() {
        return item;
    }

    public Number getCount() {
        return count;
    }

    public Byn getPurchaseCost() {
        return item.getCost().mul(count.doubleValue(), RoundMethod.ROUND, 2);
    }

    public String toString() {
        return item + Constant.SEPARATOR + count;
    }
}
