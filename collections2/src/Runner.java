
import by.epam.lab.comparator.NumMapComparator;

import static by.epam.lab.utils.Constants.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Runner {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(new FileReader(FILE_NAME))) {
            Map<Integer, Integer> numLenMap = new HashMap<>();
            while (sc.hasNext()) {
                String[] mas = sc.nextLine().split(REGEX_SPLIT);
                double x1 = Double.parseDouble(mas[INDEX_X1]);
                double x2 = Double.parseDouble(mas[INDEX_X2]);
                double y1 = Double.parseDouble(mas[INDEX_Y1]);
                double y2 = Double.parseDouble(mas[INDEX_Y2]);
                int len = (int) Math.round(Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2)));
                Integer value = numLenMap.get(len);
                if (value == null) {
                    value = 0;
                }
                numLenMap.put(len, value + 1);
            }
            SortedMap<Integer, Integer> sortedMapNumLen = new TreeMap<>(new NumMapComparator(numLenMap));
            sortedMapNumLen.putAll(numLenMap);
            printCollection(sortedMapNumLen.entrySet());
        } catch (FileNotFoundException e) {
            System.out.println(FILE_NOT_FOUND);
        }
    }

    private static void printCollection(Collection<Map.Entry<Integer, Integer>> entrySet) {
        for (Map.Entry<Integer, Integer> pair : entrySet) {
            System.out.println(pair.getKey() + SPLITTER + pair.getValue());
        }
    }
}
