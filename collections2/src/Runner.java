
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
                int len = (int) Math.round(Math.sqrt((Double.parseDouble(mas[INDEX_ONE]) - Double.parseDouble(mas[INDEX_THREE])) *
                        (Double.parseDouble(mas[INDEX_ONE]) - Double.parseDouble(mas[INDEX_THREE])) +
                                (Double.parseDouble(mas[INDEX_TWO]) - Double.parseDouble(mas[INDEX_FOUR])) *
                                        (Double.parseDouble(mas[INDEX_TWO]) - Double.parseDouble(mas[INDEX_FOUR]))));
                if (numLenMap.containsKey(len)){
                    int num = numLenMap.get(len) + 1;
                    numLenMap.put(len, num);
                }else {
                    numLenMap.put(len, 1);
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
