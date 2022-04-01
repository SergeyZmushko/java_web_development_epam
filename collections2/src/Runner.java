import by.epam.lab.bean.NumLen;
import by.epam.lab.enums.RoundMethod;
import by.epam.lab.utils.Utils;

import static by.epam.lab.utils.Constants.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Runner {
    public static void main(String[] args) {
        Set<NumLen> setNumLen = new HashSet<>();
        try (Scanner sc = new Scanner(new FileReader(FILE_NAME))) {
            while (sc.hasNext()) {
                String[] mas = sc.nextLine().split(REGEX_SPLIT);
                NumLen numLen = new NumLen(Utils.lengthCalculate(mas[1], mas[2], mas[3], mas[4], RoundMethod.ROUND, 0));
                setNumLen.add(numLen);
            }
            List<NumLen> listNumLen = new ArrayList<>(setNumLen);
            Collections.sort(listNumLen, new Comparator<NumLen>() {
                @Override
                public int compare(NumLen o1, NumLen o2) {
                    return o2.getNum() - o1.getNum();
                }
            });
            for (NumLen element : listNumLen){
                System.out.println(element);
            }
        } catch (FileNotFoundException e) {
            System.out.println(FILE_NOT_FOUND);
        }
    }
}
