package by.epam.lab.utils;

import by.epam.lab.beans.Trial;
import by.epam.lab.exceptions.AddToFileException;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;

import static by.epam.lab.utils.Constants.*;
import static by.epam.lab.utils.Constants.EXCEPTION;

public class Writer implements Runnable {
    private final Queue<Trial> trials;
    private static boolean isStopRequested = false;

    public Writer(Queue<Trial> trials) {
        this.trials = trials;
    }

    @Override
    public void run() {
        while (!isStopRequested || !trials.isEmpty()) {
            try (FileWriter file = new FileWriter((Data.getProperties(RESULT_FILE_NAME)), true)) {
                Trial trial = trials.poll();
                if (trial != null) {
                    file.append(String.format(FORMAT_CSV, trial.getName(), trial.getMark1(), trial.getMark2()));
                }else {
                    Thread.sleep(100);
                }
            } catch (IOException e) {
                System.err.println(EXCEPTION + e.getMessage());
                throw new AddToFileException(e);
            } catch (InterruptedException ignored) {
                //the thread should not be interrupted
                System.err.println(EXCEPTION + ignored.getMessage());
            }
        }
    }

    public static void stopWriter(){
        isStopRequested = true;
    }
}
