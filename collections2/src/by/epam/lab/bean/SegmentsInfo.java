package by.epam.lab.bean;
import static by.epam.lab.utils.Constants.*;

public class SegmentsInfo {
    private final int length;
    private int number;

    public SegmentsInfo(Segment segment){
        this.length = segment.getLength();
        number = 1;
    }

    public int getLength() {
        return length;
    }

    public int getNumber(){
        return number;
    }

    public void increase(){
        number++;
    }

    public String toString(){
        return OPEN_BRACKET + length + SPLITTER + number + END_BRACKET;
    }
}
