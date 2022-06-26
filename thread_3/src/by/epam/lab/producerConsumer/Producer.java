package by.epam.lab.producerConsumer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;

import static by.epam.lab.utils.Constants.*;

public class Producer implements Runnable {
    private final File file;
    private final CountDownLatch countDownLatch;
    private final BlockingQueue<String> strTrials;

    public Producer(File file, CountDownLatch countDownLatch, BlockingQueue<String> strTrials) {
        this.file = file;
        this.countDownLatch = countDownLatch;
        this.strTrials = strTrials;
    }

    public void run() {
        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                strTrials.put(sc.next());
            }
            strTrials.put(DONE);
            countDownLatch.countDown();
        } catch (FileNotFoundException e) {
            System.out.println(FILE_NOT_FOUND);
        } catch (InterruptedException e) {
            //the thread should not be interrupted
            System.err.println(EXCEPTION + e);
        }
    }
}
