package by.epam.lab.producerConsumer;

import by.epam.lab.beans.Trial;
import by.epam.lab.utils.Constants;
import by.epam.lab.utils.Data;

import static by.epam.lab.utils.Constants.*;

import java.io.*;
import java.util.concurrent.BlockingQueue;


public class TrialConsumer implements Runnable {
    private final BlockingQueue<Trial> trials;
    private final BlockingQueue<String> strings;
    private final int maxConsumersNumber;

    public TrialConsumer(BlockingQueue<String> strings, BlockingQueue<Trial> trials) throws IOException {
        this.trials = trials;
        this.strings = strings;
        this.maxConsumersNumber = Integer.parseInt(Data.getProperties(MAX_CONSUMERS_NUMBER));
    }

    public int getMaxConsumersNumber() {
        return maxConsumersNumber;
    }

    @Override
    public void run() {
        String trialStr = null;
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        while (true) {
            try {
                if ((trialStr = strings.take()).equals(DONE)) {
                    break;
                }
                Trial trial = new Trial(trialStr.split(Constants.DELIMITER));
                if (trial.isPassed()) {
                    trials.add(trial);
                    System.out.println(PUT + trialStr + BLANK + Thread.currentThread().getName());
                    Thread.sleep(2000);
                }
            } catch (InterruptedException e) {
                //the thread should not be interrupted
                System.err.println(EXCEPTION + e);
            }
        }
    }
}
