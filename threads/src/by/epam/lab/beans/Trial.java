package by.epam.lab.beans;

import static by.epam.lab.utils.Constants.*;

public class Trial {
    private final String name;
    private final int mark1;
    private final int mark2;
    private static final int PASS_MARK = 120;

    public Trial(String name, int mark1, int mark2) {
        this.name = name;
        this.mark1 = mark1;
        this.mark2 = mark2;
    }

    public Trial(){
        this(null, 0, 0);
    }

    public Trial(String name, String mark1, String mark2) {
        this(name, Integer.parseInt(mark1), Integer.parseInt(mark2));
    }

    public Trial(String[] str) {
        this(str[NAME_INDEX], str[MARK1_INDEX], str[MARK2_INDEX]);
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

    protected int result() {
        return mark1 + mark2;
    }

    public boolean isPassed() {
        return result() >= PASS_MARK;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : NAME_NULL_HASH;
        result = PRIME_NUMBER * result + mark1;
        result = PRIME_NUMBER * result + mark2;
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Trial trial = (Trial) o;

        if (mark1 != trial.mark1) return false;
        if (mark2 != trial.mark2) return false;
        return name != null ? name.equals(trial.name) : trial.name == null;
    }

    public String toString() {
        return getClass().getSimpleName() + DELIMITER + name + DELIMITER + mark1 + DELIMITER + mark2 + DELIMITER + isPassed();
    }
}
