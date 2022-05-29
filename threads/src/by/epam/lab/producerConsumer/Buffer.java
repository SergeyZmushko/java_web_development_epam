package by.epam.lab.producerConsumer;

import by.epam.lab.beans.Trial;

public class Buffer {
    private Trial trial;
    private boolean empty = true;

    public synchronized Trial take() {
        while (empty) {
            try {
                wait();
            } catch (InterruptedException ignored) {
                System.out.println("Interrupted, closing...");
            }
        }
        empty = true;
        notifyAll();
        return trial;
    }

    public synchronized void put(Trial trial) {
        while (!empty) {
            try {
                wait();
            } catch (InterruptedException ignored) {
            }
        }
        empty = false;
        this.trial = trial;
        notifyAll();
    }
}
