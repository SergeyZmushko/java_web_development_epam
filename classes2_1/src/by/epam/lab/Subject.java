package by.epam.lab;

public final class Subject {
    private final String NAME;
    private Material material;
    private double volume;

    public Subject() {
        this(null, null, 0.0);
    }

    public Subject(String NAME, Material material, double volume) {
        this.NAME = NAME;
        this.material = material;
        this.volume = volume;
    }

    public String getNAME() {
        return NAME;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getMass() {
        return material.getDENSITY() * volume;
    }

    public String toString() {
        return NAME + ";" + material + ";" + volume + ";" + getMass();
    }
}
