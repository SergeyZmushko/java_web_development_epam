package by.epam.lab;

import static by.epam.lab.utils.Constants.GOT;

public class Consumer implements Runnable {
    private final Drop drop;

    public Consumer(Drop drop) {
        this.drop = drop;
    }

    @Override
    public void run() {
        synchronized (drop) {
            while (drop.isEmpty()) {
                System.out.println(GOT + drop.take());
            }
        }
    }
}
