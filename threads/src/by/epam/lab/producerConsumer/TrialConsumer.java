package by.epam.lab.producerConsumer;

import by.epam.lab.beans.Trial;
import by.epam.lab.utils.Constants;
import by.epam.lab.utils.Data;

import static by.epam.lab.utils.Constants.*;

import java.io.*;
import java.util.List;
import java.util.concurrent.*;


public class TrialConsumer implements Runnable {
    private final BlockingQueue<String> sharedQueue;
    private final List<Trial> bufferTrial;
    private final int maxConsumersNumbers;

    public TrialConsumer(BlockingQueue<String> sharedQueue, List<Trial> bufferTrial) throws IOException {
        this.bufferTrial = bufferTrial;
        this.sharedQueue = sharedQueue;
        this.maxConsumersNumbers = Integer.parseInt(Data.getProperties(MAX_CONSUMERS_NUMBER));
    }

    public int getMaxConsumersNumbers() {
        return maxConsumersNumbers;
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
                if ((trialStr = sharedQueue.take()).equals(DONE)) {
                    break;
                }
                Trial trial = new Trial(trialStr.split(Constants.DELIMITER));
                if (trial.isPassed()) {
                    bufferTrial.add(trial);
                    System.out.println(PUT + trialStr + " " + Thread.currentThread().getName());
                    Thread.sleep(2000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        recordList(bufferTrial);
    }

    private void recordList(List<Trial> trials) {
        String delimiter = ";";
        String separator = "\n";
        try (FileWriter file = new FileWriter(("src/by/epam/lab/allTests.csv"))){
            for (Trial trial : trials) {
                file.append(trial.getName());
                file.append(delimiter);
                file.append(String.valueOf(trial.getMark1()));
                file.append(delimiter);
                file.append(String.valueOf(trial.getMark2()));
                file.append(separator);
            }
        }catch (Exception e){
            System.out.println("Wrong");
        }
    }
}
