package by.epam.lab.producerConsumer;

import by.epam.lab.beans.Trial;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import static by.epam.lab.utils.Constants.*;

public class TrialProducer implements Runnable {
    private final TrialBuffer trialBuffer;
    private final String path = FILE_NAME;

    public TrialProducer(TrialBuffer trialBuffer) {
        this.trialBuffer = trialBuffer;
    }

    @Override
    public void run() {
        synchronized (trialBuffer) {
            try (Scanner sc = new Scanner(new FileReader(path))) {
                while (sc.hasNextLine()) {
                    Trial trial = new Trial(sc.next().split(DELIMITER));
                    trialBuffer.put(trial);
                    System.out.println(PUT + trial);
                }
            } catch (FileNotFoundException e) {
                System.out.println(FILE_NOT_FOUND);
            } finally {
                trialBuffer.put(FAKE_TRIAL);
            }
        }
    }
}
