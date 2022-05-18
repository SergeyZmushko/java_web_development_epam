package by.epam.lab.beans;

import static by.epam.lab.utils.Constants.*;

public class Trial {
    private final String name;
    private int mark1;
    private int mark2;
    protected static final int PASS_MARK = 120;

    public Trial(String name, int mark1, int mark2) {
        this.name = name;
        this.mark1 = mark1;
        this.mark2 = mark2;
    }

    public void setMark1(int mark1) {
        this.mark1 = mark1;
    }

    public void setMark2(int mark2) {
        this.mark2 = mark2;
    }

    public String getName() {
        return name;
    }

    public int getMark1() {
        return mark1;
    }

    public int getMark2() {
        return mark2;
    }

    protected int result() {
        return mark1 + mark2;
    }

    public boolean isPassed() {
        return result() >= PASS_MARK;
    }

    protected String fieldsToString() {
        return getClass().getSimpleName() + DELIMITER + name + DELIMITER + mark1 + DELIMITER + mark2;
    }

    public String toString() {
        return fieldsToString() + DELIMITER + isPassed();
    }
}
