package by.epam.lab.comparator;

import java.util.Comparator;
import java.util.Map;

public class NumMapComparator implements Comparator<Integer> {
    private final Map<Integer, Integer> baseMap;

    public NumMapComparator(Map<Integer, Integer> baseMap) {
        this.baseMap = baseMap;
    }

    @Override
    public int compare(Integer num0, Integer num1) {
        return baseMap.get(num1) - baseMap.get(num0);
    }
}
