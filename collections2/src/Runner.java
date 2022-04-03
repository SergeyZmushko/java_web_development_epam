import by.epam.lab.enums.RoundMethod;
import by.epam.lab.utils.Utils;

import static by.epam.lab.utils.Constants.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Runner {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(new FileReader(FILE_NAME))) {
            List<int[]> numLenList = new ArrayList<>();
            while (sc.hasNext()) {
                String[] mas = sc.nextLine().split(REGEX_SPLIT);
                int len = Utils.lengthCalculate(mas[1], mas[2], mas[3], mas[4], RoundMethod.ROUND, 0);
                int[] numLen = new int[2];
                numLen[0] = len;
                numLen[1] = 1;
                numLenList.add(numLen);
                for (int i = 0; i <= numLenList.size() - 1; i++) {
                    for (int j = i + 1; j < numLenList.size(); j++) {
                        if (numLenList.get(i)[0] == numLenList.get(j)[0]) {
                            numLenList.get(i)[1]++;
                            numLenList.remove(numLenList.get(j));
                        }
                    }
                }
            }
            Collections.sort(numLenList, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o2[1] - o1[1];
                }
            });
            for (int[] element : numLenList) {
                System.out.println(Arrays.toString(element));
            }
        } catch (FileNotFoundException e) {
            System.out.println(FILE_NOT_FOUND);
        }
    }
}
