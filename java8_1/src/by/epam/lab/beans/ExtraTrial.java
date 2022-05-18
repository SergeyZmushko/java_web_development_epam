package by.epam.lab.beans;

import by.epam.lab.utils.Constants;

public class ExtraTrial extends Trial {
    private final int mark3;
    private static final int PASS_EXTRA_TRIAL = 60;

    public ExtraTrial(String name, int mark1, int mark2, int mark3) {
        super(name, mark1, mark2);
        this.mark3 = mark3;
    }

    public boolean isPassed() {
        return super.isPassed() && mark3 >= PASS_EXTRA_TRIAL;
    }

    protected String fieldsToString() {
        return super.fieldsToString() + Constants.DELIMITER + mark3;
    }
}
