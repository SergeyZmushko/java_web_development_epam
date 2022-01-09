import by.epam.lab.Subject;

public class Runner {
    public static void main(String[] args) {
        Subject wire = new Subject("wire", Subject.Material.STEEL, 0.03);
        System.out.println(wire);
        wire.setMaterial(Subject.Material.COPPER);
        System.out.println("The wire mass is " + wire.getMass() + " kg.");
    }
}
