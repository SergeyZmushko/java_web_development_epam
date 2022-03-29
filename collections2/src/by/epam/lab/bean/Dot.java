package by.epam.lab.bean;

import static by.epam.lab.utils.Constants.*;


public class Dot {
    private final double x;
    private final double y;

    public Dot(){
        this.x = 0.0;
        this.y = 0.0;
    }

    public Dot(double x, double y){
        this.x = x;
        this.y = y;
    }

    public Dot(String x, String y){
        this(Double.parseDouble(x), Double.parseDouble(y));
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public String toString(){
        return OPEN_BRACKET + x + SPLITTER + y + END_BRACKET;
    }
}
