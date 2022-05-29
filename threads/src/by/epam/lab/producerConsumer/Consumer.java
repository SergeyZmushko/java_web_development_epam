package by.epam.lab.producerConsumer;

import by.epam.lab.beans.Trial;

import static by.epam.lab.utils.Constants.GOT;

public class Consumer implements Runnable {
    private final Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        synchronized (buffer) {
            for (Trial trial = buffer.take(); trial != null; trial = buffer.take()) {
                System.out.println(GOT + trial);
            }
        }
    }
}
