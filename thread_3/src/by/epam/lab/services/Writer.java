package by.epam.lab.services;

import by.epam.lab.beans.Trial;
import by.epam.lab.exceptions.AddToFileException;
import by.epam.lab.utils.Data;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

import static by.epam.lab.utils.Constants.*;
import static by.epam.lab.utils.Constants.EXCEPTION;

public class Writer implements Runnable {
    private final Queue<Trial> trials;
    private volatile boolean isStopRequested = false;

    public Writer(Queue<Trial> trials) {
        this.trials = trials;
    }

    @Override
    public void run() {
        try (FileWriter file = new FileWriter((Data.getProperties(RESULT_FILE_NAME)), true)) {
            while (!isStopRequested || !trials.isEmpty()) {
                try {
                    Trial trial = trials.poll();
                    if (trial != null) {
                        file.append(String.format(FORMAT_CSV, trial.getName(), trial.getMark1(), trial.getMark2()));
                    } else {
                        TimeUnit.MILLISECONDS.sleep(50);
                    }
                } catch (InterruptedException ignored) {
                    //the thread should not be interrupted
                    System.err.println(EXCEPTION + ignored.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println(EXCEPTION + e.getMessage());
            throw new AddToFileException(e);
        }
    }

    public void stopWriter() {
        isStopRequested = true;
    }
}
