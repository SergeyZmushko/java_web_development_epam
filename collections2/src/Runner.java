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
                int len = Utils.lengthCalculate(mas[INDEX_ONE], mas[INDEX_TWO], mas[INDEX_THREE], mas[INDEX_FOUR], RoundMethod.ROUND, 0);
                int[] numLen = new int[MASS_SIZE];
                numLen[INDEX_ZERO] = len;
                numLen[INDEX_ONE] = 1;
                numLenList.add(numLen);
                for (int i = INDEX_ZERO; i < numLenList.size() - 1; i++) {
                    for (int j = i + 1; j < numLenList.size(); j++) {
                        if (numLenList.get(i)[INDEX_ZERO] == numLenList.get(j)[INDEX_ZERO]) {
                            numLenList.get(i)[INDEX_ONE]++;
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
