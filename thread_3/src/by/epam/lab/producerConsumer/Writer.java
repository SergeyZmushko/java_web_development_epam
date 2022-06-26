package by.epam.lab.producerConsumer;

import by.epam.lab.beans.Trial;
import by.epam.lab.utils.Data;

import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;

import static by.epam.lab.utils.Constants.*;
import static by.epam.lab.utils.Constants.EXCEPTION;

public class Writer implements Runnable {
    private final BlockingQueue<Trial> trials;
    private boolean flag = true;

    public Writer(BlockingQueue<Trial> trials) {
        this.trials = trials;
    }

    @Override
    public void run() {
        while (flag) {
            try (FileWriter file = new FileWriter((Data.getProperties(RESULT_FILE_NAME)))) {
                for (Trial trial : trials) {
                    file.append(String.format(FORMAT_CSV, trial.getName(), trial.getMark1(), trial.getMark2()));
                }
                flag = false;
            } catch (IOException e) {
                System.err.println(EXCEPTION + e);
            }
        }
    }
}
