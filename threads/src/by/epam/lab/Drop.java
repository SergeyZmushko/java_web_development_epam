package by.epam.lab;

import by.epam.lab.beans.Trial;

public class Drop {
    private Trial trial;
    private boolean empty = true;

    public boolean isEmpty() {
        return empty;
    }

    public synchronized Trial take() {
        while (empty) {
            try {
                wait();
            } catch (InterruptedException ignored) {}
        }
        empty = true;
        notifyAll();
        return trial;
    }

    public synchronized void put(Trial trial) {
        while (!empty) {
            try {
                wait();
            } catch (InterruptedException ignored) {}
        }
        empty = false;
        this.trial = trial;
        notifyAll();
    }
}
