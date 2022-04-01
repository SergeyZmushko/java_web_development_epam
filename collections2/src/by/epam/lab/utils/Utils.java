package by.epam.lab.utils;

import by.epam.lab.enums.RoundMethod;

public class Utils {
    public static int lengthCalculate(String x1, String y1, String x2, String y2, RoundMethod roundMethod, int d){
        double a = Math.abs(Double.parseDouble(x1) - Double.parseDouble(x2));
        double b = Math.abs(Double.parseDouble(y1) - Double.parseDouble(y2));
        return roundMethod.round(Math.sqrt(a * a + b * b), d);
    }
}
