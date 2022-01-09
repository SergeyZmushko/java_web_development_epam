package by.epam.lab;

public class Subject {
    private String name;
    private Material material;
    private double volume;

    public Subject() {

    }

    public Subject(String name, Material material, double volume) {
        this.name = name;
        this.material = material;
        this.volume = volume;
    }

    public String getName() {
        return name;
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
        return material.getDensity() * volume;
    }

    public String toString() {
        return name + ";" + material + ";" + volume + ";" + getMass();
    }

    public enum Material {
        STEEL("steel", 7850.0),
        COPPER("copper", 8500.0);

        private final String name;
        private final double density;

        Material() {
            this(null, 0.0);
        }

        Material(String name, double density) {
            this.name = name;
            this.density = density;
        }

        public double getDensity() {
            return density;
        }

        public String getName() {
            return name;
        }

        public String toString() {
            return name + ";" + density;
        }
    }
}
