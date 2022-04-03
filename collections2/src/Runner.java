
import by.epam.lab.comparator.NumComparator;

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
                int num = numLenMap.get(len) != null ? numLenMap.get(len) + 1 : 1;
                numLenMap.put(len, num);
            }
            List<Map.Entry<Integer, Integer>> numLenList = new ArrayList<>(numLenMap.entrySet());
            Collections.sort(numLenList, new NumComparator());
            for (Map.Entry<Integer, Integer> entry : numLenList) {
                System.out.println(entry.getKey() + SEPARATOR + entry.getValue());
            }
        } catch (FileNotFoundException e) {
            System.out.println(FILE_NOT_FOUND);
        }
    }
}
