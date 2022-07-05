package by.epam.lab;

import by.epam.lab.beans.Trial;
import by.epam.lab.exceptions.AwaitException;
import by.epam.lab.services.*;
import by.epam.lab.utils.Data;
import by.epam.lab.utils.Reader;
import by.epam.lab.services.Writer;

import java.io.File;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.*;
import java.util.stream.IntStream;

import static by.epam.lab.utils.Constants.*;

public class Runner {
    public static void main(String[] args) {
        int MAX_PRODUCERS_NUMBER_VALUE = Integer.parseInt(Data.getProperties(MAX_PRODUCERS_NUMBER));
        int MAX_CONSUMERS_NUMBER_VALUE = Integer.parseInt(Data.getProperties(MAX_CONSUMERS_NUMBER));
        String FOLDER_NAME_VALUE = Data.getProperties(FOLDER_NAME);
        int BUFFER_STR_LENGTH_VALUE = Integer.parseInt(Data.getProperties(BUFFER_STR_LENGTH));

        List<File> files = Reader.searchFiles(new File(FOLDER_NAME_VALUE));

        CountDownLatch latch = new CountDownLatch(files.size());

        BlockingQueue<String> stringBuffer = new LinkedBlockingQueue<>(BUFFER_STR_LENGTH_VALUE);
        Queue<Trial> storageBuffer = new ConcurrentLinkedDeque<>();

        ExecutorService producerExService = Executors.newFixedThreadPool(MAX_PRODUCERS_NUMBER_VALUE);
        ExecutorService consumerExService = Executors.newFixedThreadPool(MAX_CONSUMERS_NUMBER_VALUE);
        Writer writer = new Writer(storageBuffer);

        files.forEach(file -> producerExService.execute(new Producer(file, latch, stringBuffer)));

        IntStream.range(0, MAX_CONSUMERS_NUMBER_VALUE)
                .forEach(consumer -> consumerExService.execute(new Consumer(storageBuffer, stringBuffer)));

        new Thread(writer).start();

        try {
            latch.await();
        } catch (InterruptedException e) {
            System.err.println(AWAIT_EXCEPTION + e.getMessage());
            throw new AwaitException(e);
        }

        IntStream.range(0, MAX_CONSUMERS_NUMBER_VALUE)
                .forEach(done -> stringBuffer.add(DONE));

        writer.stopWriter();

        producerExService.shutdown();
        consumerExService.shutdown();
    }
}

