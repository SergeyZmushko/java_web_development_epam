package by.epam.lab.producerConsumer;

import by.epam.lab.beans.Trial;

import static by.epam.lab.utils.Constants.FAKE_TRIAL;
import static by.epam.lab.utils.Constants.GOT;

public class TrialConsumer implements Runnable {
    private final TrialBuffer trialBuffer;

    public TrialConsumer(TrialBuffer buffer) {
        this.trialBuffer = buffer;
    }

    @Override
    public void run() {
        synchronized (trialBuffer) {
            while (true) {
                Trial trial = trialBuffer.take();
                if (!trial.equals(FAKE_TRIAL)) {
                    System.out.println(GOT + trial);
                } else {
                    break;
                }
            }
        }
    }
}
