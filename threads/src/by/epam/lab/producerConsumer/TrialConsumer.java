package by.epam.lab.producerConsumer;

import by.epam.lab.beans.Trial;
import by.epam.lab.utils.Constants;
import by.epam.lab.utils.Data;

import static by.epam.lab.utils.Constants.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class TrialConsumer implements Runnable {
    private final Buffer buffer;
    private final List<Trial> bufferTrial = new ArrayList<>();
    private final int maxConsumersNumber;

    public TrialConsumer(Buffer buffer) throws IOException {
        this.buffer = buffer;
        this.maxConsumersNumber = Integer.parseInt(Data.getProperties(MAX_CONSUMERS_NUMBER));
    }

    public int getMaxConsumersNumber() {
        return maxConsumersNumber;
    }

    @Override
    public void run() {
        String trialStr = null;
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        while (true) {
            try {
                if ((trialStr = buffer.getSharedQueue().take()).equals(DONE)) {
                    break;
                }
                Trial trial = new Trial(trialStr.split(Constants.DELIMITER));
                if (trial.isPassed()) {
                    bufferTrial.add(trial);
                    System.out.println(PUT + trialStr + BLANK + Thread.currentThread().getName());
                    Thread.sleep(2000);
                }
            } catch (InterruptedException e) {
                //the thread should not be interrupted
                System.err.println(EXCEPTION + e);
            }
        }
        recordList(bufferTrial);
    }

    private void recordList(List<Trial> trials) {
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
