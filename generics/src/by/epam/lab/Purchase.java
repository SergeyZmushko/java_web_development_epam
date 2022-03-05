package by.epam.lab;

public class Purchase {
    private Item item;
    private double count;

    public Purchase(Item item, double count){
        this.item = item;
        this.count = count;
    }

    public Item getItem() {
        return item;
    }

    public double getCount() {
        return count;
    }

    public Byn getPurchaseCost(){
        return item.getCost().mul(count, RoundMethod.ROUND, 2);
    }

    public String toString(){
        return item + ";" + count;
    }
}
