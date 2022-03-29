import by.epam.lab.bean.Dot;
import by.epam.lab.bean.Segment;
import by.epam.lab.bean.SegmentsInfo;
import static by.epam.lab.utils.Constants.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Runner {
    public static void main(String[] args) {
        List<SegmentsInfo> segmentsInfoList = new ArrayList<>();
        try (Scanner sc = new Scanner(new FileReader(FILE_NAME))) {
            while (sc.hasNextLine()) {
                String[] mas = sc.nextLine().split(REGEX_SPLIT);
                Segment segment = new Segment(new Dot(mas[1], mas[2]), new Dot(mas[3], mas[4]));
                int result = Collections.binarySearch(segmentsInfoList, new SegmentsInfo(segment));
                if (result < 0){
                    segmentsInfoList.add(new SegmentsInfo(segment));
                }else{
                    segmentsInfoList.get(result).increase();
                }
            }
            segmentsInfoList.sort(new Comparator<SegmentsInfo>() {
                @Override
                public int compare(SegmentsInfo o1, SegmentsInfo o2) {
                    return o2.getNumber() - o1.getNumber();
                }
            });
            System.out.println(segmentsInfoList);
        } catch (FileNotFoundException e) {
            System.out.println(FILE_NOT_FOUND);
        }
    }
}
