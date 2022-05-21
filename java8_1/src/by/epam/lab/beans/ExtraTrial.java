package by.epam.lab.beans;

import by.epam.lab.utils.Constants;

public class ExtraTrial extends Trial {
    private static final int PASS_EXTRA_TRIAL = 60;
    private int mark3;

    public ExtraTrial(String name, int mark1, int mark2, int mark3) {
        super(name, mark1, mark2);
        this.mark3 = mark3;
    }

    public ExtraTrial(ExtraTrial extraTrial) {
        super(extraTrial);
        this.mark3 = extraTrial.mark3;
    }

    @Override
    public ExtraTrial getCopy() {
        return new ExtraTrial(this);
    }

    @Override
    public void clearMarks() {
        super.clearMarks();
        mark3 = 0;
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
