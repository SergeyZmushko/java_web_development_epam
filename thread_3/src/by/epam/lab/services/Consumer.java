package by.epam.lab.services;

import by.epam.lab.beans.Trial;
import by.epam.lab.utils.Constants;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;

import static by.epam.lab.utils.Constants.*;

public class Consumer implements Runnable {
    private final Queue<Trial> storageBuffer;
    private final BlockingQueue<String> stringBuffer;

    public Consumer(Queue<Trial> storageBuffer, BlockingQueue<String> stringBuffer) {
        this.storageBuffer = storageBuffer;
        this.stringBuffer = stringBuffer;
    }

    public void run() {
        while (true) {
            try {
                String result = stringBuffer.take();
                if (DONE.equals(result)) {
                    break;
                }
                Trial trial = new Trial(result.split(Constants.DELIMITER));
                if (trial.isPassed()) {
                    storageBuffer.add(trial);
                }
            } catch (InterruptedException ignored) {
                //the thread should not be interrupted
                System.err.println(ADD_TO_FILE_EXCEPTION + ignored.getMessage());
            }
        }
    }
}
