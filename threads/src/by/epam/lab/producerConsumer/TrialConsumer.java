package by.epam.lab.producerConsumer;

import by.epam.lab.beans.Trial;

import static by.epam.lab.utils.Constants.GOT;

public class TrialConsumer implements Runnable {
    private final TrialBuffer trialBuffer;

    public TrialConsumer(TrialBuffer buffer) {
        this.trialBuffer = buffer;
    }

    @Override
    public void run() {
        synchronized (trialBuffer) {
            for (Trial trial = trialBuffer.take();
                 !trial.equals(new Trial("Abc", 20, 60));
                 trial = trialBuffer.take()) {
                System.out.println(GOT + trial);
            }
        }
    }
}
