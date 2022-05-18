package by.epam.lab.beans;

import by.epam.lab.utils.Constants;

public class StrongTrial extends Trial {

    public StrongTrial(String name, int mark1, int mark2) {
        super(name, mark1, mark2);
    }

    protected int result() {
        return getMark1() / Constants.FORMAT_MARK + getMark2();
    }

    public boolean isPassed() {
        return result() >= PASS_MARK;
    }
}
