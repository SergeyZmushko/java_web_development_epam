package by.epam.lab;

import by.epam.lab.beans.Trial;
import by.epam.lab.producerConsumer.*;

import java.io.File;
import java.util.List;
import java.util.concurrent.*;

import static by.epam.lab.utils.Constants.*;

import static by.epam.lab.utils.Constants.EXCEPTION;

public class Runner {
    public static void main(String[] args) {
        List<File> files = Reader.searchFiles(new File(FOLDER_NAME_VALUE));

        CountDownLatch latch = new CountDownLatch(files.size());

        BlockingQueue<String> strings = new LinkedBlockingQueue<>(BUFFER_STR_LENGTH_VALUE);
        BlockingQueue<Trial> trials = new LinkedBlockingQueue<>();

        ExecutorService pes = Executors.newFixedThreadPool(MAX_PRODUCERS_NUMBER_VALUE);
        ExecutorService ces = Executors.newFixedThreadPool(MAX_CONSUMERS_NUMBER_VALUE);

        files.forEach((file) -> pes.submit(new Producer(file, latch, strings)));
        pes.shutdown();

        for (int i = 0; i < files.size(); i++) {
            ces.submit(new Consumer(trials, strings));
        }
        ces.shutdown();

        try {
            latch.await();
        } catch (InterruptedException e) {
            //the thread should not be interrupted
            System.err.println(EXCEPTION + e);
        }

        Thread writer = new Thread(new Writer(trials));
        writer.start();
    }
}
