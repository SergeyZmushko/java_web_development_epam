package by.epam.lab.bean;

public class Mark {
    private final int a;
    private final int b;

    public Mark(int a, int b){
        this.a = a;
        this.b = b;
    }

    public Mark(String text){
        String[] txt = text.split(".");
        this.a = Integer.parseInt(txt[0]);
        this.b = Integer.parseInt(txt[1]);
    }

    public String toString(){
        return a + "." + b;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }
}
