package by.epam.lab.services;

import by.epam.lab.beans.Trial;
import by.epam.lab.exceptions.AddToFileException;
import by.epam.lab.exceptions.ThreadSleepException;
import by.epam.lab.utils.Data;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

import static by.epam.lab.utils.Constants.*;
import static by.epam.lab.utils.Constants.ADD_TO_FILE_EXCEPTION;

public class Writer implements Runnable {
    private final Queue<Trial> storageBuffer;
    private volatile boolean isStopRequested = false;

    public Writer(Queue<Trial> storageBuffer) {
        this.storageBuffer = storageBuffer;
    }

    @Override
    public void run() {
        try (FileWriter file = new FileWriter((Data.getProperties(RESULT_FILE_NAME)))) {
            while (!isStopRequested || !storageBuffer.isEmpty()) {
                Trial trial = storageBuffer.poll();
                if (trial != null) {
                    file.append(String.format(FORMAT_CSV, trial.getName(), trial.getMark1(), trial.getMark2()));
                } else {
                    try {
                        TimeUnit.MILLISECONDS.sleep(50);
                    }catch (InterruptedException e){
                        System.err.println(THREAD_SLEEP_EXCEPTION + e.getMessage());
                        throw new ThreadSleepException(e);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println(ADD_TO_FILE_EXCEPTION + e.getMessage());
            throw new AddToFileException(e);
        }
    }

    public void stopWriter() {
        isStopRequested = true;
    }
}
