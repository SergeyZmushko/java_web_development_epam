package by.epam.lab;

public class Service extends Item {
    private final Byn totalCost;
    private final int numberUsers;

    public Service(String name, Byn totalCost, int numberUsers) {
        super(name);
        this.totalCost = totalCost;
        this.numberUsers = numberUsers;
    }

    public int getNumberUsers() {
        return numberUsers;
    }

    @Override
    protected Byn getCost() {
        return totalCost.divide(numberUsers, RoundMethod.ROUND, 0);
    }

    public String fieldsToString() {
        return super.fieldsToString() + ";" + totalCost + ";" + numberUsers;
    }
}
