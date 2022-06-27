package by.epam.lab;

import by.epam.lab.beans.Trial;
import by.epam.lab.exceptions.ParseDataException;
import by.epam.lab.services.*;
import by.epam.lab.utils.Data;
import by.epam.lab.utils.Reader;
import by.epam.lab.utils.Writer;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.*;
import java.util.stream.IntStream;


import static by.epam.lab.utils.Constants.*;

import static by.epam.lab.utils.Constants.EXCEPTION;

public class Runner {
    public static void main(String[] args) {
        try {
            int MAX_PRODUCERS_NUMBER_VALUE = Integer.parseInt(Data.getProperties(MAX_PRODUCERS_NUMBER));
            int MAX_CONSUMERS_NUMBER_VALUE = Integer.parseInt(Data.getProperties(MAX_CONSUMERS_NUMBER));
            String FOLDER_NAME_VALUE = Data.getProperties(FOLDER_NAME);
            int BUFFER_STR_LENGTH_VALUE = Integer.parseInt(Data.getProperties(BUFFER_STR_LENGTH));

            List<File> files = Reader.searchFiles(new File(FOLDER_NAME_VALUE));

            CountDownLatch latch = new CountDownLatch(files.size());

            BlockingQueue<String> strings = new LinkedBlockingQueue<>(BUFFER_STR_LENGTH_VALUE);
            Queue<Trial> trials = new LinkedBlockingQueue<>();

            ExecutorService producerExService = Executors.newFixedThreadPool(MAX_PRODUCERS_NUMBER_VALUE);
            ExecutorService consumerExService = Executors.newFixedThreadPool(MAX_CONSUMERS_NUMBER_VALUE);

            files.forEach(file -> producerExService.execute(new Producer(file, latch, strings)));

            IntStream.range(0, MAX_CONSUMERS_NUMBER_VALUE)
                    .forEach(consumer -> consumerExService.execute(new Consumer(trials, strings)));

            new Thread(new Writer(trials)).start();

            latch.await();

            for (int i = 0; i < MAX_CONSUMERS_NUMBER_VALUE; i++) {
                strings.put(DONE);
            }

            Writer.stopWriter();

            producerExService.shutdown();
            consumerExService.shutdown();
        } catch (InterruptedException ignored) {
            //the thread should not be interrupted
            System.err.println(EXCEPTION + ignored.getMessage());
        } catch (IOException e) {
            System.err.println(WRONG_DATA + e.getMessage());
            throw new ParseDataException(e);
        }
    }
}
