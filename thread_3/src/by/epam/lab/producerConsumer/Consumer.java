package by.epam.lab.producerConsumer;

import by.epam.lab.beans.Trial;
import by.epam.lab.utils.Constants;

import java.util.concurrent.BlockingQueue;

import static by.epam.lab.utils.Constants.*;

public class Consumer implements Runnable {
    private final BlockingQueue<Trial> trials;
    private final BlockingQueue<String> strings;

    public Consumer(BlockingQueue<Trial> trials, BlockingQueue<String> strings) {
        this.trials = trials;
        this.strings = strings;
    }

    public void run() {
        while (true) {
            try {
                String result = strings.take();
                if (result.equals(DONE)) {
                    break;
                }
                Trial trial = new Trial(result.split(Constants.DELIMITER));
                if (trial.isPassed()) {
                    trials.add(trial);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
