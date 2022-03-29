import by.epam.lab.bean.Dot;
import by.epam.lab.bean.Segment;
import by.epam.lab.bean.SegmentsInfo;
import static by.epam.lab.utils.Constants.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        List<SegmentsInfo> segmentsInfoList = new ArrayList<>();
        try (Scanner sc = new Scanner(new FileReader(FILE_NAME))) {
            while (sc.hasNextLine()) {
                String[] mas = sc.nextLine().split(REGEX_SPLIT);
                Segment segment = new Segment(new Dot(mas[1], mas[2]), new Dot(mas[3], mas[4]));
                boolean result = true;
                for (SegmentsInfo el : segmentsInfoList){
                    if (el.getLength() == segment.getLength()){
                        result = false;
                        el.increase();
                    }
                }
                if (result) {
                    segmentsInfoList.add(new SegmentsInfo(segment));
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
