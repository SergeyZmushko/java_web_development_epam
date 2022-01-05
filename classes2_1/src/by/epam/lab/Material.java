package by.epam.lab;

public final class Material {
    private final String NAME;
    private final double DENSITY;

    public Material() {
        this(null, 0);
    }

    public Material(String NAME, double DENSITY) {
        this.NAME = NAME;
        this.DENSITY =  DENSITY;
    }

    public String getNAME() {
        return NAME;
    }

    public double getDENSITY() {
        return DENSITY;
    }

    public String toString() {
        return NAME + ";" + DENSITY;
    }
}
