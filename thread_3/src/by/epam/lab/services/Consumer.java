package by.epam.lab.services;

import by.epam.lab.beans.Trial;
import by.epam.lab.utils.Constants;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;

import static by.epam.lab.utils.Constants.*;

public class Consumer implements Runnable {
    private final Queue<Trial> trials;
    private final BlockingQueue<String> strings;

    public Consumer(Queue<Trial> trials, BlockingQueue<String> strings) {
        this.trials = trials;
        this.strings = strings;
    }

    public void run() {
        while (true) {
            try {
                String result = strings.take();
                if (DONE.equals(result)) {
                    break;
                }
                Trial trial = new Trial(result.split(Constants.DELIMITER));
                if (trial.isPassed()) {
                    trials.add(trial);
                }
            } catch (InterruptedException ignored) {
                //the thread should not be interrupted
                System.err.println(EXCEPTION + ignored.getMessage());
            }
        }
    }
}
