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

    public Trial (String name, String mark1, String mark2){
        this(name, Integer.parseInt(mark1), Integer.parseInt(mark2));
    }

    public Trial(String[] str){
        this(str[0], str[1], str[2]);
    }

    public Trial(Trial trial) {
        this(trial.name, trial.mark1, trial.mark2);
    }

    public Trial getCopy() {
        return new Trial(this);
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

    public void clearMarks() {
        mark1 = 0;
        mark2 = 0;
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
