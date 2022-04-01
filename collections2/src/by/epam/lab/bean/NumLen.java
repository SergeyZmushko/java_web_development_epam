package by.epam.lab.bean;

import static by.epam.lab.utils.Constants.*;


public class NumLen {
    private final int len;
    private int num;

    public NumLen(int len){
        this.len = len;
        num = ONE;
    }

    public int getLen() {
        return len;
    }

    public int getNum() {
        return num;
    }

    public int hashCode(){
        return PRIME * ONE + len;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final NumLen other = (NumLen) obj;
        if (len != other.len) {
            return false;
        }
        other.num++;
        return true;
    }

    public String toString(){
        return len + SPLITTER + num;
    }
}
