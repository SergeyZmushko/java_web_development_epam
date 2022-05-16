package by.epam.lab.beans;

public class LightTrial extends Trial{
    private static final int PASS_TEST_1 = 70;
    private static final int PASS_TEST_2 = 60;

    public LightTrial(String name, int mark1, int mark2) {
        super(name, mark1, mark2);
    }

    public boolean isPassed(){
        return getMark1() >= PASS_TEST_1 && getMark2() >= PASS_TEST_2;
    }

}
