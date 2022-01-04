import by.epam.lab.Material;
import by.epam.lab.Subject;

public class Runner {
    public static void main(String[] args) {
        Material steel = new Material("steel", 7850.0);
        Subject wire = new Subject("steelWire", steel, 0.03);
        System.out.println(wire);
        Material cooper = new Material("cooper", 8500.0);
        wire.setMaterial(cooper);
        System.out.println("The wire mass = " + wire.getMass() + "kg.");
    }
}
