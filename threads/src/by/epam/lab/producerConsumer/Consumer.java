package by.epam.lab.producerConsumer;

import by.epam.lab.beans.Trial;

import static by.epam.lab.utils.Constants.GOT;

public class Consumer implements Runnable {
    private final Drop drop;

    public Consumer(Drop drop) {
        this.drop = drop;
    }

    @Override
    public void run() {
        synchronized (drop) {
            for (Trial trial = drop.take(); trial != null; trial = drop.take()) {
                System.out.println(GOT + trial);
            }
        }
    }
}
