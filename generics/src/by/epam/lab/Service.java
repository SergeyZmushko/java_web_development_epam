package by.epam.lab;

public class Service extends Item {
    private Byn totalCost;
    private double numberUsers;

    public Service(String name, Byn totalCost, double numberUsers){
        super(name);
        this.totalCost = totalCost;
        this.numberUsers = numberUsers;
    }

    @Override
    protected Byn getCost() {
        return totalCost.divide(numberUsers, RoundMethod.ROUND, 0);
    }

    public String fieldsToString(){
        return super.fieldsToString() + ";" + totalCost + ";" + numberUsers;
    }
}
