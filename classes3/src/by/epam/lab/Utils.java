package by.epam.lab;

public class Utils {
    public static String fromPennyToByn(int penny) {
        return String.format("%d.%02d", penny / 100, penny % 100);
    }
}
