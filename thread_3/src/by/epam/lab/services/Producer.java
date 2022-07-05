package by.epam.lab.services;

import by.epam.lab.exceptions.FindFileException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;

import static by.epam.lab.utils.Constants.*;

public class Producer implements Runnable {
    private final File file;
    private final CountDownLatch countDownLatch;
    private final BlockingQueue<String> stringBuffer;

    public Producer(File file, CountDownLatch countDownLatch, BlockingQueue<String> stringBuffer) {
        this.file = file;
        this.countDownLatch = countDownLatch;
        this.stringBuffer = stringBuffer;
    }

    public void run() {
        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                try {
                    stringBuffer.put(sc.next());
                } catch (InterruptedException ignored) {
                    //the thread should not be interrupted
                    System.err.println(ADD_TO_FILE_EXCEPTION + ignored.getMessage());
                }
            }
        } catch (FileNotFoundException e) {
            throw new FindFileException(FILE_NOT_FOUND);
        } finally {
            countDownLatch.countDown();
        }
    }
}
