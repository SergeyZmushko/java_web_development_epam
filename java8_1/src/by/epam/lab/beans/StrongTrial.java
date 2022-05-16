package by.epam.lab.beans;

public class StrongTrial extends Trial {

    public StrongTrial(String name, int mark1, int mark2) {
        super(name, mark1, mark2);
    }

    protected int result() {
        return getMark1() / 2 + getMark2();
    }

    public boolean isPassed() {
        return result() >= PASS_MARK;
    }
}
