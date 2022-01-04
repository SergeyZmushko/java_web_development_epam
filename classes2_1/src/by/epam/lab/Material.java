package by.epam.lab;

public final class Material {
    private String name;
    private final double density;

    private Material(){
        density = 0;
    }

    public Material(String name, double density) {
        this.name = name;
        this.density = density;
    }

    public String getName() {
        return name;
    }

    public double getDensity() {
        return density;
    }

    public String toString(){
        return name + ";" + density;
    }
}
