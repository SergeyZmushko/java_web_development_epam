package by.epam.lab.beans;

import by.epam.lab.utils.Constants;

public class ExtraTrial extends Trial {
    private static final int PASS_EXTRA_TRIAL = 60;
    private int mark3;

    public ExtraTrial(String name, int mark1, int mark2, int mark3) {
        super(name, mark1, mark2);
        this.mark3 = mark3;
    }

    @Override
    public Trial getCopy() {
        return new ExtraTrial(getName(), getMark1(), getMark2(), mark3);
    }

    public void setMark3(int mark3) {
        this.mark3 = mark3;
    }

    @Override
    public void clearMarks() {
        super.clearMarks();
        setMark3(0);
    }

    @Override
    public boolean isPassed() {
        return super.isPassed() && mark3 >= PASS_EXTRA_TRIAL;
    }

    @Override
    protected String fieldsToString() {
        return super.fieldsToString() + Constants.DELIMITER + mark3;
    }
}
