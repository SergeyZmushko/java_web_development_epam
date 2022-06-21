package by.epam.lab.producerConsumer;

import by.epam.lab.beans.Trial;
import by.epam.lab.utils.Data;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.BlockingQueue;

import static by.epam.lab.utils.Constants.*;
import static by.epam.lab.utils.Constants.EXCEPTION;

public class Writer implements Runnable{
    private final BlockingQueue<Trial> trials;

    public Writer(BlockingQueue<Trial> trials){
        this.trials = trials;
    }

    @Override
    public void run() {
        try (FileWriter file = new FileWriter((Data.getProperties(RESULT_FILE_NAME)))){
            for (Trial trial : trials) {
                file.append(trial.getName());
                file.append(DELIMITER);
                file.append(String.valueOf(trial.getMark1()));
                file.append(DELIMITER);
                file.append(String.valueOf(trial.getMark2()));
                file.append(SEPARATOR);
            }
        }catch (IOException e){
            System.err.println(EXCEPTION + e);
        }
    }
}
