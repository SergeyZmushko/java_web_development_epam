package by.epam.lab.producerConsumer;

import by.epam.lab.beans.Trial;

import static by.epam.lab.utils.Constants.EXCEPTION;

public class Buffer {
    private Trial trial;
    private boolean empty = true;

    public synchronized Trial take() {
        while (empty) {
            try {
                wait();
            } catch (InterruptedException ignored) {
                //the thread should not be interrupted
                System.err.println(EXCEPTION + ignored);
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
                //the thread should not be interrupted
                System.err.println(EXCEPTION + ignored);
            }
        }
        empty = false;
        this.trial = trial;
        notifyAll();
    }
}
