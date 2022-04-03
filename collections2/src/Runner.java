
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
                int len = (int) Math.round(Math.sqrt((Double.parseDouble(mas[INDEX_X1]) - Double.parseDouble(mas[INDEX_X2])) *
                        (Double.parseDouble(mas[INDEX_X1]) - Double.parseDouble(mas[INDEX_X2])) +
                        (Double.parseDouble(mas[INDEX_Y1]) - Double.parseDouble(mas[INDEX_Y2])) *
                                (Double.parseDouble(mas[INDEX_Y1]) - Double.parseDouble(mas[INDEX_Y2]))));
                if (numLenMap.containsKey(len)) {
                    numLenMap.put(len, numLenMap.get(len) + ONE);
                } else {
                    numLenMap.put(len, ONE);
                }
            }
            List<Map.Entry<Integer, Integer>> numLenList = new ArrayList<>(numLenMap.entrySet());
            Collections.sort(numLenList, new Comparator<Map.Entry<Integer, Integer>>() {
                @Override
                public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                    return o2.getValue() - o1.getValue();
                }
            });
            for (Map.Entry<Integer, Integer> entry : numLenList) {
                System.out.println(entry.getKey() + SEPARATOR + entry.getValue());
            }
        } catch (FileNotFoundException e) {
            System.out.println(FILE_NOT_FOUND);
        }
    }
}
