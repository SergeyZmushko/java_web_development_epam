package by.epam.lab.bean;

import by.epam.lab.utils.Constants;

public class LenNum {
    private final int len;
    private final int num;

    public LenNum(int len, int num){
        this.len = len;
        this.num = num;
    }

    public int getLen() {
        return len;
    }

    public int getNum() {
        return num;
    }

    @Override
    public String toString() {
        return len + Constants.SPLITTER + num;
    }
}
