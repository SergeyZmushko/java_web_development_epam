package by.epam.lab.bean;

import by.epam.lab.enums.RoundMethod;
import static by.epam.lab.utils.Constants.*;

public class Segment {
    private final Dot dot1;
    private final Dot dot2;
    private final int length;

    public Segment(Dot dot1, Dot dot2){
        this.dot1 = dot1;
        this.dot2 = dot2;
        this.length = length(dot1, dot2, RoundMethod.ROUND, 0);
    }

    public int getLength() {
        return length;
    }

    public int length (Dot dot1, Dot dot2, RoundMethod roundMethod, int d) {
        double s1 = Math.abs(dot1.getX() - dot2.getX());
        double s2 = Math.abs(dot1.getY() - dot2.getY());
        return roundMethod.round(Math.sqrt(s1 * s1 + s2 * s2), d);
    }

    public String toString(){
        return dot1 + SPLITTER + dot2 + SPLITTER + length;
    }
}
