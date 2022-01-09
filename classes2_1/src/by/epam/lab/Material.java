package by.epam.lab;

public enum Material {
    STEEL( 7850.0),
    COPPER( 8500.0);

    private final double density;

    Material(double density) {
        this.density = density;
    }

    public double getDensity() {
        return density;
    }

    public String getName(){
        return name().toLowerCase();
    }

    public String toString() {
        return getName() + ";" + getDensity();
    }
}